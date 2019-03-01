package live.autu.plugin.jfinal.swagger.config;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jfinal.config.Routes;
import com.jfinal.config.Routes.Route;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.core.NotAction;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.IPlugin;

import live.autu.plugin.jfinal.swagger.annotation.Api;
import live.autu.plugin.jfinal.swagger.annotation.ApiImplicitParam;
import live.autu.plugin.jfinal.swagger.annotation.ApiImplicitParams;
import live.autu.plugin.jfinal.swagger.annotation.ApiOperation;
import live.autu.plugin.jfinal.swagger.annotation.ApiParam;
import live.autu.plugin.jfinal.swagger.model.SwaggerApiInfo;
import live.autu.plugin.jfinal.swagger.model.SwaggerApiMethod;
import live.autu.plugin.jfinal.swagger.model.SwaggerParameter;
import live.autu.plugin.jfinal.swagger.model.SwaggerDoc;

/**
 * @author 作者:范文皓
 * @createDate 创建时间：2019年2月26日-下午6:12:24
 */
public class SwaggerPlugin implements IPlugin {

	private static SwaggerDoc doc;

	private String configPath = "swagger.txt";

	private Prop p;

	private Prop loadProp() {
		p = PropKit.use(configPath);
		return p;
	}

	public SwaggerPlugin() {
		super();
	}

	public SwaggerPlugin(SwaggerDoc doc) {
		super();
		SwaggerPlugin.doc = doc;
	}

	public SwaggerPlugin(String configPath) {
		super();
		this.configPath = configPath;
	}

	public static SwaggerDoc getDoc() {
		return doc;
	}

	public static String getDocApiPath() {
		return SwaggerContant.docApiPath;
	}

	public static void setDocApiPath(String docApiPath) {
		SwaggerContant.docApiPath = docApiPath;
	}

	@Override
	public boolean start() {

		loadProp();

		initSwaggerDoc();

		initDocApiPath();

		List<Route> routeList = getAllRouteList();

		Map<String, Map<String, SwaggerApiMethod>> paths = new HashMap<>();

		Route route = null;

		Set<String> excludedMethod = buildExcludedMethodName();

		for (int i = 0, size = routeList.size(); i < size; i++) {

			route = routeList.get(i);

			Class<? extends Controller> cls = route.getControllerClass();

			if (!cls.isAnnotationPresent(Api.class)) {
				continue;
			}

			Api api = cls.getAnnotation(Api.class);

			if (api.hidden()) {
				continue;
			}

			Method[] methods = cls.getDeclaredMethods();

			for (Method method : methods) {

				if (excludedMethod.contains(method.getName())) {
					continue;
				}

				// 如果标记为NotAction则跳过
				if (method.isAnnotationPresent(NotAction.class)) {
					continue;
				}

				ApiOperation apiOperation = getApiOperation(method);

				if (apiOperation.hidden()) {
					continue;
				}

				SwaggerApiMethod apiMethod = getApiMethod(method, apiOperation, cls);

				Map<String, SwaggerApiMethod> methodMap = initMethodMap(method, apiMethod);
				String actionUrl = getActionUrl(route, method, apiOperation);
				paths.put(actionUrl, methodMap);
			}

			addApiTags(cls, api);
		}

		doc.setPaths(paths);

		return true;
	}

	private String getApiMethodDefaultTag(Class<? extends Controller> cls, Api api) {
		String defaultApiMethodTag = getDefaultTag(cls, api);
		return defaultApiMethodTag;
	}

	private List<Route> getAllRouteList() {
		List<Routes> routesList = Routes.getRoutesList();

		List<Route> routeList = new ArrayList<>();

		for (Routes routes : routesList) {
			routeList.addAll(routes.getRouteItemList());
		}
		return routeList;
	}

	private void initDocApiPath() {
		if (StrKit.isBlank(getDocApiPath())) {
			setDocApiPath(p.get("docApiPath"));
		}
	}

	private void initSwaggerDoc() {
		if (doc == null) {
			doc = loadConfigSwaggerDoc();
		}

		if (doc.getInfo() == null) {
			SwaggerApiInfo apiInfo = loadConfigApiInfo();
			doc.setInfo(apiInfo);
		}
	}

	private ApiOperation getApiOperation(Method method) {
		ApiOperation apiOperation = (ApiOperation) method.getAnnotation(ApiOperation.class);

		if (apiOperation == null) {
			apiOperation = SwaggerContant.defaultApiOperation;
		}
		return apiOperation;
	}

	private String addApiTags(Class<? extends Controller> cls, Api api) {
		String apiDescription = api.description();
		if (apiDescription.length() == 0) {
			if (api.tags().length == 1) {
				apiDescription = api.tags()[0];
			} else {
				apiDescription = cls.getSimpleName();
			}
		}

		for (String tagName : api.tags()) {
			doc.addTag(tagName, apiDescription);
		}
		if (api.tags().length == 0) {
			doc.addTag(cls.getSimpleName(), apiDescription);
		}
		return apiDescription;
	}

	private String getDefaultTag(Class<? extends Controller> cls, Api api) {
		String defaultApiMethodTag = api.value();

		if (StrKit.isBlank(defaultApiMethodTag)) {
			defaultApiMethodTag = cls.getSimpleName();
		}
		return defaultApiMethodTag;
	}

	private String getActionUrl(Route route, Method method, ApiOperation apiOperation) {

		if (StrKit.notBlank(apiOperation.value())) {
			return apiOperation.value();
		}

		ActionKey actionKey = method.getAnnotation(ActionKey.class);

		if (actionKey != null) {
			return actionKey.value();
		}

		StringBuffer path = new StringBuffer();
		path.append(route.getControllerKey()).append("/").append(method.getName());
		return path.toString();
	}

	private SwaggerApiMethod getApiMethod(Method method, ApiOperation apiOperation, Class<? extends Controller> cls) {
		SwaggerApiMethod apiMethod = getApiMethodAndParms(method);

		apiMethod.setProduces(apiOperation.produces());
		apiMethod.setTags(apiOperation.tags());

		apiMethod.setSummary(apiOperation.description());
		apiMethod.setDescription(apiOperation.description());
		apiMethod.setConsumes(apiOperation.consumes());

		Api api = cls.getAnnotation(Api.class);

		if (api == null) {
			return apiMethod;
		}

		if (apiMethod.getTags() == null || apiMethod.getTags().length == 0) {
			apiMethod.setTags(new String[] { getApiMethodDefaultTag(cls, api) });
		}

		return apiMethod;
	}

	private SwaggerApiMethod getApiMethodAndParms(Method method) {

		SwaggerApiMethod apiMethod = new SwaggerApiMethod();

		addApiImplicitParams(method, apiMethod);

		ApiParam[] apiParams = method.getAnnotationsByType(ApiParam.class);

		for (ApiParam apiParam : apiParams) {

			SwaggerParameter para = null;
			if (("file").equals(apiParam.dataType())) {
				para = getFilePara(apiParam);
			} else {
				para = getPara(apiParam);
			}

			apiMethod.addParameter(para);

		}
		return apiMethod;
	}

	private void addApiImplicitParams(Method method, SwaggerApiMethod apiMethod) {
		ApiImplicitParams[] apiImplicitParamsArr = method.getAnnotationsByType(ApiImplicitParams.class);

		if (apiImplicitParamsArr == null) {
			return;
		}
		for (ApiImplicitParams apiImplicitParams : apiImplicitParamsArr) {
			ApiImplicitParam[] params = apiImplicitParams.value();
			for (ApiImplicitParam apiParam : params) {
				SwaggerParameter para = null;
				if (("file").equals(apiParam.dataType())) {
					para = getFilePara(apiParam);
				} else {
					para = getPara(apiParam);
				}
				apiMethod.addParameter(para);
			}
		}

	}

	protected Set<String> buildExcludedMethodName() {
		Set<String> excludedMethodName = new HashSet<String>();
		Method[] methods = Controller.class.getMethods();
		for (Method m : methods) {
			// if (m.getParameterTypes().length == 0)
			excludedMethodName.add(m.getName());
		}
		return excludedMethodName;
	}

	private SwaggerParameter getFilePara(ApiImplicitParam apiParam) {
		return new SwaggerParameter(apiParam.name(), "formData", apiParam.description(), apiParam.required(),
				apiParam.dataType(), apiParam.defaultValue());
	}

	private SwaggerParameter getFilePara(ApiParam apiParam) {
		return new SwaggerParameter(apiParam.name(), apiParam.description(), apiParam.required(), apiParam.dataType(),
				apiParam.defaultValue());
	}

	private SwaggerParameter getPara(ApiImplicitParam apiParam) {
		return new SwaggerParameter(apiParam.name(), apiParam.description(), apiParam.required(), apiParam.dataType(),
				apiParam.defaultValue());
	}

	private SwaggerParameter getPara(ApiParam apiParam) {
		return new SwaggerParameter(apiParam.name(), apiParam.description(), apiParam.required(), apiParam.dataType(),
				apiParam.defaultValue());
	}

	private Map<String, SwaggerApiMethod> initMethodMap(Method method, SwaggerApiMethod apiMethod) {
		ApiOperation apiOperation = getApiOperation(method);

		RequestMethod[] requestMethods = apiOperation.methods();

		if (requestMethods == null || requestMethods.length == 0) {
			requestMethods = RequestMethod.all();
		}

		return getMethodMap(requestMethods, apiMethod, method.getName());
	}

	private Map<String, SwaggerApiMethod> getMethodMap(RequestMethod[] methods, SwaggerApiMethod apiMethod, String methodName) {

		Map<String, SwaggerApiMethod> methodMap = new HashMap<>();

		SwaggerApiMethod putApiMethod = null;
		for (RequestMethod requestMethod : methods) {

			try {
				putApiMethod = (SwaggerApiMethod) apiMethod.clone();
				putApiMethod.setOperationId(methodName.concat("Using").concat(requestMethod.toString()));
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			methodMap.put(requestMethod.toString(), putApiMethod);
		}
		return methodMap;
	}

	private SwaggerApiInfo loadConfigApiInfo() {
		String infoDescription = p.get("info.description");
		String infoVersion = p.get("info.version");
		String infoTitle = p.get("info.title");
		String infoTermsOfService = p.get("info.termsOfService");

		SwaggerApiInfo apiInfo = new SwaggerApiInfo(infoDescription, infoVersion, infoTitle, infoTermsOfService);
		return apiInfo;
	}

	private SwaggerDoc loadConfigSwaggerDoc() {
		SwaggerDoc swaggerDoc = new SwaggerDoc();

		String basePath = p.get("basePath");
		String host = p.get("host");
		String version = p.get("version");
		swaggerDoc.setBasePath(basePath);
		swaggerDoc.setHost(host);
		swaggerDoc.setSwagger(version);
		return swaggerDoc;
	}

	@Override
	public boolean stop() {
		// TODO Auto-generated method stub
		return true;
	}

}
