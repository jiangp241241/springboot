package com.ruoyi.framework.excel.export.chain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 导入excel基类
 * 
 * @author paul
 * 
 */
public abstract class ExportExcelChain {
	/**
	 * 入口
	 * 
	 * @param request
	 *            request
	 * @param response
	 *            response
	 */
	public abstract void export(HttpServletRequest request,
			HttpServletResponse response);
}
