package com.ruoyi.framework.excel.export.common;

/**
 * excel导出常量
 * 
 * @author paul
 * 
 */
public interface ExportExcelConstants {

	/**
	 * 公用常量
	 * 
	 * @author paul
	 * 
	 */
	public interface Common {

		/**
		 * 导出excel文件目录
		 */
		public String EXCEL_PATH = "/excel/export";

		/**
		 * 导出excel临时文件目录
		 */
		public String TEMP_EXCEL_PATH = "/excel/export/temp";

	}

	/**
	 * 入参常量
	 * 
	 * @author paul
	 * 
	 */
	public interface Request {
		/**
		 * excel模板标识符
		 */
		public String EXCEL_TYPE = "excelType";

		/**
		 * 业务数据bean
		 */
		public String DATA_PROVIDER = "dataProvider";
	}
}
