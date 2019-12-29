package com.ruoyi.test.validator.testvo;

import com.ruoyi.framework.validator.annotation.Pattern;

public class TestPatternVO {
	
	@Pattern(regex = "[1-9]\\d{7,10}@qq\\.com",description="请输入正确的qq号")
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
