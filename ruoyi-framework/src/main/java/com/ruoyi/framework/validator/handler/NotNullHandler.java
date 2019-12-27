package com.ruoyi.framework.validator.handler;

import com.ruoyi.framework.validator.Exception.ApplicationException;
import com.ruoyi.framework.validator.annotation.NotNull;


/**
 * 断言为true处理器
 * */
public class NotNullHandler implements BaseHandler {

	@Override
	public <T> void handle(T annotation, T value) throws ApplicationException {
		if (annotation == null) {
			throw new ApplicationException("annotation is null");
		}
		if (!(annotation instanceof NotNull)) {
			throw new ApplicationException("annotation type is not NotNull");
		}
		NotNull notNull = (NotNull) annotation;
		String description = notNull.description();
		if (value == null) {
			throw new ApplicationException(description);
		}
	}

}
