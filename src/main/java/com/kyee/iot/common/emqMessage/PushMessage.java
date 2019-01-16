package com.kyee.iot.common.emqMessage;

import com.kyee.iot.common.util.DateTimeUtil;
import com.kyee.iot.common.util.IDUtil;
import lombok.Data;


/**
 * Created by Administrator on 2018/9/3 0003.
 */
@Data
public class PushMessage extends AbstractEmqMessage {
    /**
     * 消息Id
     */
    private String messageId = IDUtil.randomUUID();
    /**
     * 消息类型
     */
    private String messageType;
    /**
     * 主题：mac地址或者wardNo
     */
    private String topic;
    /**
     * 发送时间
     */
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
    private int messageLevel = 1;
    /**
     * 是否需要展示
     */
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
    private String visitId = "";
    /**
     * 消息状态
     */
    private String messageStatus = "已发送";
    /**
     * 源消息ID,呼叫机推送消息类型的唯一标识
     */
    private String originId;
    private String showName;
    /**
     * 是否包含关键字，0为没有关键字，1为有关键字
     */
    private String isRehabilitationRel = "0";
    /**
     * 消息是否自动隐藏
     */
    private int isAutoDismiss = 0;
    /**
     * 是否静音： 0，不静音；1，静音
     */
    private int isMute = 0;
}
