package com.kyee.iot.common.service;

import com.kyee.iot.common.emqMessage.MqttDelayBody;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.DelayQueue;

/**
 * Created by Administrator on 2017/5/8.
 */
@Slf4j
public class PushConsumer implements Runnable {

    private DelayQueue<MqttDelayBody> MqttQueue;
    public PushConsumer(DelayQueue<MqttDelayBody> students) {
        super();
        this.MqttQueue = students;
    }

    @Override
    public void run() {
        try {
            log.info("start PushConsumer ");
            while (true) {
                MqttQueue.take().run();
            }
        } catch (InterruptedException e) {
            log.error("error", e);
        }
    }
}
