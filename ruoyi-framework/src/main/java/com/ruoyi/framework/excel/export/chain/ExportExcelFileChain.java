package com.ruoyi.framework.excel.export.chain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.framework.excel.export.common.ExportExcelConstants;
import com.ruoyi.framework.validator.Exception.ApplicationException;

/**
 * 导出excel文件链
 * 
 * @author paul
 * 
 */
public abstract class ExportExcelFileChain extends ExportExcelValidChain {

	/**
	 * excel文件模板
	 */
	protected File excelTemplate;

	/**
	 * excel临时文件
	 */
	protected File tempFile;

	/**
	 * excel文件文件流
	 */
	protected InputStream fileTemplateInputStream;

	/**
	 * excel临时模板输出流
	 */
	protected OutputStream tempFileOutputStream;

	/**
	 * 项目路径
	 */
	private String contextPath;

	/**
	 * 读取excel模板文件
	 * 
	 * @throws ApplicationException
	 */
	private void getFileTemplate() throws ApplicationException {
		this.contextPath = this.getClass().getResource("/").getPath();
	}

	/**
	 * 创建临时文件
	 * 
	 * @throws ApplicationException
	 */
	private void createTempFile() throws ApplicationException {
		String uuid = UUID.randomUUID().toString();
		String folderPath = contextPath
				+ ExportExcelConstants.Common.TEMP_EXCEL_PATH;
		File folder = new File(folderPath);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		String filePath = folderPath + "/" + uuid + "_" + this.excelType;
		this.tempFile = new File(filePath);
		try {
			this.tempFile.createNewFile();
		} catch (Exception e) {
			throw new BusinessException("create temp excel failed:"
					+ e.getMessage());
		}
	}

	/**
	 * 读取临时模板输出流
	 * 
	 * @throws ApplicationException
	 */
	private void getTempFileOutPutStream() throws ApplicationException {
		try {
			this.tempFileOutputStream = new FileOutputStream(this.tempFile);
		} catch (Exception e) {
			throw new BusinessException(
					"create temp excel outputstream failed:" + e.getMessage());
		}
	}

	/**
	 * 读取excel模板文件流
	 * 
	 * @throws ApplicationException
	 */
	private void getFileTemplateInputstream() throws ApplicationException {
		String excelContextPath = ExportExcelConstants.Common.EXCEL_PATH + "/"
				+ this.excelType;
		excelContextPath = this.contextPath + excelContextPath;
		try {
			this.fileTemplateInputStream = new FileInputStream(excelContextPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("test");
	}

	/**
	 * 关闭excel模板文件流
	 * 
	 * @throws ApplicationException
	 */
	private void closeFileTemplateInputStream() throws ApplicationException {
		try {
			this.fileTemplateInputStream.close();
		} catch (IOException e) {
			throw new BusinessException("close the file template falied:"
					+ e.getMessage());
		}
	}

	/**
	 * 关闭excel模板文件流
	 * 
	 * @throws ApplicationException
	 */
	private void colseTempFileOutputStream() throws ApplicationException {
		try {
			this.tempFileOutputStream.close();
		} catch (IOException e) {
			throw new BusinessException("close temp file outputstream failed:"
					+ e.getMessage());
		}
	}

	@Override
	public void export3(Map<String, String[]> parameterMap,
			HttpServletResponse response) {
		this.getFileTemplate();
		this.getFileTemplateInputstream();
		this.createTempFile();
		getTempFileOutPutStream();
		export4(parameterMap, response);
		close();
	}

	/**
	 * 后事处理
	 * 
	 * @throws ApplicationException
	 */
	private void close() throws ApplicationException {
		this.closeFileTemplateInputStream();
		this.colseTempFileOutputStream();
		this.deleteTempFile();
	}

	/**
	 * 删除临时文件
	 */
	private void deleteTempFile() {
		this.tempFile.delete();
	}

	/**
	 * 接下来处理
	 * 
	 * @param parameterMap
	 * @param response
	 * @throws ApplicationException
	 */
	public abstract void export4(Map<String, String[]> parameterMap,
			HttpServletResponse response) throws ApplicationException;
}
