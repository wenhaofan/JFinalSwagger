package live.autu.plugin.jfinal.swagger.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwaggerDoc {

	private List<SwaggerTag> tags=new ArrayList<>();
	
	/**
	 * 版本号
	 */
	private String swagger;

	private SwaggerApi info;

	private String host;

	private String basePath;

	private List<String> schemes = new ArrayList<>();

	private Map<String, Map<String, SwaggerApiMethod>> paths = new HashMap<>();
 
	

	public SwaggerDoc addTag(String name,String description) {
		tags.add(new SwaggerTag(name, description));
		return this;
	}
	
	public List<SwaggerTag> getTags() {
		return tags;
	}

	public void setTags(List<SwaggerTag> tags) {
		this.tags = tags;
	}

	public String getSwagger() {
		return swagger;
	}

	public void setSwagger(String swagger) {
		this.swagger = swagger;
	}

	public SwaggerApi getInfo() {
		return info;
	}

	public void setInfo(SwaggerApi info) {
		this.info = info;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public List<String> getSchemes() {
		return schemes;
	}

	public void setSchemes(List<String> schemes) {
		this.schemes = schemes;
	}

	public Map<String, Map<String, SwaggerApiMethod>> getPaths() {
		return paths;
	}

	public void setPaths(Map<String, Map<String, SwaggerApiMethod>> paths) {
		this.paths = paths;
	}

	public SwaggerDoc addScheme(String scheme) {
		schemes.add(scheme);
		return this;
	}

}
