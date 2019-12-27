package com.ruoyi.framework.validator.chain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.framework.validator.Exception.ApplicationException;

/**
 * 过滤链
 * */
public class FilterChain {

	/**
	 * filterChain当前对象（单例模式）
	 * */
	private static FilterChain filterChain = new FilterChain();

	/**
	 * 私有化构造函数，防止new新对象
	 * */
	private FilterChain() {

	}

	/**
	 * 获取实例化对象
	 * */
	public static FilterChain getInstance() {
		return filterChain;
	}

	/**
	 * 过滤不需要校验的数据
	 * */
	public <T> boolean filter(T param) throws ApplicationException {
		if (param instanceof HttpServletResponse) {
			return true;
		}
		if (param instanceof HttpServletRequest) {
			return true;
		}
		return false;
	}
}
