package com.ruoyi.test.validator.testvo;

import com.ruoyi.framework.validator.annotation.NotNull;

public class TestNotNullVO {

	@NotNull(description = "不能为空")
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
