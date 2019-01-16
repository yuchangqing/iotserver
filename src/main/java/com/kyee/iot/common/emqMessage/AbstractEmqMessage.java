package com.kyee.iot.common.emqMessage;

import com.kyee.iot.common.util.DateTimeUtil;
import com.kyee.iot.common.util.IDUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018/9/3 0003.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbstractEmqMessage {
    /**
     * 消息Id
     */
    private String messageId = IDUtil.randomUUID();
    /**
     * 消息类型
     */
    private String messageType;
    /**
     * 消息正文
     */
    private Object message;
    /**
     * 消息正文String
     */
    private String messageBody;
    /**
     * 主题：mac地址或者wardNo
     */
    private String topic;

    private String wardNo;
    private String macAddress;
    /**
     * 发送时间
     */
    private String sendTime = DateTimeUtil.format(System.currentTimeMillis());
}
