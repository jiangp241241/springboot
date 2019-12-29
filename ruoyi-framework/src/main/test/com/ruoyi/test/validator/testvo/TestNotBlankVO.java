package com.ruoyi.test.validator.testvo;

import com.ruoyi.framework.validator.annotation.NotBlank;

public class TestNotBlankVO {

	@NotBlank(description = "不能为空")
	private String blank;

	public String getBlank() {
		return blank;
	}

	public void setBlank(String blank) {
		this.blank = blank;
	}

}
