### JFinalSwagger使用说明 

**1. 引入**
```
    <dependency>
        <groupId>live.autu</groupId>
        <artifactId>jfinal-swagger</artifactId>
        <version>1.0.0</version>
    </dependency>
```

**2. 下载 swagger-ui-master 将 dist 中文件加入到项目中**

```
可配置成类似如下路径：
    webapp
        static
            swagger
                favicon-16x16.png
                ...
                swagger-ui.js.map
    WEB-INF
        views
            swagger
                index.html
```

**3. 增加Swagger路由控制**

```

    以第二步的形式配置的目录结构，可直接使用如下路由配置
    
    routes.add(new SwaggerRoutes());
    
    也可自行配置路由信息
    
    public class SwaggerRoutes extends Routes {
    
        @Override
        public void config() {
            setBaseViewPath("/WEB-INF/views");
            add("/swagger", SwaggerController.class);
        }
    
    }

```

**4. 参数配置**

```

  @Override
	public void configPlugin(Plugins me) {
    me.add(new SwaggerPlugin(new SwaggerDoc()));
  }
  
``` 

  添加配置文件  :swagger.txt
  
``` 

  basePath=/
  host=127.0.0.1:8080
  version=2.0
  info.description=测试jfinal swagger
  info.version=1.0
  info.title=测试
  
```  
  喜欢代码配置也可以使用代码配置
```  
 @Override
	public void configPlugin(Plugins me) {
		me.add(new SwaggerPlugin(new SwaggerDoc().setBasePath("/").setHost("127.0.0.1").setSwagger("2.0")
				.setInfo(new SwaggerApiInfo("jfinal swagger demo", "1.0", "jfinal swagger", ""))));
	}
 ```
**5. 添加注解**

```
    提供五种注解，使用方式与swagger-annotation一致：
    
    @Api
    
    @ApiOperation
    
    @Param
    
    @ApiImplicitParams
    
    @ApiImplicitParam
    
    更多注解支出持续更新中
    
```


注解使用示例：

```java

@Api(tag = "test", description = "测试")
public class BlogController extends Controller {

    @ApiOperation(tag = "index", httpMethod = RequestMethod.GET , description = "测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", description = "编号", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "name", description = "姓名", required = true, dataType = "String")
    })
    public void test() {
        renderJson(list);
    }
}
    
```

**6.说明**

该插件会自动读取Route配置以及@ActionKey所以无需配置url
    


