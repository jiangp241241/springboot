package com.ruoyi.framework.validator.Exception;

/**
 * 业务异常
 * */
public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 4862043746504149226L;

	/** 严重级别 */
	protected int severity = ApplicationExceptionSeverity.NORMAL;

	/**
	 * 空构造器。
	 */
	public ApplicationException() {
		super();
	}

	/**
	 * 构造器。
	 * 
	 * @param severity
	 *            严重级别
	 */
	public ApplicationException(int severity) {
		super();

		this.severity = severity;
	}

	/**
	 * 构造器。
	 * 
	 * @param message
	 *            消息
	 */
	public ApplicationException(String message) {
		super(message);
	}

	/**
	 * 构造器。
	 * 
	 * @param message
	 *            消息
	 * @param severity
	 *            严重级别
	 */
	public ApplicationException(String message, int severity) {
		super(message);

		this.severity = severity;
	}

	/**
	 * 构造器。
	 * 
	 * @param cause
	 *            原因
	 */
	public ApplicationException(Throwable cause) {
		super(cause);
	}

	/**
	 * 构造器。
	 * 
	 * @param cause
	 *            原因
	 * @param severity
	 *            严重级别
	 */
	public ApplicationException(Throwable cause, int severity) {
		super(cause);

		this.severity = severity;
	}

	/**
	 * 构造器。
	 * 
	 * @param message
	 *            消息
	 * @param cause
	 *            原因
	 */
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 构造器。
	 * 
	 * @param message
	 *            消息
	 * @param cause
	 *            原因
	 * @param severity
	 *            严重级别
	 */
	public ApplicationException(String message, Throwable cause, int severity) {
		super(message, cause);

		this.severity = severity;
	}

	/**
	 * @return Returns the severity.
	 */
	public int getSeverity() {
		return severity;
	}

	/**
	 * @see java.lang.Throwable#toString()
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(super.toString()).append(" - severity: ");

		switch (severity) {
		case ApplicationExceptionSeverity.MINOR:
			buffer.append("MINOR");
			break;

		case ApplicationExceptionSeverity.NORMAL:
			buffer.append("NORMAL");
			break;

		case ApplicationExceptionSeverity.MAJOR:
			buffer.append("MAJOR");
			break;

		case ApplicationExceptionSeverity.CRITICAL:
			buffer.append("CRITICAL");
			break;

		default:
			buffer.append("UNKNOWN");
		}

		buffer.append("(").append(severity).append(")");

		return buffer.toString();
	}
}
