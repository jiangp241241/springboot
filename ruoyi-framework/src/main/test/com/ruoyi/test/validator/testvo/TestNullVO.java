package com.ruoyi.test.validator.testvo;

import com.ruoyi.framework.validator.annotation.Null;

public class TestNullVO {

	@Null(description = "必须为空")
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
