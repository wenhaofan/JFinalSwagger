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

	private SwaggerApiInfo info;

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

	public SwaggerDoc setSwagger(String swagger) {
		this.swagger = swagger;
		return this;
	}

	public SwaggerApiInfo getInfo() {
		return info;
	}

	public SwaggerDoc setInfo(SwaggerApiInfo info) {
		this.info = info;
		return this;
	}

	public String getHost() {
		return host;
	}

	public SwaggerDoc setHost(String host) {
		this.host = host;
		return this;
	}

	public String getBasePath() {
		return basePath;
	}

	public SwaggerDoc setBasePath(String basePath) {
		this.basePath = basePath;
		return this;
	}

	public List<String> getSchemes() {
		return schemes;
	}

	public SwaggerDoc setSchemes(List<String> schemes) {
		this.schemes = schemes;
		return this;
	}

	public Map<String, Map<String, SwaggerApiMethod>> getPaths() {
		return paths;
	}

	public SwaggerDoc setPaths(Map<String, Map<String, SwaggerApiMethod>> paths) {
		this.paths = paths;
		return this;
	}

	public SwaggerDoc addScheme(String scheme) {
		schemes.add(scheme);
		return this;
	}

}
