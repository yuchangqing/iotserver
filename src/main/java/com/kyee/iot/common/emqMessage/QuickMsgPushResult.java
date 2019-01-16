package com.kyee.iot.common.emqMessage;

import lombok.Data;

/**
 * <pre>
 * author : wangzhonghao
 * time : 2018/07/09
 * desc :
 * </pre>
 */
@Data
public class QuickMsgPushResult {
    private int received;
    private int total;

    public boolean isAllReceived() {
        return received == total;
    }
}
