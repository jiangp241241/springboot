package com.ruoyi.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.jxls.common.Context;

import com.ruoyi.framework.excel.export.common.JxlsUtils;

public class JxtlTest {

	@SuppressWarnings("unchecked")
	@Test
	public void test1() throws Exception {
		// 模板文件
		String url = "D:/workspace/myproject/springboot/springboot/ruoyi-admin/src/main/resources/excel/export/demo.xls";
		File file = new File(url);
		InputStream is = new FileInputStream(file);
		@SuppressWarnings("unused")
		Context context = new Context();
		// 设置参数变量
		OutputStream os = new FileOutputStream(new File("D:/test/test_out.xls"));
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("name", "chendd");
		JxlsUtils.exportExcel(is, os, map);
		// 释放资源
		os.flush();
		os.close();
		is.close();
		System.out.println("完成");
	}
}
