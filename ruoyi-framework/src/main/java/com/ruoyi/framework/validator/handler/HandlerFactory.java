package com.ruoyi.framework.validator.handler;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import com.ruoyi.framework.validator.annotation.AssertFalse;
import com.ruoyi.framework.validator.annotation.AssertTrue;
import com.ruoyi.framework.validator.annotation.Length;
import com.ruoyi.framework.validator.annotation.Max;
import com.ruoyi.framework.validator.annotation.Min;
import com.ruoyi.framework.validator.annotation.NotBlank;
import com.ruoyi.framework.validator.annotation.NotNull;
import com.ruoyi.framework.validator.annotation.Null;
import com.ruoyi.framework.validator.annotation.Pattern;
import com.ruoyi.framework.validator.annotation.Range;
public class HandlerFactory {

	private static Map<String, BaseHandler> handlerMap = new HashMap<>();

	static {
		init();
	}

	private HandlerFactory() {

	}

	private static void init() {
		handlerMap.put(AssertTrue.class.toString().replace("interface", "")
				.trim(), new AssertTrueHandler());
		handlerMap.put(AssertFalse.class.toString().replace("interface", "")
				.trim(), new AssertFalseHandler());
		handlerMap.put(Length.class.toString().replace("interface", "").trim(),
				new LengthHandler());
		handlerMap.put(Max.class.toString().replace("interface", "").trim(),
				new MaxHandler());
		handlerMap.put(Min.class.toString().replace("interface", "").trim(),
				new MinHandler());
		handlerMap.put(NotBlank.class.toString().replace("interface", "")
				.trim(), new NotBlankHandler());
		handlerMap.put(
				NotNull.class.toString().replace("interface", "").trim(),
				new NotNullHandler());
		handlerMap.put(Null.class.toString().replace("interface", "").trim(),
				new NullHandler());
		handlerMap.put(
				Pattern.class.toString().replace("interface", "").trim(),
				new PatternHandler());
		handlerMap.put(Range.class.toString().replace("interface", "").trim(),
				new RangeHandler());
	}

	public static BaseHandler createHandler(Annotation annotation) {
		if (annotation == null) {
			return null;
		}
		String annotationKey = annotation.toString();
		annotationKey = annotationKey.replace("@", "");
		annotationKey = annotationKey.substring(0, annotationKey.indexOf("("));
		BaseHandler handler = handlerMap.get(annotationKey);
		return handler;

	}
}
