/**
 * Created by xin on 08/12/2016.
 */
package com.kyee.iot.common.service;

import com.kyee.iot.common.dao.IEmqMessageDao;
import com.kyee.iot.common.emqMessage.AbstractEmqMessage;
import com.kyee.iot.common.emqMessage.MqttDelayBody;
import com.kyee.iot.common.util.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 消息推送的入口，兼容先前的流程。2017年5月9日10:41:23
 * */
@Component
@Slf4j
public class PushService {

    @Autowired
    PushServiceWorker pushServiceWorker;
    @Autowired
    IEmqMessageDao iEmqMessageDao;

    DelayQueue<MqttDelayBody> mqttQueue = new DelayQueue<>();
    ExecutorService exec = Executors.newCachedThreadPool();

    @PostConstruct
    public void init() {
        exec.execute(new PushConsumer(mqttQueue));
    }

    //指定设备推送
    public void pushByMac(AbstractEmqMessage pushMessage) {
        if (StringUtils.isEmpty(pushMessage.getTopic())) {
            String mac = pushMessage.getMacAddress();
            pushMessage.setTopic(mac);
        }
        pushMessage.setMessageBody(JSONUtil.toJSONString(pushMessage));
        iEmqMessageDao.save(pushMessage);
        pushMessage.setMessageBody(null);
        doPush(pushMessage.getTopic(), JSONUtil.toJSONString(pushMessage));
    }

    //全病区推送
    public void pushByWard(AbstractEmqMessage pushMessage) {
        if (StringUtils.isEmpty(pushMessage.getTopic())) {
            String wardNo = pushMessage.getWardNo();
            pushMessage.setTopic(wardNo);
        }
        pushMessage.setMessageBody(JSONUtil.toJSONString(pushMessage));
        iEmqMessageDao.save(pushMessage);
        pushMessage.setMessageBody(null);
        doPush(pushMessage.getTopic(), JSONUtil.toJSONString(pushMessage));
    }

    //主题推送
    public void pushByTopic(String topic, AbstractEmqMessage pushMessage) {
        pushMessage.setTopic(topic);
        pushMessage.setMessageBody(JSONUtil.toJSONString(pushMessage));
        iEmqMessageDao.save(pushMessage);
        pushMessage.setMessageBody(null);
        doPush(topic, JSONUtil.toJSONString(pushMessage));
    }

    //主题推送
    public void pushByTopic(String topic,String pushMessageStr) {
        doPush(topic, pushMessageStr);
    }

    //放入延迟消息队列中
    private void doPush(String dest,String payload){
        synchronized (PushService.class) {
            mqttQueue.put(new MqttDelayBody(dest, payload, pushServiceWorker));
        }
    }

}
