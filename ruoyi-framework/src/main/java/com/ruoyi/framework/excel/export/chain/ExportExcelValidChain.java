package com.ruoyi.framework.excel.export.chain;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.util.StringUtils;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.framework.excel.export.common.ExportExcelConstants;
import com.ruoyi.framework.excel.export.common.ExportExcelDataProvider;
import com.ruoyi.framework.validator.Exception.ApplicationException;

/**
 * 校验链
 * 
 * @author paul
 * 
 */
public abstract class ExportExcelValidChain extends ExportExcelTaskChain {

	/**
	 * 业务数据提供bean
	 */
	protected ExportExcelDataProvider dataProvider;

	/**
	 * excel模板唯一标识符
	 */
	protected String excelType;

	/**
	 * 接下来的处理
	 * 
	 * @param parameterMap
	 * @param response
	 */
	public abstract void export3(Map<String, String[]> parameterMap,
			HttpServletResponse response);

	@Override
	public void export2(HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {
		Map<String, String[]> parameterMap = request.getParameterMap();
		validParams(parameterMap);
		export3(parameterMap, response);
	}

	/**
	 * 参数校验
	 * 
	 * @param parameterMap
	 */
	private void validParams(Map<String, String[]> parameterMap)
			throws ApplicationException {
		if (parameterMap == null || parameterMap.size() == 0) {
			throw new IllegalArgumentException("parameter is null");
		}
		// 校验excel模板唯一标识符exceltype
		String[] excelTypeArray = parameterMap
				.get(ExportExcelConstants.Request.EXCEL_TYPE);
		if (excelTypeArray == null || excelTypeArray.length == 0) {
			throw new IllegalArgumentException("excelType is null");
		}
		excelType = excelTypeArray[0];
		if (StringUtils.isEmpty(excelType)) {
			throw new IllegalArgumentException("excelType is null");
		}
		// 校验提供业数据bean
		String[] dataProviderArray = parameterMap
				.get(ExportExcelConstants.Request.DATA_PROVIDER);
		if (dataProviderArray == null || dataProviderArray.length == 0) {
			throw new IllegalArgumentException("dataProvider is null");
		}
		String dataProvider = dataProviderArray[0];
		if (StringUtils.isEmpty(dataProvider)) {
			throw new IllegalArgumentException("dataProvider is null");
		}
		validDataProvider(dataProvider, parameterMap);
	}

	/**
	 * 校验业务数据bean是否存在
	 * 
	 * @param beanName
	 * @param parameters
	 */
	private void validDataProvider(String beanName,
			Map<String, String[]> parameters) throws ApplicationException {
		Object bean = SpringUtils.getBean(beanName);
		if (bean == null) {
			throw new BusinessException("data provider bean is null");
		}
		if (!(bean instanceof ExportExcelDataProvider)) {
			throw new BusinessException("data provider bean is null");
		}
		dataProvider = (ExportExcelDataProvider) bean;
		dataProvider.setParameters(parameters);
	}

}
