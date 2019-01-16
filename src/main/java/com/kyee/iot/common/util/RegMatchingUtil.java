package com.kyee.iot.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 周乐乐
 * 创建时间：2016-09-13 11：40
 * 创建原因：正则匹配工具类
 */
public class RegMatchingUtil {
    /**
     * 用户姓名正则
     */
    public static final String REAL_NAME_REGEX = "^[\u4e00-\u9fa5]{1,25}";

    /**
     * 账号名名正则
     * 账号名以字母开头，字母数字或下划线组成，5-15位字符
     * 为兼容之前包含'-'的用户名,放开用户名限制
     */
    public static final String ACCOUNT_NAME_REGEX = "[A-Za-z0-9_]+";
    /**
     * 数字正则
     */
    public static final String NUMBER_REGEX = "[0-9]+";

    /**
     * 科室名正则
     */
    public static final String DEPT_NAME_REGEX = "^[\\S]+$";

    /**
     * 密码正则
     */
    public static final String PASSWORD_REGEX = "^[\\@A-Za-z0-9\\!\\#\\$\\%\\^\\&\\*\\.\\~]{1,18}$";


    public static boolean isValidPassword(String password) {
          return true;
//        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
//        Matcher matcher = pattern.matcher(password);
//        return matcher.matches();
    }


    public static boolean isValidRealName(String name) {
        Pattern pattern = Pattern.compile(REAL_NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean isValidNumber(String number) {
        Pattern pattern = Pattern.compile(NUMBER_REGEX);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public static boolean isValidDeptName(String deptName) {
        Pattern pattern = Pattern.compile(DEPT_NAME_REGEX);
        Matcher matcher = pattern.matcher(deptName);
        return matcher.matches();
    }
}
