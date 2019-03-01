package live.autu.plugin.jfinal.swagger.model;

/**
 * @author 作者:范文皓
 * @createDate 创建时间：2019年2月27日-下午6:32:48
 */
public class SwaggerSchema {
	private String type;
	private SwaggerItems items;

	public SwaggerSchema(String type, SwaggerItems items) {
		this.type = type;
		this.items = items;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public SwaggerItems getItems() {
		return items;
	}

	public void setItems(SwaggerItems items) {
		this.items = items;
	}
}
