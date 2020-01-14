package com.ruoyi.framework.excel.export.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author paul
 *
 */
public interface IExportExcelService {
	/**
	 * excel到处
	 * @param request request
	 * @param response response
	 */
	public void exportExcel(HttpServletRequest request,HttpServletResponse response);
}
