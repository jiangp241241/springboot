package com.ruoyi.framework.validator.handler;

import java.util.Collection;
import java.util.Map;

import com.ruoyi.framework.validator.Exception.ApplicationException;
import com.ruoyi.framework.validator.annotation.Range;
import com.ruoyi.framework.validator.common.ClassUtil;


/**
 * 断言为true处理器
 * */
public class RangeHandler implements BaseHandler {

	@Override
	public <T> void handle(T annotation, T value) throws ApplicationException {
		if (annotation == null) {
			throw new ApplicationException("annotation is null");
		}
		if (!(annotation instanceof Range)) {
			throw new ApplicationException("annotation type is not Range");
		}
		Range range = (Range) annotation;
		String description = range.description();
		int min = range.min();
		int max = range.max();
		if (value == null) {
			if (min < 0) {
				return;
			}
			throw new ApplicationException(description);
		}
		int valueSize = getSize(value);
		if (valueSize < min) {
			throw new ApplicationException(description);
		}
		if (valueSize > max) {
			throw new ApplicationException(description);
		}
	}

	private <T> int getSize(T value) {
		boolean flag = ClassUtil.isArray(value);
		if (flag) {
			Object[] obj = (Object[]) value;
			return obj.length;
		}
		flag = ClassUtil.isMap(value);
		if (flag) {
			Map<?, ?> obj = (Map<?, ?>) value;
			return obj.size();
		}
		flag = ClassUtil.isCollection(value);
		if (flag) {
			Collection<?> obj = (Collection<?>) value;
			return obj.size();
		}
		throw new ApplicationException("value is not arry or map or collection");
	}
}
