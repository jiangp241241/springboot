package com.ruoyi.framework.excel.export.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jxls.common.Context;
import org.jxls.expression.JexlExpressionEvaluator;
import org.jxls.transform.Transformer;
import org.jxls.util.JxlsHelper;

/**
 * 
 * @author klguang
 * 
 */
public class JxlsUtils {

	public static void exportExcel(InputStream is, OutputStream os,
			Map<String, Object> model) throws IOException {
		Context context = new Context();
		if (model != null) {
			for (String key : model.keySet()) {
				context.putVar(key, model.get(key));
			}
		}
		JxlsHelper jxlsHelper = JxlsHelper.getInstance();
		Transformer transformer = jxlsHelper.createTransformer(is, os);
		JexlExpressionEvaluator evaluator = (JexlExpressionEvaluator) transformer
				.getTransformationConfig().getExpressionEvaluator();
		Map<String, Object> funcs = new HashMap<String, Object>();
		funcs.put("utils", new JxlsUtils()); // 添加自定义功能
		evaluator.getJexlEngine().setFunctions(funcs);
		jxlsHelper.processTemplate(context, transformer);
	}

	// 日期格式化
	public String dateFmt(Date date, String fmt) {
		if (date == null) {
			return "";
		}
		try {
			SimpleDateFormat dateFmt = new SimpleDateFormat(fmt);
			return dateFmt.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	// if判断
	public Object ifelse(boolean b, Object o1, Object o2) {
		return b ? o1 : o2;
	}

}
