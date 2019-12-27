package com.ruoyi.framework.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.ruoyi.framework.validator.Exception.ApplicationException;
import com.ruoyi.framework.validator.handler.BaseHandler;
import com.ruoyi.framework.validator.handler.HandlerFactory;

/**
 * 操作日志记录处理
 * 
 * @author ruoyi
 */
@Aspect
@Component
public class ServiceValidatorAspect {

	private static final Logger log = LoggerFactory
			.getLogger(ServiceValidatorAspect.class);

	@Around("execution(* com.ruoyi..controller..*.*(..))")
	public Object around(ProceedingJoinPoint pjd) {
		Object result = null;
		try {
			validParam(pjd);
		} catch (Exception e) {
			return e.getMessage();
		}
		try {
			result = pjd.proceed();
		} catch (Throwable e) {
			throw new ApplicationException(e.getMessage());
		}
		return result;
	}

	/**
	 * 校验参数
	 * 
	 * @param pjd拦截对象
	 * */
	private void validParam(ProceedingJoinPoint pjd)
			throws ApplicationException {
		Object[] args = pjd.getArgs();
		if (args == null || args.length == 0) {
			return;
		}
		Method method = getMethod(pjd);
		if (method != null) {
			validMethod(method, args);
		}
		valudParamValue(args);
	}

	/**
	 * 校验每个入参值
	 * */
	private void valudParamValue(Object[] args) {
		for (Object obj : args) {
			ValidatorUtil.valid(obj);
		}
	}

	/**
	 * 校验方法里每个参数上注解
	 * 
	 * @param method
	 *            要获取参数的方法
	 * @return args 每个入参的值
	 * */
	private void validMethod(Method method, Object[] args) {
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		if (parameterAnnotations == null || parameterAnnotations.length == 0) {
			return;
		}
		Object value = null;
		BaseHandler handler = null;
		Annotation[] parameterAnnotation = null;
		for (int i = 0; i < parameterAnnotations.length; i++) {
			value = args[i];
			parameterAnnotation = parameterAnnotations[i];
			for (Annotation annotation : parameterAnnotation) {
				handler = HandlerFactory.createHandler(annotation);
				if (handler == null) {
					continue;
				}
				handler.handle(annotation, value);
			}
		}
	}

	/**
	 * 获取代理方法
	 * */
	private Method getMethod(ProceedingJoinPoint pjd) {
		String classType = pjd.getTarget().getClass().getName();
		Class<?> clazz = null;
		Method method = null;
		String methodName = null;
		Class<?>[] parameterTypes = null;
		try {
			clazz = Class.forName(classType);
			parameterTypes = ((MethodSignature) pjd.getSignature()).getMethod()
					.getParameterTypes();
			method = clazz.getDeclaredMethod(methodName, parameterTypes);
		} catch (Exception e) {
			return null;
		}
		return method;
	}

}
