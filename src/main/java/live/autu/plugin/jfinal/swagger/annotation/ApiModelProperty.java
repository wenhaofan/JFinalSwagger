package live.autu.plugin.jfinal.swagger.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
*@author 作者:范文皓
*@createDate 创建时间：2019年2月26日-下午6:51:09 
*/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiModelProperty {

}
