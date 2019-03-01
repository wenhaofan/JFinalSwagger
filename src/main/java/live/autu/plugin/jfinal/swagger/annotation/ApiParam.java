package live.autu.plugin.jfinal.swagger.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 参数
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiParam {
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
