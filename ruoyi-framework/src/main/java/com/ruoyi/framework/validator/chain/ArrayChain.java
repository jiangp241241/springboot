package com.ruoyi.framework.validator.chain;

import com.ruoyi.framework.validator.ValidatorUtil;
import com.ruoyi.framework.validator.Exception.ApplicationException;
import com.ruoyi.framework.validator.common.ClassUtil;


/**
 * 数组链
 * */
public class ArrayChain extends BaseChain {

	/**
	 * 校验数组里每一个数据
	 * 
	 * @param param
	 *            入参
	 * @throws ApplicationException
	 *             业务异常
	 * */
	@Override
	public <T> void excute(T param) throws ApplicationException {
		if (param == null) {
			return;
		}
		if (!ClassUtil.isArray(param)) {
			return;
		}
		Object[] array = (Object[]) param;
		for (Object obj : array) {
			ValidatorUtil.valid(obj);
		}
	}
}
