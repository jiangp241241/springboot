package com.ruoyi.framework.validator.chain;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.ruoyi.framework.validator.ValidatorUtil;
import com.ruoyi.framework.validator.Exception.ApplicationException;
import com.ruoyi.framework.validator.common.ClassUtil;
import com.ruoyi.framework.validator.handler.BaseHandler;
import com.ruoyi.framework.validator.handler.HandlerFactory;
/**
 * 属性链
 * */
public class FiledChain extends BaseChain {

	@Override
	public <T> void excute(T param) throws ApplicationException {
		if (param == null) {
			return;
		}
		if (!ClassUtil.isObjectVO(param)) {
			return;
		}
		// 字段上的注解
		Field[] fields = param.getClass().getDeclaredFields();
		Field field = null;
		Annotation[] filedAnnotations = null;
		BaseHandler handler = null;
		Object filedValue = null;
		for (int i = 0; i < fields.length; i++) {
			field = fields[i];
			field.setAccessible(true);
			try {
				filedValue = field.get(param);
				ValidatorUtil.valid(filedValue);
			} catch (Exception e) {
				throw new ApplicationException(e.getMessage());
			}
			filedAnnotations = field.getDeclaredAnnotations();
			if (filedAnnotations == null || filedAnnotations.length == 0) {
				continue;
			}
			for (Annotation annotation : filedAnnotations) {
				handler = HandlerFactory.createHandler(annotation);
				if (handler == null) {
					continue;
				}
				handler.handle(annotation, filedValue);
			}
		}

	}

}
