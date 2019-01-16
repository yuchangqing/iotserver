package com.kyee.iot.common.constant;

/**
 * Created by Administrator on 2018/9/3 0003.
 */
public class MessageTypeConstant {
    public static final String IOT_WARD = "IOT_WARD";
    public static final String SMART_ORDER= "smartOrderMessage";
    public static final String SPLIT_ORDER = "splitOrderMessage";
    public static final String INPATIENT_PAYMENT = "inpatientPayment";
    public static final String PAYMENT = "paymentMessage";
    public static final String INTELLIGENT_CALL = "intelligentCallMessage";
    /**
     * 探视呼叫推送
     */
    public static final String VISIT = "visitIntelligentCallMessage";
    public static final String CUSTOM = "customMessage";
    public static final String OPERATION_TYPE = "operationType";
    public static final String PLAN = "planMessage";
    public static final String OFF_PEAK = "offPeakMessage";
    public static final String MAP_DOWNLOAD = "mapDownloadMessage";
    public static final String GET_LOG = "getLog";
    public static final String FEE = "feeMessage";
    public static final String COMMON_CONFIG = "commonConfig";
    public static final String PUSH_RESULT = "pushResultMessage";
    /**
     * 第三方调用我们程序发出的消息
      */
    public static final String THIRD_PARTY = "thirdPartyMessage";
    /**
     * 呼叫机发出的快捷文字消息
     */
    public static final String QUICK = "quickMessage";
    /**
     * 呼叫机发出的快捷语音消息
     */
    public static final String QUICK_VOICE = "quickVoiceMessage";
    public static final String VIDEO_UPGRADE = "videoUpgradeMessage";
    public static final String PAPER_UPGRADE = "paperUpgradeMessage";
    public static final String HEALTH_UPGRADE = "healthUpgradeMessage";
    public static final String PERSONAL_UPGRADE = "personalUpgradeMessage";
    public static final String FIRMWARE_UPGRADE = "firmwareUpgrade";
    /**
     * 护理图标更新消息
     */
    public static final String NURSE_CARD_UPDATE = "nurseCardUpdateMessage";
    public static final String STAFF_HEAD = "staffHeadUpdate";
    public static final String DOORPLATE_UPDATE = "doorplateUpdateMessage";
    public static final String UPDATE = "updateMessage";
    /**
     * 代办事项
     */
    public static final String TODO = "todoMessage";
    /**
     * 天翼会话终断
     */
    public static final String CALL_CANCEL = "callCancelMessage";
    /**
     * 第三方apk安装消息
     */
    public static final String THIRD_APK =  "thirdApkMessage";
    /**
     * 第三方apk卸载消息
     */
    public static final String UNINSTALL_THIRD_APK = "uninstallThirdApkMessage";
    /**
     * 上传日志消息
     */
    public static final String UPLOAD_LOG_MESSAGE = "uploadLogMessage";
    /**
     * 签名文件消息
     */
    public static final String SIGN_FILE_MESSAGE = "signFileMessage";
}
