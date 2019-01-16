package com.kyee.iot.common.emqMessage;

import lombok.Builder;
import lombok.Data;

/**
 * <pre>
 * author : wangzhonghao
 * time : 2018/07/09
 * desc :
 * </pre>
 */
@Data
@Builder
public class PushResultMessageData {
    private String originId;
    private int total;
    private int received;
}
