package live.autu.plugin.jfinal.swagger.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import live.autu.plugin.jfinal.swagger.config.RequestMethod;

/**
 * @author 作者:范文皓
 * @createDate 创建时间：2019年2月26日-下午6:46:43
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiOperation {

	/**
	 * url的路径值,如为空则通过 Route进行自动获取url
	 * 
	 * @return
	 */
	String value() default "";

	String[] produces() default {"*/*"};
	
	/**
	 * 如果设置这个值、value的值不会被覆盖
	 * @return
	 */
	String[] tags() default {};
 
	/**
	 * 请求类型
	 * @return
	 */
	RequestMethod[] methods() default {};

	/**
	 * 对api资源的描述
	 * 
	 * @return
	 */
	String description() default "";

	/**
	 * For example, "application/json, application/xml"
	 * 
	 * @return
	 */
	String[] consumes() default {"application/json"};

	 /**
     * 是否显示
     */
    boolean hidden()  default false;
}
