package com.ruoyi.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateUtil {

    static final String MEDIA_TYPE = "application/json; charset=UTF-8";

    static final RestTemplate REST_TEMPLATE = new RestTemplate();

    private static final String APPLICATION_JSON = "application/json";

    /**
    * @Description 包装HttpEntity
    * @Param param 骑牛参数
    * @param headers 请求头
    * @Return 请求响应
    */
    protected static <T> HttpEntity<T> getHttpEntity(T params, Map<String, String> headers) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.parseMediaType(MEDIA_TYPE));
        httpHeaders.add("Accept", MediaType.APPLICATION_JSON.toString());

        if (headers != null && !headers.isEmpty()) {
            Set<Entry<String, String>> entrySet = headers.entrySet();
            for (Entry<String, String> entry : entrySet) {
                httpHeaders.add(entry.getKey(), entry.getValue());
            }
        }

        return new HttpEntity<T>(params, httpHeaders);
    }

    /**
    * @Description 获取header
    * @Return header集合
    */
    public static Map<String, String> getHeader() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", APPLICATION_JSON);
        return headers;
    }

    /**
     * 发送带请求头的get请求
     * 
     * @Desc 注意：uriVars最多只能传一个URIVariables实例,可以不传
     * @param url 请求连接
     * @param uriVars 请求uri参数
     * @param headers 请求头
     * @return 请求响应
     */
    public static ResponseEntity<String> get(String url, Map<String, String> headers, Map<Object, Object> parameter) {
        return REST_TEMPLATE.exchange(url, HttpMethod.GET, getHttpEntity(null, headers), String.class, parameter);
    }

    /**
    * @Description 发送带请求头的POST请求
    * @param url 请求连接
    * @param uriVars 请求uri参数
    * @param param 请求参数
    * @param headers 请求头
    */
    public static <T> ResponseEntity<String> post(String url, T param, Map<String, String> headers,
        Map<Object, Object> parameter) {
        return REST_TEMPLATE.exchange(url, HttpMethod.POST, getHttpEntity(param, headers), String.class, parameter);
    }

    /**
     * 发送带请求头的delete请求
     * 
     * @Desc 注意：uriVars最多只能传一个URIVariables实例,可以不传
     * @param url 请求连接
     * @param uriVars 请求uri参数
     * @param headers 请求头
     * @return 请求响应
     */
    public static ResponseEntity<String> delete(String url, Map<String, String> headers,
        Map<Object, Object> parameter) {
        return REST_TEMPLATE.exchange(url, HttpMethod.DELETE, getHttpEntity(null, headers), String.class, parameter);
    }

    /**
     * 发送带请求头的get请求
     * 
     * @Desc 注意：uriVars最多只能传一个URIVariables实例,可以不传
     * @param url 请求连接
     * @param uriVars 请求uri参数
     * @return 请求响应
     */
    public static ResponseEntity<String> get(String url, Map<Object, Object> parameter) {
        return REST_TEMPLATE.exchange(url, HttpMethod.GET, getHttpEntity(null, getHeader()), String.class, parameter);
    }

    /**
     * 发送带请求头的put请求
     * 
     * @Desc 注意：uriVars最多只能传一个URIVariables实例,可以不传
     * @param url 请求连接
     * @param uriVars 请求uri参数
     * @param headers 请求头
     * @return 请求响应
     */
    public static ResponseEntity<String> put(String url, Map<String, String> headers, Object param,
        Map<Object, Object> parameter) {
        return REST_TEMPLATE.exchange(url, HttpMethod.PUT, getHttpEntity(param, headers), String.class, parameter);
    }
}