package com.kyee.iot.common.config;

import com.kyee.iot.common.configuration.PushServiceConfig;
import feign.auth.BasicAuthRequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


/**
 * Created by Administrator on 2017/5/16.
 */
@Slf4j
public class EmqClientConfig {

    @Autowired
    private PushServiceConfig pushServiceConfig;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(pushServiceConfig.getUsername(), pushServiceConfig.getPassword());
    }
//    @Bean
//    public RequestInterceptor logInterceptor() {
//        return requestTemplate -> log.info(requestTemplate.url() + requestTemplate.queryLine());
//    }

}
