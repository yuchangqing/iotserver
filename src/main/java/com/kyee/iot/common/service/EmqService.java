package com.kyee.iot.common.service;

import com.kyee.iot.common.client.EmqClient;
import com.kyee.iot.common.domain.Client;
import com.kyee.iot.common.domain.EmqResp;
import com.kyee.iot.common.domain.Topic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2017/5/16.
 */
@Service
@Slf4j
public class EmqService {

    private static final int COUNT = 1000;
    private static final int index = 1;


    EmqClient client;

    @Autowired
    private PushService pushService;

    @Cacheable(value = "patientInfoForMacCache",key = "'mac'",sync=true)
    public List<Topic> getEmqTopics(){
        EmqResp<Topic> topicResp = Optional.ofNullable(client.getTopic("page_size=10000")).orElse(new EmqResp<>());
        return Optional.ofNullable(topicResp.getResult()).orElseGet(LinkedList::new);
    }

    public List<Client> getEmqClients(){
        EmqResp<Client> clientEmqResp = Optional.ofNullable(client.getClients("page_size=10000")).orElse(new EmqResp<>());
        return Optional.ofNullable(clientEmqResp.getResult()).orElseGet(LinkedList::new);
    }

    public void sendMsg(String topic, String msgBodyStr) {
        pushService.pushByTopic(topic, msgBodyStr);
    }
}
