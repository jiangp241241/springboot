package com.ruoyi.framework.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
/**
 * 正则表达式注解
 * */
public @interface Pattern {

	/**
	 * 正则表达式
	 * */
	String regex();

	/**
	 * 标识符，是否反转结果(flag=true不反转，flag=false 反转)
	 * */
	boolean flag() default true;

	/**
	 * 校验失败时候提示语
	 * */
	String description() default " Pattern annotation valid failed";

}
