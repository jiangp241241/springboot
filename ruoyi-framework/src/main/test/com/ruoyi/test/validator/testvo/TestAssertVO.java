package com.ruoyi.test.validator.testvo;

import com.ruoyi.framework.validator.annotation.AssertFalse;
import com.ruoyi.framework.validator.annotation.AssertTrue;

public class TestAssertVO {

	@AssertFalse(description = "validFalse必须为false")
	private boolean validFalse;

	@AssertTrue(description = "validTrue必须为true")
	private boolean validTrue;

	public boolean isValidFalse() {
		return validFalse;
	}

	public void setValidFalse(boolean validFalse) {
		this.validFalse = validFalse;
	}

	public boolean isValidTrue() {
		return validTrue;
	}

	public void setValidTrue(boolean validTrue) {
		this.validTrue = validTrue;
	}
}
