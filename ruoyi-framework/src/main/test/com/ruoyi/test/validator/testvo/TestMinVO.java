package com.ruoyi.test.validator.testvo;

import java.math.BigDecimal;

import com.ruoyi.framework.validator.annotation.Min;
import com.ruoyi.framework.validator.common.BaseDataConstant;

public class TestMinVO {

	@Min(min = "32", type = BaseDataConstant.INT, description = "int最小值为32")
	private int int_;

	@Min(min = "16", type = BaseDataConstant.SHORT, description = "short最小值为16")
	private short short_;

	@Min(min = "64.5", type = BaseDataConstant.FLOAT, description = "float最小值为64.5")
	private float float_;

	@Min(min = "112.45", type = BaseDataConstant.DOUBLE, description = "double最小值为112.45")
	private double double_;

	@Min(min = "12345", type = BaseDataConstant.LONG, description = "long最小值为12345")
	private long long_;

	@Min(min = "234234.34", type = BaseDataConstant.BIG_DECIMAL, description = "bigDecimal最小值为234234.34")
	private BigDecimal bigDecimal_;

	public int getInt_() {
		return int_;
	}

	public void setInt_(int int_) {
		this.int_ = int_;
	}

	public short getShort_() {
		return short_;
	}

	public void setShort_(short short_) {
		this.short_ = short_;
	}

	public float getFloat_() {
		return float_;
	}

	public void setFloat_(float float_) {
		this.float_ = float_;
	}

	public double getDouble_() {
		return double_;
	}

	public void setDouble_(double double_) {
		this.double_ = double_;
	}

	public long getLong_() {
		return long_;
	}

	public void setLong_(long long_) {
		this.long_ = long_;
	}

	public BigDecimal getBigDecimal_() {
		return bigDecimal_;
	}

	public void setBigDecimal_(BigDecimal bigDecimal_) {
		this.bigDecimal_ = bigDecimal_;
	}

}
