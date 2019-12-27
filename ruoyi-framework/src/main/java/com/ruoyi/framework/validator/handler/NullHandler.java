package com.ruoyi.framework.validator.handler;

import com.ruoyi.framework.validator.Exception.ApplicationException;
import com.ruoyi.framework.validator.annotation.Null;


/**
 * 断言为true处理器
 * */
public class NullHandler implements BaseHandler {

	@Override
	public <T> void handle(T annotation, T value) throws ApplicationException {
		if (annotation == null) {
			throw new ApplicationException("annotation is null");
		}
		if (!(annotation instanceof Null)) {
			throw new ApplicationException("annotation type is not Null");
		}
		Null null_ = (Null) annotation;
		String description = null_.description();
		if (value != null) {
			throw new ApplicationException(description);
		}
	}

}
