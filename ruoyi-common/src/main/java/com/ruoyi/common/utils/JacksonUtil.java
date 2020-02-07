package com.ruoyi.common.utils;

import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 由于部分外部服务接口字段太多，增加频繁，一个个VO对接维护量太大<br/>
 * 这里提供了一个简单的jackson序列化反序列化方式
 * 
 * @author wwx202712
 * @version UniSTAR HPC V001
 * @see <相关的类或者类的某个方法>
 * @since UniSTAR HPC
 */
public abstract class JacksonUtil {
    /**
     * 方法说明
     * @param strJson strJson参数变量
     * @param className className参数变量
     * @return 结果信息
     * @throws IOException IOException异常信息
     */
    public static Object parseStrJson2Object(String strJson, Class<?> className) throws IOException {
        // Jackson 解析detail
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(strJson, className);
    }

    /**
     * 方法说明
     * @param strJson strJson参数变量
     * @return 结果信息
     * @throws IOException IOException异常信息
     */
    public static HashMap<?, ?> parseStrJson2HashMap(String strJson) throws IOException {
        // Jackson 解析detail
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(strJson, HashMap.class);
    }

    /**
     * 方法说明
     * @param obj obj参数变量
     * @return 结果信息
     * @throws JsonProcessingException JsonProcessingException异常信息
     */
    public static String parseObject2JsonStrAndReplaceNull(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException {
                arg1.writeString("");
            }
        });
        return writeValueAdString(obj, objectMapper);
    }

    /**
     * 方法说明
     * @param obj obj参数变量
     * @return 结果信息
     * @throws JsonProcessingException JsonProcessingException异常信息
     */
    public static String parseObject2JsonStr(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return writeValueAdString(obj, objectMapper);
    }

    /**
     * 方法说明
     * @param obj obj参数变量
     * @param objectMapper objectMapper参数变量
     * @return 结果信息
     * @throws JsonProcessingException JsonProcessingException异常信息
     */
    private static String writeValueAdString(Object obj, ObjectMapper objectMapper) throws JsonProcessingException {
        String resultStr = "";
        resultStr = objectMapper.writeValueAsString(obj);
        return resultStr;
    }

    /**
     * 方法说明
     * @param jsonStr json字符串
     * @param collectionClass 泛型的Collection
     * @param elementClasses 元素类型
     * @return 结果信息
     * @throws IOException IOException异常信息
     */
    public static <T> T parseStrJson2Collection(String jsonStr, Class<?> collectionClass,
        Class<?>... elementClasses) throws IOException {
        T result = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JavaType javaType = mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
        result = mapper.readValue(jsonStr, javaType);
        return result;
    }
}
