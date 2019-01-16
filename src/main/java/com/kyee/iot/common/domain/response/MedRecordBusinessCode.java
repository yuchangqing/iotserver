package com.kyee.iot.common.domain.response;

/**
 * Created by wangl on 2017/3/13.
 * 电子病历业务状态码
 */
public class MedRecordBusinessCode {
    /**
     * 电子病历信息列表查询成功
     */
    public static final String MED_RECORD_QUERY_SUCCESS = "MRQ_001";
    /**
     * 电子病历信息列表查询失败
     */
    public static final String MED_RECORD_QUERY_ERROR = "MRQ_002";
    /**
     * 电子病历信息列表查询未知错误
     */
    public static final String MED_RECORD_UNKNOWN_ERROR = "MR_999";
    /**
     * 获取电子病历列表对应的内容明细成功
     */
    public static final String MED_RECORD_DETAILES_QUERY_SUCCESS = "MRDQ_011";
    /**
     * 获取电子病历列表对应的内容明细失败
     */
    public static final String MED_RECORD_DETAILES_QUERY_ERROR = "MRDQ_012";
}
