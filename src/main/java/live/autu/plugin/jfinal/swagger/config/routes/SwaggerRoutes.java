package live.autu.plugin.jfinal.swagger.config.routes;

import com.jfinal.config.Routes;

import live.autu.plugin.jfinal.swagger.controller.SwaggerController;

/**
 * 默认路由
 *
 */
public class SwaggerRoutes extends Routes {

    @Override
    public void config() {
        setBaseViewPath("/WEB-INF/view/swagger");
        add("/swagger", SwaggerController.class,"/");
    }

}
