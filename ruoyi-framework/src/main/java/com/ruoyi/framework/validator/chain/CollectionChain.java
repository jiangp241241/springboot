package com.ruoyi.framework.validator.chain;

import java.util.Collection;
import java.util.Iterator;

import com.ruoyi.framework.validator.ValidatorUtil;
import com.ruoyi.framework.validator.Exception.ApplicationException;
import com.ruoyi.framework.validator.common.ClassUtil;

/**
 * 集合链
 * */
public class CollectionChain extends BaseChain {
	/**
	 * 校验集合(List,Vector)里每一个数据
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
		if (!ClassUtil.isCollection(param)) {
			return;
		}
		Iterator<?> iterator = ((Collection<?>) param).iterator();
		Object nextValue = null;
		while (iterator.hasNext()) {
			nextValue = iterator.next();
			ValidatorUtil.valid(nextValue);
		}

	}

}
