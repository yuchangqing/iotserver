package com.kyee.iot.common.domain;

import lombok.Data;

/**
 * @author liangfei
 */
@Data
public class Client {
    private String clientId;
    private String ipaddress;
    private String connected_at;
}
