package com.kyee.iot.common.configuration;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Description
 *
 * @author wangbingfu
 * @Date 2018/09/06
 */
@Component
@Slf4j
@Getter
public class PushServiceConfig {

    @Value(value = "${pushService.host:'undefined'}")
    private String host;

    @Value("${pushService.userName:'admin'}")
    private String username;

    @Value("${pushService.passWord:'public'}")
    private String password;

    @Value("${pushService.monitor}")
    private String monitor;

    @Value("${pushService.maxInflight}")
    private int maxInflight;


}
