package com.kyee.iot.common.emqMessage;

import com.kyee.iot.common.constant.MessageTypeConstant;
import com.kyee.iot.common.util.DateTimeUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by Administrator on 2018/9/3 0003.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PushResultMessage extends PushMessage {
    /**
     * 消息Id
     */
    @Builder.Default
    private String messageId = UUID.randomUUID().toString();
    /**
     * 消息类型
     */
    @Builder.Default
    private String messageType = MessageTypeConstant.PUSH_RESULT;
    /**
     * 主题：mac地址或者wardNo
     */
    private String topic;
    /**
     * 发送时间
     */
    @Builder.Default
    private String sendTime = DateTimeUtil.format(System.currentTimeMillis());

    //上为父下为子
    /**
     * message planId
     */
    private int planId;
    /**
     * 消息正文
     */
    private Object message;
    /**
     * 消息等级
     */
    @Builder.Default
    private int messageLevel = 1;
    /**
     * 是否需要展示
     */
    @Builder.Default
    private int isNeedToShow = 1;
    /**
     * mac地址
     */
    private String macAddress;
    /**
     * 病区编号
     */
    private String wardNo;
    /**
     * 床号
     */
    private String bedNo;
    /**
     * 患者id
     */
    private String patId = "";
    /**
     * 患者visitId
     */
    private String visitId;
    /**
     * 消息状态
     */
    @Builder.Default
    private String messageStatus = "已发送";
    /**
     * 源消息ID,呼叫机推送消息类型的唯一标识
     */
    private String originId;
    /**
     * 是否包含关键字，0为没有关键字，1为有关键字
     */
    @Builder.Default
    private String isRehabilitationRel = "";
}
