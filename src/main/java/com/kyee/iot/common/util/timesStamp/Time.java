package com.kyee.iot.common.util.timesStamp;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author 康圣婕
 * 创建时间: 2016-10-21 15:11
 * 创建原因: 时间戳表示方式
 */
public class Time {
    private String valueOfString(String str, int len) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len - str.length(); i++) {
            stringBuilder.append("0");
        }
        return (stringBuilder.length() == 0) ? (str) : (stringBuilder.toString() + str);
    }
    private String getTimeString(Calendar calendar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf(calendar.get(Calendar.YEAR)))
                .append(this.valueOfString(String.valueOf(calendar.get(Calendar.MONTH) + 1),2))
                .append(this.valueOfString(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)),2))
                .append(this.valueOfString(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)),2))
                .append(this.valueOfString(String.valueOf(calendar.get(Calendar.MINUTE)),2))
                .append(this.valueOfString(String.valueOf(calendar.get(Calendar.SECOND)),2))
                .append(this.valueOfString(String.valueOf(calendar.get(Calendar.MILLISECOND)),3));
        return stringBuffer.toString();
    }
    public String getTimeString(){
        Calendar calendar = new GregorianCalendar();
        return this.getTimeString(calendar);
    }
}
