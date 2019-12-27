package com.ruoyi.framework.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
/**
 * 不能为Null注解
 * */
public @interface NotNull {
	/**
	 * 校验失败时候提示语
	 * */
	String description() default " NotNull annotation valid failed";

}
