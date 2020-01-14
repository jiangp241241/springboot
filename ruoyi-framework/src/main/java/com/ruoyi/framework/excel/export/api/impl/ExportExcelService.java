package com.ruoyi.framework.excel.export.api.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ruoyi.framework.excel.export.api.IExportExcelService;

@Controller("/excel")
public class ExportExcelService implements IExportExcelService {

	@GetMapping("export")
	@Override
	public void exportExcel(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
