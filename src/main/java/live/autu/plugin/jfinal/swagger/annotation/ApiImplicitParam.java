package live.autu.plugin.jfinal.swagger.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 作者:范文皓
 * @createDate 创建时间：2019年2月26日-下午6:49:07
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiImplicitParam {
    /**
     * 参数名称
     * @return
     */
	String name() default "";
	/**
	 * 参数描述
	 * @return
	 */
	String description() default "";
    /**
     * 是否必须
     * @return
     */
	boolean required() default false;
	/**
	 * 参数类型
	 * @return
	 */
	String dataType() default "";
	/**
	 * 默认值
	 * @return
	 */
	String defaultValue() default "";
}
