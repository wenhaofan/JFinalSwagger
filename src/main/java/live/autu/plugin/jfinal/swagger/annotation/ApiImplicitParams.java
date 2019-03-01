package live.autu.plugin.jfinal.swagger.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
*@author 作者:范文皓
*@createDate 创建时间：2019年2月26日-下午6:48:46 
*/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiImplicitParams {
	ApiImplicitParam[] value();
}
