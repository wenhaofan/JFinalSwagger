package live.autu.plugin.jfinal.swagger.model;

/**
 * @author 作者:范文皓
 * @createDate 创建时间：2019年2月27日-下午6:29:48
 */
public class SwaggerApi {
	
	private String description;
	private String version;
	private String title;
	private String termsOfService;

	public SwaggerApi(String description, String version, String title, String termsOfService) {
		this.description = description;
		this.version = version;
		this.title = title;
		this.termsOfService = termsOfService;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTermsOfService() {
		return termsOfService;
	}

	public void setTermsOfService(String termsOfService) {
		this.termsOfService = termsOfService;
	}
}
