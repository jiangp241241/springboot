package com.ruoyi.common.utils.cache;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 本地缓存ehcache
 * */
public class EhcacheUtil {
	/**
	 * 公用的ehcache名称
	 * */
	private static final String DEFAULT_CACHE_NAME = "common";

	/**
	 * ehcache的配置文件
	 * */
	private static final String EHCACHE_XML_PATH = "/ehcache/ehcache.xml";

	/**
	 * cache名称
	 * */
	private static List<String> cacheNameList = new ArrayList<>();
	/**
	 * 缓存管理
	 * */
	private static CacheManager cacheManager = null;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(EhcacheUtil.class);

	static {
		try {
			init();
		} catch (Exception e) {
			LOGGER.error("init ehcache failed:" + e.getMessage());
		}
	}

	private EhcacheUtil() {

	}

	/**
	 * 初始化数据
	 * 
	 * @throws Exception
	 * */
	private static void init() throws Exception {
		try {
			InputStream resourceAsStream = EhcacheUtil.class
					.getResourceAsStream(EHCACHE_XML_PATH);
			cacheManager = CacheManager.create(resourceAsStream);
			String[] cacheNames = cacheManager.getCacheNames();
			if (cacheNames == null || cacheNames.length == 0) {
				return;
			}
			for (String cacheName : cacheNames) {
				cacheNameList.add(cacheName);
			}
		} catch (Exception e) {
			throw new Exception("init ehcache failed:" + e.getMessage());
		}

	}

	/**
	 * 获取cache
	 * 
	 * @param cacheName
	 *            缓存名称
	 * @return Cache 缓存
	 * */
	private static Cache getCache(String cacheName) {
		if (!cacheNameList.contains(cacheName)) {
			cacheName = DEFAULT_CACHE_NAME;
		}
		Cache cache = cacheManager.getCache(cacheName);
		return cache;
	}

	/**
	 * 添加数据
	 * 
	 * @param cacheName
	 *            缓存名
	 * @param key
	 *            key
	 * @param value
	 *            value
	 * */
	public static <K, V> void add(String cacheName, K key, V value) {
		Element element = new Element(key, value);
		getCache(cacheName).put(element);
	}

	/**
	 * 添加数据
	 * 
	 * @param key
	 *            key
	 * @param value
	 *            value
	 * */
	public static <K, V> void add(K key, V value) {
		add(DEFAULT_CACHE_NAME, key, value);
	}

	/**
	 * 删除数据
	 * */
	public static <K> void delete(String cacheName, K key) {
		getCache(cacheName).remove(key);
	}

	/**
	 * 删除数据
	 * */
	public static <K> void delete(K key) {
		delete(DEFAULT_CACHE_NAME, key);
	}

	/**
	 * 更新数据
	 * */
	public static <K, V> void update(String cacheName, K key, V value) {
		Element element = new Element(key, value);
		getCache(cacheName).put(element);
	}

	/**
	 * 更新数据
	 * */
	public static <K, V> void update(K key, V value) {
		update(DEFAULT_CACHE_NAME, key, value);
	}

	/**
	 * 查询数据
	 * */
	@SuppressWarnings("unchecked")
	public static <K, T> T get(String cacheName, K key, Class<T> clazz)
			throws Exception {
		Element element = getCache(cacheName).get(key);
		if (element == null) {
			return null;
		}
		T value = (T) element.getObjectValue();
		if (!clazz.isInstance(value)) {
			throw new Exception("data conversion failed");
		}
		return value;
	}

	/**
	 * 查询数据
	 * 
	 * @throws Exception
	 * */
	public static <K, T> T get(K key, Class<T> clazz) throws Exception {
		return get(DEFAULT_CACHE_NAME, key, clazz);
	}
}
