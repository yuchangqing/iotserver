package com.kyee.iot.common.util;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用Jackson进行序列化和反序列化
 * @author wangbingfu
 * @Date 2018/9/25
 */
@Slf4j
public final class JSONUtil {

    private static ObjectMapper objectMapper = null;

    static {
        objectMapper = new ObjectMapper();
        // 允许json中出现注释信息
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        //允许接受引号引起来的所有字符，主要使用场景是在webservice返回的网页信息
        objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //序列化时不序列化空值以及null
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 将json中类型为String且值为null序列化为""
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(String.class, new CustomStringDeserializer());
        objectMapper.registerModule(simpleModule);
    }

    /**
     * 序列化JavaBean为jsonString
     * @param object
     * @return
     */
    public static String toJSONString(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("序列化 : {} 时异常，异常信息为： {}", object, e.getMessage());
            return null;
        }
    }

    /**
     * string转换为JsonString
     * @param source
     * @return
     */
    public static String toJSONString (String source){
        try {
            if (StringUtils.isEmpty(source)){
                log.error("String转换为JSONString出错，输入参数不符合规范: {}", source);
                return null;
            }
            JsonNode jsonNode = objectMapper.readTree(source);
            return jsonNode.toString();
        } catch (IOException e) {
            log.error("将String : {} 转换为JSONString异常，异常信息为：{}", source, e.getMessage());
            return null;
        }
    }

    /**
     * 将JSONString反序列化为指定的javaBean
     * @param source
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T parseStringToObject(String source, Class<T> t){
        try {
            if (StringUtils.isEmpty(source)){
                log.error("将JSONString转换为Object出错，输入参数不符合规范：{}", source);
                return null;
            }
            return objectMapper.readValue(source, t);
        } catch (IOException e) {
            log.error("反序列化: {} 为 : {}异常，异常信息：{}", source, t, e.getMessage());
            return null;
        }
    }

    /**
     * 处理返回值中没有指定类型的转换
     * @param source 资源字符串
     * @param t 类型
     * @param <T> 类型
     * @return T
     */
    @Deprecated
    public static <T> T parseStringByFastJson(String source, Class<T> t){
        return JSON.parseObject(source, t);
    }

    /**
     * 反序列化支持泛型
     * @param source
     * @param tTypeReference
     * @param <T>
     * @return
     */
    public static <T> T parseStringToObject(String source, TypeReference<T> tTypeReference){
        try {
            if (StringUtils.isEmpty(source)){
                log.error("将JSONString反序列化为Object出错， 输入参数不符合规范：{}", source);
                return null;
            }
            return objectMapper.readValue(source, tTypeReference);
        } catch (IOException e) {
            log.error("反序列化: {} 为 : {}异常，异常信息：{}", source, tTypeReference, e.getMessage());
            return null;
        }
    }

    /**
     * json 反序列化为List
     * @param source 原始字符串
     * @param cls 结果类型
     * @return List 转换失败返回空list
     */
    public static <T> List<T> parseStringToList(String source, Class<T> cls){
        List<T> objList = new ArrayList<>();
        try {
            if (!StringUtils.isEmpty(source)) {
                JavaType t = objectMapper.getTypeFactory().constructParametricType(
                        List.class, cls);
                objList = objectMapper.readValue(source, t);
            }
        } catch (IOException e) {
            log.error("反序列化: {} 为 : {}异常，异常信息：{}", source, cls, e.getMessage());
        }
        return objList;
    }

    /**
     * 获取json字符串中指定属性名称的值
     * @param source
     * @param key
     * @return
     */
    public static String getStringElementByName(String source, String key){
        try {
            if (StringUtils.isEmpty(source)){
                log.error("获取json中字符串属性出错，输入参数不符合规范：{}， {}", source, key);
                return null;
            }
            JsonNode jsonNode = objectMapper.readTree(source);
            return jsonNode.get(key).asText();
        } catch (IOException e) {
            log.error("获取json字符串中的: {}的值异常，异常信息为: {}", key, e.getMessage());
            return null;
        }
    }

    /**
     * 根据名称获取string中的属性值
     * @param source
     * @param key
     * @return
     */
    public static Object getElementByName(String source, String key){
        try {
            if (StringUtils.isEmpty(source)){
                log.error("获取json中属性出错，输入参数不符合规范：{}， {}", source, key);
                return null;
            }
            JsonNode jsonNode = objectMapper.readTree(source);
            return jsonNode.get(key);
        } catch (IOException e) {
            log.error("获取json字符串中的: {}的值异常，异常信息为: {}", key, e.getMessage());
            return null;
        }
    }

    /**
     * 获取String中JSONArray的size
     * @param source
     * @param key
     * @return
     */
    public static int getArrayElementSizeByName(String source, String key){
        try {
            if (StringUtils.isEmpty(source)){
                log.error("从String中获取List的大小出错，输入参数不是json： {}", source);
                return 0;
            }
            JsonNode jsonNode = objectMapper.readTree(source);
            JsonNode res = jsonNode.get(key);
            if (res != null && res.getNodeType() == JsonNodeType.ARRAY){
                return res.size();
            }else {
                log.info("属性名称为: {}不存在", key);
                return 0;
            }
        } catch (IOException e) {
            log.error("获取json中数组大小异常，异常信息为: {}", e.getMessage());
            return 0;
        }
    }

    /**
     * 获取webservice中ResultDatas中的数组数据
     * @param source
     * @param cls
     * @param key1
     * @param key2
     * @param <T>
     * @return
     */
    public static <T> List<T> getArrayFromJSON(String source, Class<T> cls, String key1, String key2){
        try {
            if (StringUtils.isEmpty(source)){
                log.error("获取webService中ResultDatas数据出错，输入不是json： {}", source);
                return null;
            }
            JsonNode jsonNode = objectMapper.readTree(source);
            JsonNode jsonNode1 = jsonNode.get(key1);
            return parseStringToList(jsonNode1.get(key2).toString(), cls);
        } catch (IOException e) {
            log.error("获取json resultDatas中数组异常，异常信息为: {}", e.getMessage());
            return null;
        }
    }

    /**
     * 获取webservice中ResultDatas中的字符串数据
     * @param source
     * @param key1
     * @param key2
     * @return
     */
    public static String getStringFromJson(String source, String key1, String key2){
        try {
            if(StringUtils.isEmpty(source)){
                log.error("获取webservice中ResultDatas中的字符串数据出错，输入参数错误： {}", source);
            }
            JsonNode jsonNode = objectMapper.readTree(source);
            JsonNode jsonNode1 = jsonNode.get(key1);
            return jsonNode1.get(key2).asText();
        } catch (IOException e) {
            log.error("获取json resultDataSource中字符串异常，异常信息为: {}", e.getMessage());
            return null;
        }
    }
}
