package com.kyee.iot.common.emqMessage;

/**
 * 创建人：周乐乐
 * 创建时间：2017年2月22日10:03
 * 任务号：IOTBEDSIDE-1559
 * 创建原因：Mqtt反馈消息
 */
public class MqttResponse {
    /**
     * 消息Id
     */
    private String messageId;
    /**
     * 病人Id
     */
    private String patientId;
    /**
     * 病人visitId
     */
    private String visitId;
    /**
     * 源消息ID,呼叫机推送消息类型的唯一标识
     */
    private String originId;
    /**
     * 病区号
     */
    private String wardNo;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getWardNo() {
        return wardNo;
    }

    public void setWardNo(String wardNo) {
        this.wardNo = wardNo;
    }
}
