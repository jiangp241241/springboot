package com.ruoyi.framework.validator.chain;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.ruoyi.framework.validator.ValidatorUtil;
import com.ruoyi.framework.validator.Exception.ApplicationException;
import com.ruoyi.framework.validator.common.ClassUtil;

public class MapChain extends BaseChain {

	@Override
	public <T> void excute(T param) throws ApplicationException {
		if (param == null) {
			return;
		}
		if (!ClassUtil.isMap(param)) {
			return;
		}
		Map<?, ?> map = (Map<?, ?>) param;
		Iterator<?> entries = map.entrySet().iterator();
		Entry<?, ?> entry = null;
		Object key = null;
		Object value = null;
		while (entries.hasNext()) {
			entry = (Entry<?, ?>) entries.next();
			key = entry.getKey();
			value = entry.getValue();
			ValidatorUtil.valid(key);
			ValidatorUtil.valid(value);
		}
	}

}
