package com.ruoyi.framework.validator.handler;

import com.ruoyi.framework.validator.Exception.ApplicationException;
import com.ruoyi.framework.validator.annotation.NotBlank;


/**
 * 断言为true处理器
 * */
public class NotBlankHandler implements BaseHandler {

	@Override
	public <T> void handle(T annotation, T value) throws ApplicationException {
		if (annotation == null) {
			throw new ApplicationException("annotation is null");
		}
		if (!(annotation instanceof NotBlank)) {
			throw new ApplicationException("annotation type is not NotBlank");
		}
		NotBlank notBlank = (NotBlank) annotation;
		String description = notBlank.description();
		if (value == null || "".equals(value.toString())) {
			throw new ApplicationException(description);
		}
	}

}
