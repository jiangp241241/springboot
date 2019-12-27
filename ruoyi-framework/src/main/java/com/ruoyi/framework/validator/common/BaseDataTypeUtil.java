package com.ruoyi.framework.validator.common;

import java.math.BigDecimal;

/**
 * 基础数据类型工具类
 * */
public class BaseDataTypeUtil {

	/**
	 * 当前数据是否小一点
	 * 
	 * @param dataType数据类型
	 *            ( int, float,double等)
	 * @param value1
	 *            当前数据
	 * @param value2
	 *            比较的数据
	 * @return boolean 是否小一点
	 * */
	public static boolean isSmaller(String dataType, String value1,
			String value2) {
		Boolean flag = null;
		Integer result = null;
		if (BaseDataConstant.INT.equals(dataType)) {
			flag = Integer.parseInt(value1) < Integer.parseInt(value2);
		} else if (BaseDataConstant.SHORT.equals(dataType)) {
			flag = Short.parseShort(value1) < Short.parseShort(value2);
		} else if (BaseDataConstant.LONG.equals(dataType)) {
			flag = Long.parseLong(value1) < Long.parseLong(value2);
		} else if (BaseDataConstant.FLOAT.equals(dataType)) {
			flag = Float.parseFloat(value1) < Float.parseFloat(value2);
		} else if (BaseDataConstant.DOUBLE.equals(dataType)) {
			flag = Double.valueOf(value1) < Double.valueOf(value2);
		} else if (BaseDataConstant.BIG_DECIMAL.equals(dataType)) {
			if ("null".equals(value1)) {
				result = new BigDecimal(0).compareTo(new BigDecimal(value2));
			} else {
				result = new BigDecimal(value1)
						.compareTo(new BigDecimal(value2));
			}
			if (result == -1) {
				flag = true;
			} else {
				flag = false;
			}
		} else {
			flag = Integer.parseInt(value1) < Integer.parseInt(value2);
		}
		return flag;
	}

	/**
	 * 当前数据是否大一点
	 * 
	 * @param dataType数据类型
	 *            ( int, float,double等)
	 * @param value1
	 *            当前数据
	 * @param value2
	 *            比较的数据
	 * @return boolean 是否小一点
	 * */
	public static boolean isBigger(String dataType, String value1, String value2) {
		Boolean flag = null;
		Integer result = null;
		if (BaseDataConstant.INT.equals(dataType)) {
			flag = Integer.parseInt(value1) > Integer.parseInt(value2);
		} else if (BaseDataConstant.SHORT.equals(dataType)) {
			flag = Short.parseShort(value1) > Short.parseShort(value2);
		} else if (BaseDataConstant.LONG.equals(dataType)) {
			flag = Long.parseLong(value1) > Long.parseLong(value2);
		} else if (BaseDataConstant.FLOAT.equals(dataType)) {
			flag = Float.parseFloat(value1) > Float.parseFloat(value2);
		} else if (BaseDataConstant.DOUBLE.equals(dataType)) {
			flag = Double.valueOf(value1) > Double.valueOf(value2);
		} else if (BaseDataConstant.BIG_DECIMAL.equals(dataType)) {
			if ("null".equals(value1)) {
				result = new BigDecimal(0).compareTo(new BigDecimal(value2));
			} else {
				result = new BigDecimal(value1)
						.compareTo(new BigDecimal(value2));
			}
			if (result == 1) {
				flag = true;
			} else {
				flag = false;
			}
		} else {
			flag = Integer.parseInt(value1) > Integer.parseInt(value2);
		}
		return flag;
	}
}
