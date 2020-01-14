package com.ruoyi.framework.excel.export.chain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.util.StringUtils;
import com.ruoyi.framework.validator.Exception.ApplicationException;

/**
 * excel导出response链
 * 
 * @author paul
 * 
 */
public abstract class ExportExcelResponseChain extends ExportExcelFileChain {

	private static final Logger logger = LoggerFactory
			.getLogger(ExportExcelResponseChain.class);

	/**
	 * 设置导出时response参数
	 * 
	 * @param response
	 */
	private void setResponse(HttpServletResponse response) {
		response.setContentType("application/octet-stream");
		response.setHeader("content-Type",
				"application/vnd.ms-excel;charset=UTF-8");
		String fileName = this.dataProvider.getFileName();
		if (StringUtils.isEmpty(fileName)) {
			fileName = this.excelType;
		}
		try {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("encode fileName failed:" + e.getMessage());
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName);

	}

	@Override
	public void export4(Map<String, String[]> parameterMap,
			HttpServletResponse response) throws ApplicationException {
		setResponse(response);
		export5(parameterMap, response);
	}

	/**
	 * 接下来处理
	 * 
	 * @param parameterMap
	 * @param response
	 * @throws ApplicationException
	 */
	public abstract void export5(Map<String, String[]> parameterMap,
			HttpServletResponse response) throws ApplicationException;
}
