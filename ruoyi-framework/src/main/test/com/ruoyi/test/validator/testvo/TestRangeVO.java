package com.ruoyi.test.validator.testvo;

import java.util.List;
import java.util.Map;

import com.ruoyi.framework.validator.annotation.Range;

public class TestRangeVO {

	@Range(max = 3, description = "map最大值为3")
	private Map<String, String> map;

	@Range(min = 1, max = 4, description = "array范围[1 - 4]")
	private String[] array;

	@Range(min = 1, max = 2, description = "list范围[1 - 2]")
	private List<String> list;

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
