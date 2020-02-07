package com.ruoyi.common.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * 基于JsonUtil工具类,不想抛异常，不然阵容有点乱
 * @since 1.0
 */
public class MyJsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(MyJsonUtil.class);

    /**
     * 对象格式化
     * @param object object
     * @return String String
     */
    public static String objectToJson(Object object) {
        if (object == null) {
            return null;
        }
        String result = null;
        result = JSONObject.toJSONString(object);
        return result;
    }

    /**
     * json转对象
     *
     * @param inputValue inputValue
     * @param cls cls
     * @param <T> <T>
     * @return <T>
     */
    public static <T> T stringToObject(String inputValue, Class<T> clazz) {
        T result = JSONObject.parseObject(inputValue, clazz);
        return result;
    }

    /**
     * 根据key从json中获取value
     * @param json 一个完整的json串
     * @param key 某一个key值
     * @return String 解析到的value
     * */
    public static String getValueByKey(String json, String key) {
        String value = null;
        if (StringUtils.isEmpty(json) || StringUtils.isEmpty(key)) {
            return value;
        }
        value = JSONObject.parseObject(json).getString(key);
        return value;
    }
}