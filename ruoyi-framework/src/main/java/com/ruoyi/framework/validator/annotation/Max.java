package com.ruoyi.framework.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
/**
 * 最大值注解
 * */
public @interface Max {

	/**
	 * 最大值
	 * */
	String max();

	/**
	 * 数据类型
	 * */
	String type();

	/**
	 * 校验失败时候提示语
	 * */
	String description() default " Max annotation valid failed";

}
