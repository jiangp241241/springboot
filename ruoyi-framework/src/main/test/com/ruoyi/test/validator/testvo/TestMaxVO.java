package com.ruoyi.test.validator.testvo;

import java.math.BigDecimal;

import com.ruoyi.framework.validator.annotation.Max;
import com.ruoyi.framework.validator.common.BaseDataConstant;

public class TestMaxVO {

	@Max(max = "32", type = BaseDataConstant.INT, description = "int最大值为32")
	private int int_;

	@Max(max = "16", type = BaseDataConstant.SHORT, description = "short最大值为16")
	private short short_;

	@Max(max = "64.5", type = BaseDataConstant.FLOAT, description = "float最大值为64.5")
	private float float_;

	@Max(max = "112.45", type = BaseDataConstant.DOUBLE, description = "double最大值为112.45")
	private double double_;

	@Max(max = "12345", type = BaseDataConstant.LONG, description = "long最大值为12345")
	private long long_;

	@Max(max = "234234.34", type = BaseDataConstant.BIG_DECIMAL, description = "bigDecimal最大值为234234.34")
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
