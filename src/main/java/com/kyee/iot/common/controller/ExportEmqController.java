package com.kyee.iot.common.controller;

import com.google.common.collect.Sets;
import com.kyee.iot.common.domain.Topic;
import com.kyee.iot.common.domain.response.Response;
import com.kyee.iot.common.domain.response.ResponseStatus;
import com.kyee.iot.common.service.EmqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Api("推送服务")
@RestController
public class ExportEmqController {

    @Autowired
    private EmqService emqService;

    @ApiOperation(nickname = "118001", value="A,判断topic是否有注册到EMQ SERVER上", notes="根据mac查询")
    @RequestMapping(value = "/v1/emq/judge/topic",method = RequestMethod.GET)
    public Response judgeEmqTopic(@RequestParam(value = "mac") String mac){
        String trueMacAddress = "([A-Fa-f0-9]{2}.){5}[A-Fa-f0-9]{2}";
        Set<String> emqStatusSet = Optional.ofNullable(emqService.getEmqTopics().stream().map(Topic::getTopic).filter(topic -> topic.matches(trueMacAddress)).collect(Collectors.toSet())).orElse(Sets.newHashSet());
        return Response.builder().message("获取成功").businessCode("200").status(ResponseStatus.SUCCESS).data(Topic.builder().topic(mac).count(emqStatusSet.contains(mac)?"1":"0").build()).build();
    }
}
