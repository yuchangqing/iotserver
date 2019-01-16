package com.kyee.iot.common.controller;

import com.kyee.iot.common.constant.MessageTypeConstant;
import com.kyee.iot.common.domain.response.Response;
import com.kyee.iot.common.domain.response.ResponseStatus;
import com.kyee.iot.common.service.EmqService;
import com.kyee.iot.common.service.PushServiceWorker;
import com.kyee.iot.common.util.IDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Created by Administrator on 2017/5/16.
 */
@Api("推送服务")
@RestController
@Slf4j
public class EmqController {

    @Autowired
    private	EmqService emqService;
    @Autowired
    PushServiceWorker pushServiceWorker;
    @ApiOperation(nickname = "017002", value = "S,查询topic信息")
    @RequestMapping(value = "/emq/topics")
    public Response queryEmqTopic(){
        return Response.builder().message("获取成功").businessCode("200").status(ResponseStatus.SUCCESS).data(emqService.getEmqTopics()).build();
    }

    @PostMapping("/v1/emqMsg")
    @ApiOperation(value="压测消息推送")
    public void sendMsg(@RequestParam @ApiParam("主题") String topic) {
        LocalDateTime arrivalDate  = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String landing = arrivalDate.format(format);
        String msg = "{\"bedNo\":\"15\",\"isAutoDismiss\":0,\"isNeedToShow\":1,\"isRehabilitationRel\":\"0\",\"message\":{\"repeatTime\":-1,\"themeContext\":\"测试\",\"themeName\":\"\"},\"messageId\":\""+ IDUtil.randomUUID() + "\",\"messageLevel\":1,\"messageType\":\"" + MessageTypeConstant.IOT_WARD + "\",\"patId\":\"\",\"planId\":904,\"sendTime\":\""+ landing +"\",\"wardNo\":\"1008611\"}";
        emqService.sendMsg(topic, msg);
    }

    /**
     * 手动重连emq接口
     * @return
     */
    @ApiOperation(nickname = "017003", value="手动注册emq", notes="手动注册emq")
    @RequestMapping(value = "/v1/emq/connect",method = RequestMethod.GET)
    public Response connectEmq(){
        return pushServiceWorker.PushService_Init();
    }
}
