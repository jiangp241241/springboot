package com.ruoyi.framework.validator.chain;

import com.ruoyi.framework.validator.Exception.ApplicationException;


/**
 * 责任链抽象类
 * */
public abstract class BaseChain {
	/**
	 * 校验参数
	 * 
	 * @param param
	 * @return void 返回结果
	 * @throws ApplicationException
	 *             抛出异常
	 * */
	public abstract <T> void excute(T param) throws ApplicationException;

	/**
	 * 校验入参方法
	 * */
	public <T> void handle(T param) throws ApplicationException {
		boolean flag = FilterChain.getInstance().filter(param);
		if (flag) {
			return;
		}
		excute(param);
	}
}
