package com.ruoyi.framework.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
/**
 * 字符串长度注解
 * */
public @interface Length {

	/**
	 * 字符串最小长度
	 * */
	int min() default -1;

	/**
	 * 字符串最大长度
	 * */
	int max() default Integer.MAX_VALUE;

	/**
	 * 校验失败时候提示语
	 * */
	String description() default " Length annotation valid failed";

}
