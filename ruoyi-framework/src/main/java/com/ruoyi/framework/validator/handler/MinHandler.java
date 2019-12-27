package com.ruoyi.framework.validator.handler;

import com.ruoyi.framework.validator.Exception.ApplicationException;
import com.ruoyi.framework.validator.annotation.Min;
import com.ruoyi.framework.validator.common.BaseDataTypeUtil;


/**
 * 断言为true处理器
 * */
public class MinHandler implements BaseHandler {

	@Override
	public <T> void handle(T annotation, T value) throws ApplicationException {
		if (annotation == null) {
			throw new ApplicationException("annotation is null");
		}
		if (!(annotation instanceof Min)) {
			throw new ApplicationException("annotation type is not Min");
		}
		Min min = (Min) annotation;
		String description = min.description();
		String dataType = min.type();
		boolean flag = BaseDataTypeUtil.isSmaller(dataType, value + "",
				min.min());
		if (flag) {
			throw new ApplicationException(description);
		}
	}

}
