package com.ruoyi.framework.validator.handler;

import java.util.regex.Matcher;

import com.alibaba.druid.util.StringUtils;
import com.ruoyi.framework.validator.Exception.ApplicationException;
import com.ruoyi.framework.validator.annotation.Pattern;

/**
 * 断言为true处理器
 * */
public class PatternHandler implements BaseHandler {

	@Override
	public <T> void handle(T annotation, T value) throws ApplicationException {
		if (annotation == null) {
			throw new ApplicationException("annotation is null");
		}
		if (!(annotation instanceof Pattern)) {
			throw new ApplicationException("annotation type is not Pattern");
		}
		Pattern patternAnnotation = (Pattern) annotation;
		String description = patternAnnotation.description();
		String regex = patternAnnotation.regex();
		boolean flag = patternAnnotation.flag();
		if (StringUtils.isEmpty(regex)) {
			return;
		}
		java.util.regex.Pattern regexPattern = java.util.regex.Pattern
				.compile(regex);
		Matcher matcher = regexPattern.matcher(value + "");
		boolean find = matcher.find();
		if (!(flag == find)) {
			throw new ApplicationException(description);
		}
	}

}
