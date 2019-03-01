package live.autu.plugin.jfinal.swagger.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
* @author 作者:范文皓
* @createDate 创建时间：2019年2月27日-下午7:06:09 
*/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiResponses {
	ApiResponse[] value();
}
