package com.ruoyi.framework.validator.handler;

import com.ruoyi.framework.validator.Exception.ApplicationException;
import com.ruoyi.framework.validator.annotation.Max;
import com.ruoyi.framework.validator.common.BaseDataTypeUtil;


/**
 * 断言为true处理器
 * */
public class MaxHandler implements BaseHandler {

	@Override
	public <T> void handle(T annotation, T value) throws ApplicationException {
		if (annotation == null) {
			throw new ApplicationException("annotation is null");
		}
		if (!(annotation instanceof Max)) {
			throw new ApplicationException("annotation type is not Max");
		}
		Max max = (Max) annotation;
		String description = max.description();
		String dataType = max.type();
		boolean flag = BaseDataTypeUtil.isBigger(dataType, value + "",
				max.max());
		if (flag) {
			throw new ApplicationException(description);
		}
	}

}
