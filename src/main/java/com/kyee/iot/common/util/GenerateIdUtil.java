package com.kyee.iot.common.util;

import java.text.*;
import java.util.Calendar;

/**
 * Created by fangxinhe on 2017/3/8.
 * 生成全局唯一id
 */
public class GenerateIdUtil {

    /** The FieldPosition. */
    private static final FieldPosition HELPER_POSITION = new FieldPosition(0);

    /** This Format for format the data to special format. */
    private final static Format dateFormat = new SimpleDateFormat("YYYYMMddHHmmssS");

    /** This Format for format the number to special format. */
    private final static NumberFormat numberFormat = new DecimalFormat("00");

    /** This int is the sequence number ,the default value is 0. */
    private static int seq = 0;

    private static final int MAX = 9999;

    /**
     * 时间格式生成序列
     * @return String
     */
    public static synchronized String generateId() {

        Calendar rightNow = Calendar.getInstance();

        StringBuffer sb = new StringBuffer();

        dateFormat.format(rightNow.getTime(), sb, HELPER_POSITION);

        numberFormat.format(seq, sb, HELPER_POSITION);

        if (seq == MAX) {
            seq = 0;
        } else {
            seq++;
        }

        return sb.toString();
    }
}
