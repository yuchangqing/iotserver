package com.kyee.iot.common.client;

import com.kyee.iot.common.config.EmqClientConfig;
import com.kyee.iot.common.domain.Client;
import com.kyee.iot.common.domain.EmqResp;
import com.kyee.iot.common.domain.Topic;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Administrator on 2017/5/16.
 */
@FeignClient(name = "EmqClient",url = "${pushService.monitor:'localhost'}",configuration = EmqClientConfig.class)
public interface EmqClient {

    /**
     * 请求emq server中的topic的详情
     * */
    @RequestMapping(value =  "/api/topics",method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    EmqResp<Topic> getTopic(@RequestBody String body);

    /**
     * 请求emq server中的topic的详情
     * */
    @RequestMapping(value =  "/api/clients",method = RequestMethod.GET)
    EmqResp<Client> getClients(@RequestBody String body);
}
