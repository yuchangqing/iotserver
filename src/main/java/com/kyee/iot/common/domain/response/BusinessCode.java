package com.kyee.iot.common.domain.response;

/**
 * Created by zhanghao on 2017/2/22.
 * 业务状态码
 */
@SuppressWarnings("unused")
public class BusinessCode {
    /*
    * ADMIN药品查询成功
    * */
    public static final String MED_SEARCH_SUCCUSS = "MD_001";
    /*
    * ADMIN新建药品成功
    * */
    public static final String MED_CREATE_SUCESS = "MD_011";
    /*
    * ADMIN更新药品成功
    * */
    public static final String MED_UPDATE_SUCESS = "MD_021";
    /*
    * ADMIN删除药品成功
    * */
    public static final String MED_DELETE_SUCESS = "MD_031";

    /*
    * ADMIN查询药品参数缺少或错误
    * */
    public static final String MED_SEARCH_PARAMS_ERROR = "MD_002";
    /*
    * ADMIN新建药品参数缺少或错误
    * */
    public static final String MED_CREATE_PARAMS_ERROR = "MD_012";
    /*
    * ADMIN更新药品参数缺少或错误
    * */
    public static final String MED_UPDATE_PARAMS_ERROR = "MD_022";
    /*
    * ADMIN删除药品参数缺少或错误
    * */
    public static final String MED_DELETE_PARAMS_ERROR = "MD_032";

    /*
    * ADMIN新建药品重名
    * */
    public static final String MED_CREATE_NAME_REPEAT = "MD_013";
    /*
    * ADMIN更新药品重名
    * */
    public static final String MED_UPDATE_NAME_REPEAT = "MD_023";

    /*
    * ADMIN删除药品找不到原数据
    * */
    public static final String MED_DELETE_NOT_FOUND = "MD_034";

    /*
    * ADMIN药品库未知错误
    * */
    public static final String MED_UNKNOW_ERROR = "MD_999";

    //病区药品状态码
     /*
    * 病区药品查询成功
    * */
    public static final String WARD_MED_SEARCH_SUCCESS = "WMD_001";
    /*
    * 病区新建药品成功
    * */
    public static final String WARD_MED_CREATE_SUCCESS = "WMD_011";
    /*
    * 病区更新药品成功
    * */
    public static final String WARD_MED_UPDATE_SUCCESS = "WMD_021";
    /*
    * 病区删除药品成功
    * */
    public static final String WARD_MED_DELETE_SUCCESS = "WMD_031";

    /*
    * 病区查询药品参数缺少或错误
    * */
    public static final String WARD_MED_SEARCH_PARAMS_ERROR = "WMD_002";
    /*
    * 病区新建药品参数缺少或错误
    * */
    public static final String WARD_MED_CREATE_PARAMS_ERROR = "WMD_012";
    /*
    * 病区更新药品参数缺少或错误
    * */
    public static final String WARD_MED_UPDATE_PARAMS_ERROR = "WMD_032";

    /*
    * 病区新建药品重名
    * */
    public static final String WARD_MED_CREATE_NAME_REPEAT = "WMD_013";
    /*
    * 病区更新药品重名
    * */
    public static final String WARD_MED_UPDATE_NAME_REPEAT = "WMD_023";

    /*
    * 病区删除药品找不到原数据
    * */
    public static final String WARD_MED_DELETE_NOT_FOUND = "WMD_034";
    /*
    * 删除病区图片成功
    * */
    public static final String WARD_MED_DELETE_ICON_SUCCESS = "WMD_024";
    /*
    * 病区查询病人成功
    * */
    public static final String WARD_PATIENT_FOUND_SUCCESS = "WMD_035";

    /*
    * 病区查询病人失败
    * */
    public static final String WARD_PATIENT_FOUND_FAIL = "WMD_036";

    /*
    * 病区查询护理类型信息成功
    * */
    public static final String WARD_CARDTYPE_FOUND_SUCCESS = "WMD_037";

    /*
    * 病区查询护理类型信息失败
    * */
    public static final String WARD_CARDTYPE_FOUND_FAIL = "WMD_038";

    /*
    * 添加护理图标成功
    * */
    public static final String WARD_ADD_NURSECARD_SUCCESS = "WMD_039";

    /*
    * 添加护理图标失败
    * */
    public static final String WARD_ADD_NURSECARD_FAIL = "WMD_040";

    /*
    * 添加护理图标成功
    * */
    public static final String WARD_UPDATE_CARDCOLOR_SUCCESS = "WMD_041";

    /*
    * 添加护理图标失败
    * */
    public static final String WARD_UPDATE_CARDCOLOR_FAIL = "WMD_042";

    /*
    * 替换护理图标成功
    * */
    public static final String WARD_REPLACE_CARD_SUCCESS = "WMD_043";

    /*
    * 替换护理图标失败
    * */
    public static final String WARD_REPLACE_CARD_FAIL = "WMD_044";

    /*
    * 添加病人护理注意事项成功
    * */
    public static final String WARD_ADD_PATIENT_CARD_SUCCESS = "WMD_045";

    /*
    * 添加病人护理注意事项失败
    * */
    public static final String WARD_ADD_PATIENT_CARD_FAIL = "WMD_046";

    /*
    * 病区药品库未知错误
    * */
    public static final String WARD_MED_UNKNOWN_ERROR = "WMD_999";

    /*
    * 删除护理图标信息参数缺少或错误
    * */
    public static final String NUR_DELETE_PARAMS_ERROR = "NUR_21";
    /*
    * 删除护理图标信息删除成功
    * */
    public static final String NUR_DELETE_SUCCESS = "NUR_22";
    /*
    * 删除护理图标信息找不到原数据
    * */
    public static final String NUR_DELETE_NOT_FOUND = "NUR_23";
    /*
   * 更新护理图标信息不存在
   * */
    public static final String NUR_UPDATE_NOT_FOUND = "NUR_31";
    /*
    * 更新护理图标信息名称重复
    * */
    public static final String NUR_UPDATE_REPEAT = "NUR_32";
    /*
    * 更新护理图标信息成功
    * */
    public static final String NUR_UPDATE_SUCCESS = "NUR_33";

    /*
   * 保存护理图标图片成功
   * */
    public static final String NUR_SAVE_FILE_SUCCESS = "NUR_44";
    /*
   * 保存护理图标图片失败
   * */
    public static final String NUR_SAVE_FILE_ERROR = "NUR_55";
    /**
     * 上传患者头像成功
     */
    public static final String PAT_SAVE_PIC_SUCCESS = "PAT_66";
    /**
     * 上传患者头像失败
     */
    public static final String PAT_SAVE_PIC_ERROR = "PAT_77";


    //第三方业务状态码
    /**
     * 第三方自定义消息发送成功
     */
    public static final String THIRD_PARTY_SEND_MESSAGE_SUCCESS = "TP_001";

    /**
     * 第三方请求缺少参数
     */
    public static final String THIRD_PARTY_PARAM_ERROR = "TP_002";

    /**
     * 第三方请求找不到指定患者的设备
     */
    public static final String THIRD_PARTY_NOT_FOUND_DEVICE = "TP_003";

    /**
     * 第三方自定义消息连接不到推送服务器
     */
    public static final String THIRD_PARTY_SEND_MESSAGE_LOSE_SERVER = "TP_004";

    /**
     * 第三方自定义消息未知错误
     */
    public static final String THIRD_PARTY_SEND_MESSAGE_UNKNOW_ERROR = "TP_999";

    /**
     * 查询文件服务器上文件路径成功
     */
    public static final String FILE_SERVER_QUERY_SUCCESS = "FSQ_001";
    /**
     * 查询文件服务器上文件路径失败
     */
    public static final String FILE_SERVER_QUERY_FAIL = "FSQ_002";

    //上传文件相关业务状态码
    /*
    * 病区文件上传全部成功
    * */
    public static final String WARD_FILE_ADD_ALL_SUCCESS = "WF_001";

    /*
    * 病区文件上传全部失败
    * */
    public static final String WARD_FILE_ADD_ALL_FAIL = "WF_002";

    /*
    * 病区文件上传部分成功
    * */
    public static final String WARD_FILE_ADD_SOME_SUCCESS = "WF_003";

    /*
    * 病区文件更新全部成功
    * */
    public static final String WARD_FILE_UPDATE_ALL_SUCCESS = "WF_011";

    /*
    * 病区文件更新全部失败
    * */
    public static final String WARD_FILE_UPDATE_ALL_FAIL = "WF_012";

    /*
    * 病区文件更新部分成功
    * */
    public static final String WARD_FILE_UPDATE_SOME_SUCCESS = "WF_013";

    /*
    * 病区文件删除全部成功
    * */
    public static final String WARD_FILE_DELETE_ALL_SUCCESS = "WF_021";

    /*
    * 病区文件删除全部失败
    * */
    public static final String WARD_FILE_DELETE_ALL_FAIL = "WF_022";

    /*
    * 病区文件删除部分成功
    * */
    public static final String WARD_FILE_DELETE_SOME_SUCCESS = "WF_023";

    /*
    * 病区文件未知错误
    * */
    public static final String WARD_FILE_UNKNOW_ERROR = "WF_999";

    //宣教反馈
    /**
     * 查询成功
     */
    public static final String HEALTH_FEEDBACK_SEARCH_SUCCESS = "HFB_100";

    //病人信息
    /**
     * 查询成功
     */
    public static final String PATIENT_SEARCH_SUCCESS = "PAT_101";


    /**
     * 设备模块更新成功
     */
    public static final String DEVICE_MGR_UPDATE_SUCCESS = "DM_001";

    /**
     * 设备模块更新设备参数错误
     */
    public static final String DEVICE_MGR_PARAM_ERROR = "DM_002";

    /**
     * 设备模块查询成功
     */
    public static final String DEVICE_MGR_QUERY_SUCCESS = "DM_003";

    /**
     * 通用模块配置参数错误
     */
    public static final String COMMON_CONFIG_PARAM_ERROR = "CC_002";

    /**
     * 通用配置参数更新成功
     */
    public static final String COMMON_CONFIG_UPDATE_SUCCESS = "CC_001";

    /**
     * 通用配置参数查询成功
     */
    public static final String COMMON_CONFIG_QUERY_SUCCESS = "CC_003";

    //服务评价
    /**
     * 服务评价查询成功
     */
    public static final String QUESTION_NAIRE_QUERY_SUCCESS = "QN_055";
    /**
     * 服务评价查询失败
     */
    public static final String QUESTION_NAIRE_QUERY_ERROR = "QN_056";
    /**
     * 服务评价删除成功
     */
    public static final String QUESTION_NAIRE_DELETE_SUCCESS = "QN_057";
    /**
     * 服务评价删除失败
     */
    public static final String QUESTION_NAIRE_DELETE_ERROR = "QN_058";


    /**
     * 配置病区菜单密码成功
     */
    public static final String COMMON_CONFIG_WARD_PASSWORD_SUCCESS = "CC_004";

    /**
     * 配置病区菜单密码失败
     */
    public static final String COMMON_CONFIG_WARD_PASSWORD_FAIL = "CC_005";
    /*
     * 通用配置费用提醒配置查询成功
     */
    public static final String COMMON_CONFIG_FEE_CONFIG_QUERY_SUCCESS = "FC_001";

    /**
     * 通用配置费用提醒配置查询失败
     */
    public static final String COMMON_CONFIG_FEE_CONFIG_QUERY_FAIL = "FC_002";

    /**
     * 通用配置费用提醒更新成功
     */
    public static final String COMMON_CONFIG_FEE_CONFIG_UPDATE_SUCCESS = "FC_011";

    /**
     * 通用配置费用提醒配置更新失败
     */
    public static final String COMMON_CONFIG_FEE_CONFIG_UPDATE_FAIL = "FC_012";

    /**
     * 通用配置费用提醒配置参数错误
     */
    public static final String COMMON_CONFIG_FEE_CONFIG_PARAM_ERROR = "FC_021";

    //服务评价pdf相关
    /**
     * 试卷查询失败
     */
    public static final String QUESTIONNAIRE_PDF_ERROR = "QNPDF_033";
    /*
     *试卷查询成功
     */
    public static final String QUESTIONNAIRE_PDF_SUCCESS = "QNPDF_034";

    //医护第三方app
    public static final String MEDICAL_THIRD_APP_SUCCESS = "MTA_030";
    public static final String MEDICAL_THIRD_APP_ERROR = "MTA_031";
    //自定义菜单
    public static final String CUSTOM_MENU_CONFIG_SUCCESS = "MTA_032";
    public static final String CUSTOM_MENU_CONFIG_ERROR = "MTA_033";

    /**
     * 服务端日志查询成功
     */
    public static final String SERVER_LOG_FOUND = "SL_001";
    /**
     * 服务端日志查询失败
     */
    public static final String SERVER_LOG_NOT_FOUND = "SL_002";

    /**
     * 查询医院配置成功
     */
    public static final String HOSPITAL_CONFIG_SUCCESS = "HS_001";

    /**
     * 配置参数错误
     */
    public static final String PARAM_CONFIG_SET_ERROR = "PC_002";

    /**
     * 配置参数更新成功
     */
    public static final String PARAM_CONFIG_UPDATE_SUCCESS = "PC_001";

    /**
     * 配置参数查询成功
     */
    public static final String PARAM_CONFIG_QUERY_SUCCESS = "PC_003";

    /**
     * 配置文件更新成功
     */
    public static final String PARAM_CONFIG_FILE_UPDATE_SUCCESS = "PC_004";

    //康复计划
    public static final String RECOVERY_PLAN_SUCCESS = "RPS_033";
    public static final String RECOVERY_PLAN_ERROR = "RPS_034";
    //病区宣教
    public static final String RECOVERY_HEALTH_SUCCESS = "RHS_031";
    public static final String RECOVERY_HEALTH_ERROR = "RHS_032";
    public static final String RECOVERY_VISIT_HISTORY_SUCCESS = "RVHS_001";
    public static final String RECOVERY_VISIT_HISTORY_FAIL = "RVHS_002";
    public static final String RECOVERY_EXPORT_SUCCESS = "RES_001";
    //患者日程
    public static final String PAT_SCH_CONF_SUCCESS = "PSCS_001";
    //康复资料库
    public static final String RECOVERY_THEME_SUCCESS = "PTS_001";

    /**
     * 查询医院巡检信息成功
     */
    public static final String HOSPITAL_PATROL_SUCCESS = "HP_001";
    /**
     * 查询医院巡检信息失败
     */
    public static final String HOSPITAL_PATROL_ERROR = "HP_002";

    /**
     * 影音娱乐
     */
    public static final String ENTERTAIN_VIDEO_SUCCESS = "EVS_041";
    public static final String ENTERTAIN_VIDEO_ERROR = "EVS_042";

    public static final String STATISTIC_DATA_SUCCESS = "SD_000";
    public static final String STATISTIC_DATA_NOT_FOUND = "SD_001";
    public static final String STATISTIC_DATA_CLEAN_FAIL = "SD_002";
    public static final String STATISTIC_DATA_MD5_FAIL = "SD_003";

    public static final String JSON_VALIDATE_ERROR = "JV_001";

    /**
     * 移动护士站
     */
    public static final String WRONG_PARAMS = "WP_001";

    public static final String NURSE_STATION_SUCCESS_PATIENTS = "NSS_001";
    public static final String NURSE_STATION_FAIL_PATIENTS = "NSF_001";
    public static final String NURSE_STATION_ERROR_PATIENTS = "NSE_001";

    public static final String NURSE_STATION_SUCCESS_PATIENT_DETAIL = "NSS_002";
    public static final String NURSE_STATION_FAIL_PATIENT_DETAIL = "NSF_002";
    public static final String NURSE_STATION_ERROR_PATIENT_DETAIL = "NSE_002";

    public static final String NURSE_STATION_SUCCESS_SIGN_ITEM_DIRC = "NSS_003";
    public static final String NURSE_STATION_FAIL_SIGN_ITEM_DIRC = "NSF_003";
    public static final String NURSE_STATION_ERROR_SIGN_ITEM_DIRC = "NSE_003";

    public static final String NURSE_STATION_SUCCESS_SIGN_DATA = "NSS_004";
    public static final String NURSE_STATION_FAIL_SIGN_DATA = "NSF_004";
    public static final String NURSE_STATION_ERROR_SIGN_DATA = "NSE_004";

    public static final String NURSE_STATION_SUCCESS_TEMP_CHART = "NSS_005";
    public static final String NURSE_STATION_FAIL_TEMP_CHART = "NSF_005";
    public static final String NURSE_STATION_ERROR_TEMP_CHART = "NSE_005";

    public static final String NURSE_STATION_SUCCESS_TIME = "NSS_006";
    public static final String NURSE_STATION_FAIL_TIME = "NSF_006";
    public static final String NURSE_STATION_ERROR_TIME = "NSE_006";

    public static final String NURSE_STATION_SUCCESS_SAVE_DATA = "NSS_007";
    public static final String NURSE_STATION_FAIL_SAVE_DATA = "NSF_007";
    public static final String NURSE_STATION_ERROR_SAVE_DATA = "NSE_007";

    public static final String NURSE_STATION_SUCCESS_GET_ORDER = "NSS_008";
    public static final String NURSE_STATION_FAIL_GET_ORDER = "NSF_008";
    public static final String NURSE_STATION_ERROR_GET_ORDER = "NSE_008";

    public static final String NURSE_STATION_SUCCESS_GET_ORDER_DETAIL = "NSS_009";
    public static final String NURSE_STATION_FAIL_GET_ORDER_DETAIL = "NSF_009";
    public static final String NURSE_STATION_ERROR_GET_ORDER_DETAIL = "NSE_009";

    public static final String NURSE_STATION_SUCCESS_GET_REASON_DICT = "NSS_010";
    public static final String NURSE_STATION_FAIL_GET_REASON_DICT = "NSF_010";
    public static final String NURSE_STATION_ERROR_GET_REASON_DICT = "NSE_010";

    public static final String NURSE_STATION_SUCCESS_PAUSE_ORDER = "NSS_011";
    public static final String NURSE_STATION_FAIL_PAUSE_ORDER = "NSF_011";
    public static final String NURSE_STATION_ERROR_PAUSE_ORDER = "NSE_011";

    public static final String NURSE_STATION_SUCCESS_CANCEL_PAUSE_ORDER = "NSS_012";
    public static final String NURSE_STATION_FAIL_CANCEL_PAUSE_ORDER = "NSF_012";
    public static final String NURSE_STATION_ERROR_CANCEL_PAUSE_ORDER = "NSE_012";

    public static final String NURSE_STATION_SUCCESS_INFUSION_COMPLETED = "NSS_013";
    public static final String NURSE_STATION_FAIL_INFUSION_COMPLETED = "NSF_013";
    public static final String NURSE_STATION_ERROR_INFUSION_COMPLETED = "NSE_013";

    public static final String NURSE_STATION_SUCCESS_EXEC_ORDERS = "NSS_014";
    public static final String NURSE_STATION_FAIL_EXEC_ORDERS = "NSF_014";
    public static final String NURSE_STATION_ERROR_EXEC_ORDERS = "NSE_014";


    public static final String GLOBAL_PARAM_GET_SUCCESS = "GPG_001";
    public static final String GLOBAL_PARAM_GET_FAIL = "GPG_002";
    public static final String GLOBAL_PARAM_SAVE_SUCCESS = "GPS_001";
    public static final String GLOBAL_PARAM_SAVE_FAIL = "GPS_002";
    /**
     * 医护界面验证
     */
    public static final String STAFFID_VERIFY_SUCCESS = "ACCESS_01";
    public static final String STAFFID_VERIFY_ERROR = "ACCESS_02";

    public static final String NURSE_STATION_SUCCESS_INFUSION_TOUR_NORMAL = "NSS_015";
    public static final String NURSE_STATION_FAIL_INFUSION_TOUR_NORMAL = "NSF_015";
    public static final String NURSE_STATION_ERROR_INFUSION_TOUR_NORMAL = "NSE_015";

    public static final String NURSE_STATION_SUCCESS_INFUSION_TOUR_EXCEPTION = "NSS_016";
    public static final String NURSE_STATION_FAIL_INFUSION_TOUR_EXCEPTION = "NSF_016";
    public static final String NURSE_STATION_ERROR_INFUSION_TOUR_EXCEPTION = "NSE_016";

    public static final String NURSE_STATION_SUCCESS_OVERDUE_EXEC = "NSS_017";
    public static final String NURSE_STATION_FAIL_OVERDUE_EXEC = "NSF_017";
    public static final String NURSE_STATION_ERROR_OVERDUE_EXEC = "NSE_017";

    public static final String NURSE_STATION_SUCCESS_HIGH_RISK_EXEC = "NSS_018";
    public static final String NURSE_STATION_FAIL_HIGH_RISK_EXEC = "NSF_018";
    public static final String NURSE_STATION_ERROR_HIGH_RISK_EXEC = "NSE_018";

    public static final String NURSE_STATION_SUCCESS_CHECK_FOR_MED = "NSS_019";
    public static final String NURSE_STATION_FAIL_CHECK_FOR_MED = "NSF_019";
    public static final String NURSE_STATION_ERROR_CHECK_FOR_MED = "NSE_019";

    public static final String FEE_CLASSIFICATION_SUCCESS = "FCS_001";
    public static final String FEE_CLASSIFICATION_ERROR = "FCE_001";

    public static final String NURSE_STATION_SUCCESS_GET_WARD_SIGN_TIME = "NSS_020";
    public static final String NURSE_STATION_FAIL_GET_WARD_SIGN_TIME = "NSF_020";
    public static final String NURSE_STATION_ERROR_GET_WARD_SIGN_TIME = "NSE_020";

    public static final String NURSE_STATION_SUCCESS_GET_WARD_SIGNS = "NSS_021";
    public static final String NURSE_STATION_FAIL_GET_WARD_SIGNS = "NSF_021";
    public static final String NURSE_STATION_ERROR_GET_WARD_SIGNS = "NSE_021";

    public static final String NURSE_STATION_SUCCESS_QUERY_INSPECT_ORDER = "NSS_022";
    public static final String NURSE_STATION_FAIL_QUERY_INSPECT_ORDER = "NSF_022";
    public static final String NURSE_STATION_ERROR_QUERY_INSPECT_ORDER = "NSE_022";

    public static final String NURSE_STATION_SUCCESS_DO_SPECIMEN_INSPECTS = "NSS_023";
    public static final String NURSE_STATION_FAIL_DO_SPECIMEN_INSPECTS = "NSF_023";
    public static final String NURSE_STATION_ERROR_DO_SPECIMEN_INSPECTS = "NSE_023";

    public static final String NURSE_STATION_SUCCESS_DO_SPECIMEN_ERROR = "NSS_024";
    public static final String NURSE_STATION_FAIL_DO_SPECIMEN_ERROR = "NSF_024";
    public static final String NURSE_STATION_ERROR_DO_SPECIMEN_ERROR = "NSE_024";

    public static final String NURSE_STATION_SUCCESS_DO_SPECIMEN_START = "NSS_025";
    public static final String NURSE_STATION_FAIL_DO_SPECIMEN_START = "NSF_025";
    public static final String NURSE_STATION_ERROR_DO_SPECIMEN_START = "NSE_025";

    public static final String NURSE_STATION_SUCCESS_DO_SPECIMEN_URGENT = "NSS_026";
    public static final String NURSE_STATION_FAIL_DO_SPECIMEN_URGENT = "NSF_026";
    public static final String NURSE_STATION_ERROR_DO_SPECIMEN_URGENT = "NSE_026";

    public static final String NURSE_STATION_SUCCESS_DO_SPECIMEN_PRIOR = "NSS_027";
    public static final String NURSE_STATION_FAIL_DO_SPECIMEN_PRIOR = "NSF_027";
    public static final String NURSE_STATION_ERROR_DO_SPECIMEN_PRIOR = "NSE_027";

    public static final String NURSE_STATION_SUCCESS_DO_NOT_BLOOD = "NSS_028";
    public static final String NURSE_STATION_FAIL_DO_NOT_BLOOD = "NSF_028";
    public static final String NURSE_STATION_ERROR_DO_NOT_BLOOD = "NSE_028";

    public static final String NUSRSE_STATION_NURSE_SCANNER_BIND_SUCCESS = "NSBS_001";
    public static final String NUSRSE_STATION_NURSE_SCANNER_BIND_ERROR = "NSBE_001";
    public static final String NUSRSE_STATION_NURSE_SCANNER_BIND_FAIL = "NSBF_001";

    public static final String NUSRSE_STATION_NURSE_SCANNER_UNBIND_SUCCESS = "NSBS_002";
    public static final String NUSRSE_STATION_NURSE_SCANNER_UNBIND_ERROR = "NSBE_002";
    public static final String NUSRSE_STATION_NURSE_SCANNER_UNBIND_FAIL = "NSBF_002";

    public static final String NUSRSE_STATION_NURSE_SCANNER_FIND_SUCCESS = "NSBS_003";
    public static final String NUSRSE_STATION_NURSE_SCANNER_FIND_ERROR = "NSBE_003";
    public static final String NUSRSE_STATION_NURSE_SCANNER_FIND_FAIL = "NSBF_003";

    public static final String NUSRSE_STATION_NURSE_PATIENT_BIND_SUCCESS = "NSBS_004";
    public static final String NUSRSE_STATION_NURSE_PATIENT_BIND_ERROR = "NSBE_004";
    public static final String NUSRSE_STATION_NURSE_PATIENT_BIND_FAIL = "NSBF_004";

    public static final String NUSRSE_STATION_NURSE_PATIENT_UNBIND_SUCCESS = "NSBS_005";
    public static final String NUSRSE_STATION_NURSE_PATIENT_UNBIND_ERROR = "NSBE_005";
    public static final String NUSRSE_STATION_NURSE_PATIENT_UNBIND_FAIL = "NSBF_005";

    public static final String NUSRSE_STATION_NURSE_PATIENT_CHECK_SUCCESS = "NSBS_006";
    public static final String NUSRSE_STATION_NURSE_PATIENT_CHECK_ERROR = "NSBE_006";
    public static final String NUSRSE_STATION_NURSE_PATIENT_CHECK_FAIL = "NSBF_006";

    public static final String NURSE_STATION_SUCCESS_GET_NURSING_SCORE_FORMS = "NSS_029";
    public static final String NURSE_STATION_FAIL_GET_NURSING_SCORE_FORMS = "NSF_029";
    public static final String NURSE_STATION_ERROR_GET_NURSING_SCORE_FORMS = "NSE_029";

    public static final String NURSE_STATION_SUCCESS_GET_NURSING_SCORE_FORM_STRUCT = "NSS_030";
    public static final String NURSE_STATION_FAIL_GET_NURSING_SCORE_FORM_STRUCT = "NSF_030";
    public static final String NURSE_STATION_ERROR_GET_NURSING_SCORE_FORM_STRUCT = "NSE_030";

    public static final String NURSE_STATION_SUCCESS_GET_COLOR = "NSS_031";
    public static final String NURSE_STATION_FAIL_GET_COLOR = "NSF_031";
    public static final String NURSE_STATION_ERROR_GET_COLOR = "NSE_031";

    public static final String NURSE_STATION_SUCCESS_GET_TIME_POINT = "NSS_032";
    public static final String NURSE_STATION_FAIL_GET_TIME_POINT = "NSF_032";
    public static final String NURSE_STATION_ERROR_GET_TIME_POINT = "NSE_032";

    public static final String NURSE_STATION_SUCCESS_GET_DETAIL_FORM = "NSS_033";
    public static final String NURSE_STATION_FAIL_GET_DETAIL_FORM = "NSF_033";
    public static final String NURSE_STATION_ERROR_GET_DETAIL_FORM = "NSE_033";

    public static final String NURSE_STATION_SUCCESS_SAVE_DETAIL_FORM = "NSS_034";
    public static final String NURSE_STATION_FAIL_SAVE_DETAIL_FORM = "NSF_034";
    public static final String NURSE_STATION_ERROR_SAVE_DETAIL_FORM = "NSE_034";

    public static final String NURSE_STATION_SUCCESS_DEL_DETAIL_FORM = "NSS_035";
    public static final String NURSE_STATION_FAIL_DEL_DETAIL_FORM = "NSF_035";
    public static final String NURSE_STATION_ERROR_DEL_DETAIL_FORM = "NSE_035";

    public static final String SCANNER_STATION_SUCCESS_INSERT_INTO_FORM = "SIT_035";
    public static final String SCANNER_STATION_FAIL_INSERT_INTO_FORM = "SIT_035";
    public static final String SCANNER_STATION_ERROR_INSERT_INTO_FORM = "SIT_035";


    public static final String WHITE_LIST_QUERY_SUCCESS = "WLQS_001";
    public static final String WHITE_LIST_QUERY_FAIL = "WLQS_002";
    public static final String WHITE_LIST_UPDATE_SUCCESS = "WLQS_003";
    public static final String WARD_CARE_CALL_SUCCESS = "WLQS_004";

    public static final String WHITE_LIST_NOT_BIND_MANY_CALL_SERVER = "WLQS_004";
    public static final String WHITE_LIST_BIND_MANY_CALL_SERVER = "WLQS_005";

    public static final String PATIENT_ROUNDS_REC_SAVE_SUCCESS = "PRRQ_000";
    public static final String PATIENT_ROUNDS_REC_QUERY_SUCCESS = "PRRQ_001";
    public static final String PATIENT_ROUNDS_REC_UPDATE_SUCCESS = "PRRQ_002";

    public static final String CALL_RECORD_STATISTICS_SUCCESS = "CRSS_001";
    
    public static final String CALL_SERVER_REPORT_IP_SUCCESS = "CSRIS_001";

    public static final String PAT_DELIVERY_INFO_QUERY_SUCCESS = "PDI_001";
    public static final String PAT_DELIVERY_INFO_QUERY_FAIL = "PDI_002";
    public static final String PAT_DELIVERY_INFO_UPDATE_SUCCESS = "PDI_003";
    public static final String PAT_DELIVERY_INFO_UPDATE_FAIL = "PDI_004";
    public static final String PAT_DELIVERY_NOTICE_INFO_QUERY_SUCCESS = "PDI_005";
    public static final String PAT_DELIVERY_NOTICE_INFO_QUERY_FAIL = "PDI_006";
    public static final String PAT_DELIVERY_NOTICE_INFO_UPDATE_SUCCESS = "PDI_007";
    public static final String PAT_DELIVERY_NOTICE_INFO_UPDATE_FAIL = "PDI_008";


}