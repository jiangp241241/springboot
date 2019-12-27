package com.ruoyi.framework.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
/**
 * 断言false注解，被注释的值必须为false
 * */
public @interface AssertFalse {
	/**
	 * 校验失败时候提示语
	 * */
	String description() default " value must be false";

}
