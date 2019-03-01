package live.autu.plugin.jfinal.swagger.model;

/**
 * @author 作者:范文皓
 * @createDate 创建时间：2019年2月27日-下午6:29:48
 */
public class SwaggerApiInfo {
	
	private String description;
	private String version;
	private String title;
	private String termsOfService;

	public SwaggerApiInfo(String description, String version, String title, String termsOfService) {
		this.description = description;
		this.version = version;
		this.title = title;
		this.termsOfService = termsOfService;
	}

	public String getDescription() {
		return description;
	}

	public SwaggerApiInfo setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getVersion() {
		return version;
	}

	public SwaggerApiInfo setVersion(String version) {
		this.version = version;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public SwaggerApiInfo setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getTermsOfService() {
		return termsOfService;
	}

	public SwaggerApiInfo setTermsOfService(String termsOfService) {
		this.termsOfService = termsOfService;
		return this;
	}
}
