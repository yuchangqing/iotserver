package com.kyee.iot.common.util;

/**
 * @author 方心贺
 * 创建时间：2017年03月17日11:37:36
 * 创建原因：模糊匹配关键字转义
 */
public class FuzzySearchKeywordEscapeUtil {

    public static String escape(String keyword) {
        if (keyword == null || "".equals(keyword.trim())) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : keyword.trim().toCharArray()) {
            if (c == '%' || c == '_' || c == '/' || c == '\\') {//对这些特殊字符进行转义(因为在mysql的like中有特殊含义)
                sb.append('|');
            }
            sb.append(c);
        }
        return sb.toString();
    }

}
