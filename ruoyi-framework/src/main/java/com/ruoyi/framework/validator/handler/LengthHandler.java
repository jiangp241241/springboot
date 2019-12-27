package com.ruoyi.framework.validator.handler;

import com.ruoyi.framework.validator.Exception.ApplicationException;
import com.ruoyi.framework.validator.annotation.Length;


/**
 * 断言为true处理器
 * */
public class LengthHandler implements BaseHandler {

	/**
	 * 判断值是否为true
	 * */
	@Override
	public <T> void handle(T annotation, T value) throws ApplicationException {
		if (annotation == null) {
			throw new ApplicationException("annotation is null");
		}
		if (!(annotation instanceof Length)) {
			throw new ApplicationException("annotation type is not Length");
		}
		Length length = (Length) annotation;
		String description = length.description();
		int min = length.min();
		int max = length.max();
		if (value == null) {
			if (min < 0) {
				return;
			} else {
				throw new ApplicationException(description);
			}
		}
		int valueSize = (value + "").length();
		if (valueSize < min) {
			throw new ApplicationException(description);
		}
		if (valueSize > max) {
			throw new ApplicationException(description);
		}
	}

}
