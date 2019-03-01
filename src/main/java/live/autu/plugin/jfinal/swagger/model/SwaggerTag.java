package live.autu.plugin.jfinal.swagger.model;

/**
 * @author 作者:范文皓
 * @createDate 创建时间：2019年2月27日-下午6:28:46
 */
public class SwaggerTag {
	
	private String name;
	private String description;

	public SwaggerTag(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
