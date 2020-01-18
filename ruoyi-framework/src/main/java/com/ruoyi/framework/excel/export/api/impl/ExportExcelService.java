package com.ruoyi.framework.excel.export.api.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ruoyi.framework.excel.export.api.IExportExcelService;
import com.ruoyi.framework.excel.export.chain.ExportJxtlChain;

@Controller()
@RequestMapping("/excel")
public class ExportExcelService implements IExportExcelService {

	@Resource
	@Qualifier("exportExcelChain")
	private ExportJxtlChain exportExcel;

	@GetMapping("/export")
	@Override
	public void exportExcel(HttpServletRequest request,
			HttpServletResponse response) {
		exportExcel.export(request, response);
	}

}
