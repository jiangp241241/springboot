package com.ruoyi.web.controller.demo.test;

import java.util.List;

import com.ruoyi.framework.validator.annotation.NotBlank;
import com.ruoyi.framework.validator.annotation.Range;

public class UserVO {

	@NotBlank(description = "email不能为空")
	private String email;

	@Range(min = 1, max = 5, description = "list范围为1-5")
	private List<String> list;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
