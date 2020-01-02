package com.test;

import org.junit.Test;

import com.ruoyi.common.utils.cache.EhcacheUtil;

public class EhcacheUtilTest {

	@Test
	public void test1() throws Exception {
		String cacheName = "product";
		String key = "key";
		String value = "123";
		EhcacheUtil.add(cacheName, key, value);
		String getValue1 = EhcacheUtil.get(cacheName, key, String.class);
		System.out.println("getValue1 = " + getValue1);
		EhcacheUtil.delete(cacheName, key);
		String getValue2 = EhcacheUtil.get(cacheName, key, String.class);
		System.out.println("getValue2 = " + getValue2);
	}

	@Test
	public void test2() throws Exception {
		String key = "key";
		String value = "123";
		EhcacheUtil.add(key, value);
		String getValue1 = EhcacheUtil.get(key, String.class);
		System.out.println("getValue1 = " + getValue1);
		EhcacheUtil.delete(key);
		String getValue2 = EhcacheUtil.get(key, String.class);
		System.out.println("getValue2 = " + getValue2);
	}
}
