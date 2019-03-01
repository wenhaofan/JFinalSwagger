package live.autu.plugin.jfinal.swagger.model;


public class SwaggerResponse {
	
    private String description;

    private SwaggerSchema schema;

    public SwaggerResponse(String description) {
        this.description = description;
    }

    public SwaggerResponse(SwaggerSchema schema) {
        this.schema = schema;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SwaggerSchema getSchema() {
        return schema;
    }

    public void setSchema(SwaggerSchema schema) {
        this.schema = schema;
    }

}
