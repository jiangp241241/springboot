package com.ruoyi.framework.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
/**
 * 集合个数注解
 * */
public @interface Range {

	/**
	 * 最小值
	 * */
	int min() default -1;

	/**
	 * 最大值
	 * */
	int max() default Integer.MAX_VALUE;
	
	/**
	 * 校验失败时候提示语
	 * */
	String description() default " Range annotation valid failed";

}
