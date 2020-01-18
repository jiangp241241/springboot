package com.ruoyi.framework.excel.export.chain;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.framework.excel.export.common.JxlsUtils;
import com.ruoyi.framework.validator.Exception.ApplicationException;

/**
 * jxtl链,导出excel
 * 
 * @author paul
 * 
 */
@Component("exportExcelChain")
@Scope("prototype")
public class ExportJxtlChain extends ExportExcelResponseChain {

	private static final Logger logger = LoggerFactory
			.getLogger(ExportJxtlChain.class);

	@Override
	public void export5(Map<String, String[]> parameterMap,
			HttpServletResponse response) throws ApplicationException {
		HSSFWorkbook workbook = null;
		InputStream tempInputStream = null;
		try {
			Map<String, Object> businessData = this.dataProvider
					.getBusinessData();
			JxlsUtils.exportExcel(this.fileTemplateInputStream,
					this.tempFileOutputStream, businessData);
			File outFile = new File(this.tempFile.getAbsolutePath());
			tempInputStream = new FileInputStream(outFile);
			workbook = new HSSFWorkbook(tempInputStream);
			this.dataProvider.modifyExcelTemplate(workbook);
			this.tempFileOutputStream.flush();
			workbook.write(response.getOutputStream());
			response.flushBuffer();
		} catch (Exception e) {
			logger.error("export excel failed:" + e.getMessage());
			close(workbook, tempInputStream);
			throw new BusinessException("export excel falied : "
					+ e.getMessage());
		}
		close(workbook, tempInputStream);
	}

	/**
	 * 关闭流
	 * 
	 * @param workbook
	 * @param tempInputStream
	 */
	private void close(HSSFWorkbook workbook, InputStream tempInputStream) {
		try {
			if (workbook != null) {
				workbook.close();
			}
		} catch (Exception e) {
			logger.error(" close workbook failed:" + e.getMessage());
		}
		try {
			if (tempInputStream != null) {
				tempInputStream.close();
			}
		} catch (Exception e) {
			logger.error(" close tempInputStream failed:" + e.getMessage());
		}
	}

}
