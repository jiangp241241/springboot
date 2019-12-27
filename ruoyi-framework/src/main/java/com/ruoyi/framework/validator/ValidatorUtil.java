package com.ruoyi.framework.validator;

import java.util.List;

import com.ruoyi.framework.validator.Exception.ApplicationException;
import com.ruoyi.framework.validator.chain.BaseChain;
import com.ruoyi.framework.validator.chain.ChainSingleton;

/**
 * 校验工具
 * */
public class ValidatorUtil {

	private ValidatorUtil() {

	}

	public static <T> void valid(T data) throws ApplicationException {
		List<BaseChain> chainList = ChainSingleton.getChainList();
		for (BaseChain chain : chainList) {
			chain.handle(data);
		}
	}
}
