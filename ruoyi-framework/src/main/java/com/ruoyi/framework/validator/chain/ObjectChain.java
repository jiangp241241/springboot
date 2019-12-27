package com.ruoyi.framework.validator.chain;

import java.lang.annotation.Annotation;

import com.ruoyi.framework.validator.Exception.ApplicationException;
import com.ruoyi.framework.validator.handler.BaseHandler;
import com.ruoyi.framework.validator.handler.HandlerFactory;

public class ObjectChain extends BaseChain {

	@Override
	public <T> void excute(T param) throws ApplicationException {
		if (param == null) {
			return;
		}
		Annotation[] annotations = param.getClass().getAnnotations();
		if (annotations == null || annotations.length == 0) {
			return;
		}
		Annotation annotation = null;
		BaseHandler handler = null;
		for (int i = 0; i < annotations.length; i++) {
			annotation = annotations[i];
			handler = HandlerFactory.createHandler(annotation);
			if (handler == null) {
				continue;
			}
			handler.handle(annotation, param);
		}
	}

}
