package live.autu.plugin.jfinal.swagger.model;

/**
 * @author 作者:范文皓
 * @createDate 创建时间：2019年2月27日-下午6:21:33
 */
public class SwaggerParameter {
	private String name;
	private String in;
	private String description;
	private boolean required;
	private String type;
	private String defaultValue;

	public SwaggerParameter(String name, String description, boolean required, String type, String defaultValue) {
		this.name = name;
		this.description = description;
		this.required = required;
		this.in = "query";
		this.type = type;

		this.defaultValue = defaultValue;
	}

	public SwaggerParameter(String name, String in, String description, boolean required, String type, String defaultValue) {
		this.name = name;
		this.in = in;
		this.description = description;
		this.required = required;
		this.type = type;

		this.defaultValue = defaultValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIn() {
		return in;
	}

	public void setIn(String in) {
		this.in = in;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
}
