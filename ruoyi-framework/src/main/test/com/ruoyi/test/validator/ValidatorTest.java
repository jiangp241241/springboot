package com.ruoyi.test.validator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.ruoyi.framework.validator.ValidatorUtil;
import com.ruoyi.test.validator.testvo.TestAssertVO;
import com.ruoyi.test.validator.testvo.TestLength;
import com.ruoyi.test.validator.testvo.TestMaxVO;
import com.ruoyi.test.validator.testvo.TestMinVO;
import com.ruoyi.test.validator.testvo.TestNotBlankVO;
import com.ruoyi.test.validator.testvo.TestNotNullVO;
import com.ruoyi.test.validator.testvo.TestNullVO;
import com.ruoyi.test.validator.testvo.TestPatternVO;
import com.ruoyi.test.validator.testvo.TestRangeVO;

public class ValidatorTest {

	@Test
	public void testAssertFalse() {
		TestAssertVO test = new TestAssertVO();
		test.setValidFalse(false);// pass
		// test.setValidFalse(true); // failed
		test.setValidTrue(true); // pass
		// test.setValidTrue(false); // failed
		ValidatorUtil.valid(test);
	}

	@Test
	public void testMax() {
		TestMaxVO max = new TestMaxVO();

		// max.setInt_(33);// F
		max.setInt_(30);// T

		// max.setShort_((short)18);// F
		max.setShort_((short) 16);// T

		// max.setFloat_(65); // F
		max.setFloat_(64); // T

		max.setDouble_(113.4); // F
		max.setDouble_(112.1); // T

		// max.setLong_(123453); // F
		max.setLong_(12341); // T

		// max.setBigDecimal_(new BigDecimal("234234.35")); // F
		max.setBigDecimal_(new BigDecimal("234234.33")); // T

		ValidatorUtil.valid(max);
	}

	@Test
	public void testMin() {
		TestMinVO min = new TestMinVO();

		min.setInt_(33);// T
		// min.setInt_(30);// F

		min.setShort_((short) 18);// T
		// min.setShort_((short)16);// F

		min.setFloat_(65); // T
		// min.setFloat_(64); // F

		min.setDouble_(113.4); // T
		// min.setDouble_(112.1); // F

		min.setLong_(123453); // T
		// min.setLong_(12341); // F

		min.setBigDecimal_(new BigDecimal("234234.35")); // T
		// min.setBigDecimal_(new BigDecimal("234234.33")); // F

		ValidatorUtil.valid(min);
	}

	@Test
	public void testNotBlank() {
		TestNotBlankVO notBlank = new TestNotBlankVO();
		notBlank.setBlank("123");
		ValidatorUtil.valid(notBlank);
	}

	@Test
	public void testNotNull() {
		TestNotNullVO notNull = new TestNotNullVO();
		notNull.setValue("");
		ValidatorUtil.valid(notNull);
	}
	
	@Test
	public void testNull() {
		TestNullVO null_ = new TestNullVO();
		null_.setValue(null);
		ValidatorUtil.valid(null_);
	}

	@Test
	public void testPattern() {
		TestPatternVO testPatternVO = new TestPatternVO();
		testPatternVO.setValue("1254290201@qq.com");
		ValidatorUtil.valid(testPatternVO);
	}

	@Test
	public void testRangeVO() {
		TestRangeVO testRangeVO = new TestRangeVO();
		String[] array = { "1", "2", "3" };
		List<String> list = new ArrayList<>(Arrays.asList("2", "3"));
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "1");
		map.put("2", "1");
		map.put("3", "1");

		testRangeVO.setArray(array);
		testRangeVO.setList(list);
		testRangeVO.setMap(map);

		ValidatorUtil.valid(testRangeVO);
	}

	@Test
	public void testLength() {
		TestLength testLength = new TestLength();
		testLength.setStr("124");
		ValidatorUtil.valid(testLength);
	}
}
