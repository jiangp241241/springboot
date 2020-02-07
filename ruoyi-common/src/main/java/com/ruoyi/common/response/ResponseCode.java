package com.ruoyi.common.response;

/**
 * 
 * 遵循部门规范的HTTP返回码的枚举
 * 
 * @author yWX597735
 * @version [V100R002C20, 2019年9月16日]
 * @since [产品/模块版本]
 */
public enum ResponseCode {
	OK(200, "SUCCESS"),

	INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR"),

	CREATED(201, "CREATED"),

	ACCEPTED(202, "ACCEPTED"),

	MOVED_PERMANENTLY(301, "MOVED_PERMANENTLY"),

	SEE_OTHER(303, "SEE_OTHER"),

	NOT_MODIFIED(304, "NOT_MODIFIED"),

	BAD_REQUEST(400, "BAD_REQUEST"),

	UNAUTHORIZED(401, "UNAUTHORIZED"),

	FORBIDDEN(403, "FORBIDDEN"),

	NOT_FOUND(404, "NOT_FOUND"),

	METHOD_NOT_ALLOWED(405, "METHOD_NOT_ALLOWED"),

	GONE(410, "GONE"),

	PRECONDITION_FAILED(412, "PRECONDITION_FAILED"),

	UNSUPPORT_MEDIA_TYPE(415, "UNSUPPORT_MEDIA_TYPE"),

	UNPROCESSABLE_ENTITY(422, "UNPROCESSABLE_ENTITY"),

	TOO_MANY_REQUEST(429, "TOO_MANY_REQUEST"),

	SERVER_UNAVAILABLE(503, "SERVER_UNAVAILABLE");

	/**
	 * code属性
	 */
	private int code;

	/**
	 * desc属性
	 */
	private String desc;

	ResponseCode(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	/**
	 * 方法说明
	 * 
	 * @return 结果信息
	 */
	public int getCode() {
		return this.code;
	}

	/**
	 * 方法说明
	 * 
	 * @return 结果信息
	 */
	public String getDesc() {
		return this.desc;
	}
}