package com.ruoyi.framework.excel.export.common;

import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ruoyi.framework.validator.Exception.ApplicationException;

/**
 * excel到处数据提供bean
 * 
 * @author paul
 * 
 */
public abstract class ExportExcelDataProvider {
	/**
	 * 业务入参
	 */
	private Map<String, String[]> parameters;

	/**
	 * 导出excel时的文件名
	 * 
	 * @return
	 * @throws ApplicationException
	 */
	public abstract String getFileName() throws ApplicationException;

	/**
	 * 提供业务数据抽象方法
	 * 
	 * @return
	 * @throws ApplicationException
	 */
	public abstract Map<String, Object> getBusinessData()
			throws ApplicationException;

	/***
	 * 修改excel模板
	 * 
	 * @param workbook
	 */
	public abstract void modifyExcelTemplate(HSSFWorkbook workbook);

	public Map<String, String[]> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}

}
