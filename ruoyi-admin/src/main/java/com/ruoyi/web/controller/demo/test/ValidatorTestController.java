package com.ruoyi.web.controller.demo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.validator.annotation.Length;
import com.ruoyi.framework.validator.annotation.Max;
import com.ruoyi.framework.validator.annotation.NotBlank;
import com.ruoyi.framework.validator.common.BaseDataConstant;

/**
 * 自定义注解校验器
 * */
@Controller
@RequestMapping("/validator")
public class ValidatorTestController {

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String test(
			@RequestParam(name = "name") @Length(description = "name长度不能超过10") @NotBlank(description = "name不能为空") String name,
			@RequestParam(name = "age") @Max(max = "100", description = "年龄不能超过100", type = BaseDataConstant.INT) Integer age) {
		String msg = "validator test:name = " + name + ",age=" + age;
		return msg;

	}
	
	@ResponseBody
	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	public String test2(
			@RequestParam(name = "name") @Length(description = "name长度不能超过10") @NotBlank(description = "name不能为空") String name,
			@RequestParam(name = "age") @Max(max = "100", description = "年龄不能超过100", type = BaseDataConstant.INT) Integer age) {
		String msg = "validator test:name = " + name + ",age=" + age;
		return msg;

	}
}
