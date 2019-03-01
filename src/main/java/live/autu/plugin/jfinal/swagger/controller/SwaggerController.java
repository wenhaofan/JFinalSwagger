package live.autu.plugin.jfinal.swagger.controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;

import live.autu.plugin.jfinal.swagger.config.SwaggerPlugin;

/** 
*@author 作者:范文皓
*@createDate 创建时间：2019年2月26日-下午6:41:24 
*/
public class SwaggerController extends Controller {

    public void index() {
        render("index.html");
    }

    public void api() {
        renderJson(JsonKit.toJson(SwaggerPlugin.getDoc()).replaceAll("\"defaultValue\"", "\"default\""));
    }

	
}