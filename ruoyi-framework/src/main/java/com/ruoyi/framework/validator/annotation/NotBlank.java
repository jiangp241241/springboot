package com.ruoyi.framework.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
/**
 * 非空注解（null和空字符都认为是空）
 * */
public @interface NotBlank {
	/**
	 * 校验失败时候提示语
	 * */
	String description() default " NotBlank annotation valid failed";

}
