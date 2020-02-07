package com.ruoyi.common.response;

import java.io.Serializable;

/**
 * REST返回结果的公共基类
 * 
 * @author wwx202712
 * @version UniSTAR HPC V001
 * @see <相关的类或者类的某个方法>
 * @since UniSTAR HPC
 */
public class ResponseVO<T> implements Serializable {
	/**
	 * 955973640389993475L属性
	 */
	private static final long serialVersionUID = 955973640389993475L;

	/**
	 * status属性
	 */
	private int status;

	/**
	 * message属性
	 */
	private String message;

	/**
	 * data属性
	 */
	private T data;

	public ResponseVO() {
		super();
	}

	public ResponseVO(int status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	/**
	 * 服务调用成功，不需要返回数据
	 * 
	 * @return 结果信息
	 */
	public static <T> ResponseVO<T> respOK() {
		return new ResponseVO<T>(ResponseCode.OK.getCode(),
				ResponseCode.OK.getDesc(), null);
	}

	/**
	 * 服务调用成功，返回数据
	 * 
	 * @param data
	 *            data参数变量
	 * @return 结果信息
	 */
	public static <T> ResponseVO<T> respOK(T data) {
		return new ResponseVO<T>(ResponseCode.OK.getCode(),
				ResponseCode.OK.getDesc(), data);
	}

	/**
	 * 服务调用失败，返回通用500异常和通用500异常错误描述
	 * 
	 * @return 结果信息
	 */
	@SuppressWarnings("rawtypes")
	public static ResponseVO respError() {
		return new ResponseVO<String>(
				ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
				ResponseCode.INTERNAL_SERVER_ERROR.getDesc(), null);
	}

	/**
	 * 返回错误，给出msg
	 * 
	 * @param msg
	 *            msg参数变量
	 * @return 结果信息
	 */
	public static <T> ResponseVO<T> respError(String msg) {
		return new ResponseVO<T>(ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
				msg, null);
	}

	/**
	 * 返回错误，给出message，并且还要带data的时候才用这个
	 * 
	 * @param msg
	 *            msg参数变量
	 * @param data
	 *            data参数变量
	 * @return 结果信息
	 */
	public static <T> ResponseVO<T> respError(String msg, T data) {
		return new ResponseVO<T>(ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
				msg, data);
	}

	/**
	 * 返回错误，给出msg
	 * 
	 * @param e
	 *            e参数变量
	 * @return 结果信息
	 */
	public static <T> ResponseVO<T> respError(Exception e) {
		return new ResponseVO<T>(ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
				e.getMessage(), null);
	}

	/**
	 * 返回错误，给出message，并且还要带data的时候才用这个
	 * 
	 * @param e
	 *            e参数变量
	 * @param data
	 *            data参数变量
	 * @return 结果信息
	 */
	public static <T> ResponseVO<T> respError(Exception e, T data) {
		return new ResponseVO<T>(ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
				e.getMessage(), data);
	}

	/**
	 * 方法说明
	 * 
	 * @param code
	 *            code参数变量
	 * @param msg
	 *            msg参数变量
	 * @return 结果信息
	 */
	public static <T> ResponseVO<T> respError(int code, String msg) {
		return new ResponseVO<T>(code, msg, null);
	}

	/**
	 * 返回错误，并且还要带data的时候才用这个
	 * 
	 * @param code
	 *            code参数变量
	 * @param msg
	 *            msg参数变量
	 * @param data
	 *            data参数变量
	 * @return 结果信息
	 */
	public static <T> ResponseVO<T> respError(int code, String msg, T data) {
		return new ResponseVO<T>(code, msg, data);
	}

	/**
	 * 方法说明
	 * 
	 * @return 结果信息
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * 方法说明
	 * 
	 * @param status
	 *            status参数变量
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * 方法说明
	 * 
	 * @return 结果信息
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 方法说明
	 * 
	 * @param message
	 *            message参数变量
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 方法说明
	 * 
	 * @return 结果信息
	 */
	public T getData() {
		return data;
	}

	/**
	 * 方法说明
	 * 
	 * @param data
	 *            data参数变量
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 方法说明
	 * 
	 * @return 结果信息
	 */
	@Override
	public String toString() {
		return "ResponseVO{" + "status=" + status + ", message='" + message
				+ '\'' + ", data=" + data + '}';
	}

}