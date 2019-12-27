package com.ruoyi.framework.validator.handler;

import com.ruoyi.framework.validator.Exception.ApplicationException;


/**
 * base处理器
 * */
public interface BaseHandler {
	/**
	 * 处理业务
	 * */
	public <T> void handle(T annotation, T value) throws ApplicationException;
}
