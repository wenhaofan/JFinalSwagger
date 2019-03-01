package live.autu.plugin.jfinal.swagger.model;

/** 
*@author 作者:范文皓
*@createDate 创建时间：2019年2月27日-下午6:32:15 
*/
public class SwaggerItems {
	
	private String $ref;

    public SwaggerItems(String ref) {
        this.$ref = ref;
    }

    public String get$ref() {
        return $ref;
    }

    public void set$ref(String $ref) {
        this.$ref = $ref;
    }
    
}
