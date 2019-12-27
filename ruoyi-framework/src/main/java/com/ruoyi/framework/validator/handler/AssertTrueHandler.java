package com.ruoyi.framework.validator.handler;

import com.ruoyi.framework.validator.Exception.ApplicationException;
import com.ruoyi.framework.validator.annotation.AssertTrue;


/**
 * 断言为true处理器
 * */
public class AssertTrueHandler implements BaseHandler {

	/**
	 * 判断值是否为true
	 * */
	@Override
	public <T> void handle(T annotation, T value) throws ApplicationException {
		if (annotation == null) {
			throw new ApplicationException("annotation is null");
		}
		if (!(annotation instanceof AssertTrue)) {
			throw new ApplicationException("annotation type is not AssertTrue");
		}
		AssertTrue assertTrue = (AssertTrue) annotation;
		String description = assertTrue.description();
		if (((Boolean) value) != true) {
			throw new ApplicationException(description);
		}
	}

}
