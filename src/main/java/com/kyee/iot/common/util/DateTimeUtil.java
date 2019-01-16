package com.kyee.iot.common.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangl on 2017/6/28.
 * 时间转换工具类
 */
@Slf4j
public class DateTimeUtil {
    private static final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final String TIME = "TIME";

    private static final String MINUTE = "MINUTE";

    private static final String SECONDS = "SECONDS";

    /**
     * 将Date格式化为默认字符串格式
     * @param date
     * @return
     */
    public static String format(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMAT);
        return dateFormat.format(date);
    }

    /**
     * 将Date格式化为指定的format字符串格式
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date,String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 将时间戳格式化为默认字符串格式输出
     * @param time
     * @return
     */
    public static String format(Long time){
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMAT);
        return dateFormat.format(time);
    }

    /**
     * 将时间戳格式化为指定的format字符串格式
     * @param time
     * @param format
     * @return
     */
    public static String format(Long time, String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(time);
    }

    /**
     * 将其他字符串时间格式化为默认的时间格式,输入格式为14位，否则不进行转换
     * @param date
     * @return
     */
    public static String format(String date) {
        if (date.length() == 14) {
            String[] tokens = new String[6];
            tokens[0] = date.substring(0, 4);
            tokens[1] = date.substring(4, 6);
            tokens[2] = date.substring(6, 8);
            tokens[3] = date.substring(8, 10);
            tokens[4] = date.substring(10, 12);
            tokens[5] = date.substring(12, 14);
            return tokens[0] + "-" + tokens[1] + "-" + tokens[2] + " " + tokens[3] + ":" + tokens[4] + ":" + tokens[5];
        }
        return date;
    }

    /**
     * 计算Date时间差，输出为时间戳形式
     * @param now
     * @param date
     * @return
     */
    public static Long between(Date now, Date date) {
        if (now != null && date != null) {
            return now.getTime() - date.getTime();
        }
        return 0L;
    }

    /**
     * 计算时间相差的天数
     * @param start
     * @param end
     * @return
     */
    public static int diff(String start, String end) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormatUtil.STANDARD_DATE_FORMAT);
        Date startDate, endDate;
        try {
            startDate = dateFormat.parse(start);
            endDate = dateFormat.parse(end);
            return (int)((endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000L));
        }catch (ParseException e) {
            log.error("parse error,{}", e);
        }
        return 0;
    }

    /**
     * 计算时间相差的小时数/分钟数/秒数
     * @param start
     * @param end
     * @return
     */
    public static int diff(String start, String end, String type) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate, endDate;
        try {
            startDate = dateFormat.parse(start);
            endDate = dateFormat.parse(end);
            int diff = 0;
            switch (type){
                case TIME:
                    diff = (int)((endDate.getTime() - startDate.getTime()) / (60 * 60 * 1000L));
                    break;
                case MINUTE:
                    diff = (int)((endDate.getTime() - startDate.getTime()) / (60 * 1000L));
                    break;
                case SECONDS:
                    diff = (int)((endDate.getTime() - startDate.getTime()) / (1000L));
                    break;
                default:
                    diff = 0;
                    break;
            }
            return Math.abs(diff);
        }catch (ParseException e) {
            log.error("parse error,{}", e);
        }
        return 0;
    }


    /**
     * 字符串格式时间转换为Date
     * @param dateStr
     * @return
     */
    public static Date parseDate(String dateStr) {
        Date date = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMAT);
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            log.error("parse error,{}", e);
        }
        return date;
    }

    /**
     * 字符串时间格式转换为指定格式的Date
     * @param dateStr
     * @param regex
     * @return
     */
    public static Date parseDate(String dateStr,String regex){
        Date date = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(regex);
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            log.error("parse error,{}", e);
        }
        return date;
    }

    /**
     * 字符串格式时间转换为指定格式Date，并且对字符串格式时间进行严格校验
     * @param dateStr
     * @param regex
     * @param isLenient
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String dateStr, String regex, boolean isLenient) throws ParseException {
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(regex);
        if (!isLenient){
            dateFormat.setLenient(false);
        }
        date = dateFormat.parse(dateStr);
        return date;
    }
}
