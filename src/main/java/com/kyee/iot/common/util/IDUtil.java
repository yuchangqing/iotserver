package com.kyee.iot.common.util;

import java.util.UUID;

/**
 * Description
 * ID工具类,用于生成UUID字符串，会去除生成的UUID中"-"
 * @author wangbingfu
 * @Date 2018/09/06
 */
public final class IDUtil {

    /**
     * 生成随机的UUID,去掉其中的"-"
     * @return
     */
    public static String randomUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 将指定字符串转换为UUID格式字符串
     * 输入resource需要符合UUID格式，UUID通过-分隔为五部分，例如：1f234-89c79-1a2345-0b9007-4d5e6ff
     * 并且各个部分均为16进制，如果不符合UUID格式则会抛出IllegalArgumentException异常
     * @param resource
     * @return
     * @throws IllegalArgumentException
     */
    public static String randomUUIDFromString(String resource) throws IllegalArgumentException{
        UUID uuid = UUID.fromString(resource);
        return uuid.toString().replace("-", "");
    }

    /**
     * 将指定字符串转换为UUID，输入resource需要符合UUID格式，否则会抛出IllegalArgumentException异常
     * @param resource
     * @return
     * @throws IllegalArgumentException
     */
    public static UUID generalUUIDFromString(String resource) throws IllegalArgumentException{
        return UUID.fromString(resource);
    }

    /**
     * 将输入resource拼接到生成的UUID后
     * @param resource
     * @return
     */
    public static String generateStringByUUID(String resource){
        StringBuilder sb = new StringBuilder();
        sb.append(UUID.randomUUID());
        sb.append(resource);
        return sb.toString().replace("-", "");
    }

    /**
     * 获取16位的UUID,取UUID的前三位
     * @return
     */
    public static String get16UUID(){
        UUID id=UUID.randomUUID();
        String[] idd=id.toString().split("-");
        return idd[0]+idd[1]+idd[2];
    }

    /**
     * 使用当前时间戳和UUID生成唯一标识字符串
     * @return
     */
    public static String generateStringByCurrentTimeMillisAndUUID(){
        return System.currentTimeMillis() + UUID.randomUUID().toString().replace("-", "");
    }
}
