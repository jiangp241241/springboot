package com.ruoyi.framework.validator.handler;

import com.ruoyi.framework.validator.Exception.ApplicationException;
import com.ruoyi.framework.validator.annotation.AssertFalse;


/**
 * 断言为false处理器
 * */
public class AssertFalseHandler implements BaseHandler {

	/**
	 * 判断值是否为false
	 * */
	@Override
	public <T> void handle(T annotation, T value) throws ApplicationException {
		if (annotation == null) {
			throw new ApplicationException("annotation is null");
		}
		if (!(annotation instanceof AssertFalse)) {
			throw new ApplicationException("annotation type is not AssertFalse");
		}
		AssertFalse assertFalse = (AssertFalse) annotation;
		String description = assertFalse.description();
		if (((Boolean) value) != false) {
			throw new ApplicationException(description);
		}
	}

}
