package com.ruoyi.framework.excel.export.demo;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.ruoyi.framework.excel.export.common.ExportExcelDataProvider;
import com.ruoyi.framework.validator.Exception.ApplicationException;

@Component("exportExcelDemoBusiness")
public class ExportExcelDemoBusiness extends ExportExcelDataProvider {

	@Override
	public String getFileName() throws ApplicationException {
		String fileName = "导出实列.xls";
		return fileName;
	}

	@Override
	public Map<String, Object> getBusinessData() throws ApplicationException {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "zhangsan");
		return map;
	}

	@Override
	public void modifyExcelTemplate(XSSFWorkbook workbook) {

	}

}
