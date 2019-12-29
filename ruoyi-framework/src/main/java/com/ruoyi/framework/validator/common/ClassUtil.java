package com.ruoyi.framework.validator.common;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

/**
 * class工具类
 * */
public class ClassUtil {

	/**
	 * 判断是否为基本数据类型
	 * 
	 * @param data
	 *            入参
	 * @return boolean 判断是否为基本数据类型
	 * */
	public static <T> boolean isBaseType(T data) {
		Class<?> className = data.getClass();
		if (className.equals(Integer.class) || className.equals(Byte.class)
				|| className.equals(Long.class)
				|| className.equals(Double.class)
				|| className.equals(Float.class)
				|| className.equals(Character.class)
				|| className.equals(Short.class)
				|| className.equals(Boolean.class)
				|| className.equals(String.class)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否为数组
	 * 
	 * @param data
	 *            入参
	 * @return boolean 判断是否为数组
	 * */
	public static <T> boolean isArray(T data) {
		boolean flag = data.getClass().isArray();
		return flag;
	}

	/**
	 * 判断是否为map
	 * 
	 * @param data
	 *            入参
	 * @return boolean 判断是否为map
	 * */
	public static <T> boolean isMap(T data) {
		if (data instanceof Map) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否为集合(List,Vector)
	 * 
	 * @param data
	 *            入参
	 * @return boolean 判断是否为集合
	 * */
	public static <T> boolean isCollection(T data) {
		if (data instanceof Collection) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否为对象
	 * 
	 * @param data
	 *            入参
	 * @return boolean 判断是否为对象
	 * */
	public static <T> boolean isObjectVO(T data) {
		boolean isBaseType = isBaseType(data);
		boolean isArray = isArray(data);
		boolean isMap = isMap(data);
		boolean isCollection = isCollection(data);
		boolean isBigDecimal = data instanceof BigDecimal;
		if (isBaseType || isArray || isMap || isCollection || isBigDecimal) {
			return false;
		}
		return true;
	}

}
