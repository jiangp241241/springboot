package com.ruoyi.framework.validator.Exception;

/**
 * 异常严重级别常量
 */
public interface ApplicationExceptionSeverity {

	/** 轻微 */
	int MINOR = 1;

	/** 一般 */
	int NORMAL = 2;

	/** 重要 */
	int MAJOR = 3;

	/** 严重 */
	int CRITICAL = 4;
}
