package com.ruoyi.test.validator.testvo;

import com.ruoyi.framework.validator.annotation.Length;

public class TestLength {

	@Length(min = 1, max = 3, description = "字符串长度最小为1，最大为3")
	private String str = null;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
