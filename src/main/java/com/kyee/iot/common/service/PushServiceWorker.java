/**
 * Created by xin on 08/12/2016.
 */
package com.kyee.iot.common.service;

import com.google.gson.Gson;
import com.kyee.iot.common.configuration.PushServiceConfig;
import com.kyee.iot.common.dao.IMsgPushCommonDao;
import com.kyee.iot.common.domain.response.Response;
import com.kyee.iot.common.domain.response.ResponseStatus;
import com.kyee.iot.common.emqMessage.*;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;


/**
 * 真正消息推送类
 * */
@Service
@Slf4j
public class PushServiceWorker {

    private int QoS = 1;
    private MqttClient client;

    private String feedback_topic = "ACK";
    private MqttConnectOptions options;
    @Autowired
    private IMsgPushCommonDao msgPushDao;
    @Autowired
    private Gson gson;

    @Autowired
    private PushServiceConfig config;

    @Autowired
    private PushService pushService;

    /**
     *  推送服务注册
     */
    @PostConstruct
    public synchronized Response PushService_Init() {
        try {
            //校验是否是第一次注册
            if (client == null && options == null) {
                log.info("host:" + config.getHost() + ",topic:" + feedback_topic);
                //host为主机名，test为clientid即连接MQTT的客户端ID，一般以客户端唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
                MemoryPersistence persistence = new MemoryPersistence();
                client = new MqttClient(config.getHost(), "iot-server" + System.currentTimeMillis(), persistence);
                //MQTT的连接设置
                options = new MqttConnectOptions();
                //设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
                options.setCleanSession(true);
                //断线自动重连
                options.setAutomaticReconnect(true);
                options.setKeepAliveInterval(60);
                options.setConnectionTimeout(30);
                //一次能发不消息的数量
                options.setMaxInflight(config.getMaxInflight());
            }else {
                return new Response(ResponseStatus.FAIL,"400","请检查是否已注册/emq是否已关闭");
            }
            //链接校验
            if (!client.isConnected()) {
                client.connect(options);
            }
            //设置回调
            client.setCallback(new MqttCallbackExtended() {

                @Override
                public void connectComplete(boolean reconnect, String url) {
                    //连接完成确认
                    if (reconnect) {
                        log.info("Reconnect to " + url + " complete!");
                        dosScribe();
                    }
                }


                @Override
                public void connectionLost(Throwable cause) {
                    //连接丢失后，一般在这里面进行重连
                    log.error("Connection lost,reconnecting......");
                }

                @Override
                public void messageArrived(String topicName, MqttMessage msg) throws Exception {
                    if( msg != null){
                        if (log.isDebugEnabled()){
                            log.debug("receive,{}.{}", topicName, msg);
                        }
                        MqttResponse mqttResponse = gson.fromJson(msg.toString(), MqttResponse.class);
                        if(mqttResponse != null){
                            msgPushDao.updateMsgStatus(mqttResponse.getMessageId(),mqttResponse.getPatientId(),mqttResponse.getVisitId(),1);
                            if (!StringUtils.isEmpty(mqttResponse.getOriginId()) && !StringUtils.isEmpty(mqttResponse.getWardNo())) {
                                QuickMsgPushResult result = msgPushDao.queryRecievedResult(mqttResponse.getOriginId());
                                if (null != result && result.isAllReceived()) {
                                    PushResultMessageData pushResultMessageData = PushResultMessageData.builder()
                                            .originId(mqttResponse.getOriginId())
                                            .total(result.getTotal())
                                            .received(result.getReceived())
                                            .build();
                                    String mac = msgPushDao.queryNurseMac(mqttResponse.getWardNo());
                                    PushMessage pushMessage = PushResultMessage.builder()
                                            .message(pushResultMessageData)
                                            .macAddress(mac)
                                            .wardNo(mqttResponse.getWardNo())
                                            .build();
                                    pushService.pushByMac(pushMessage);
                                }
                            }
                        }
                    }
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    //publish后会执行到这里
                }
            });
            dosScribe();
        } catch (Exception e) {
            //如果注册失败
            client = null;
            options =null;
            log.error("init error", e);
            return new Response(ResponseStatus.FAIL,"400","无法连接至服务器");
        }
        return new Response(ResponseStatus.SUCCESS,"200","注册成功");
    }

    private void dosScribe() {
        if (client.isConnected()) {
            try {
                client.subscribe(feedback_topic, QoS);
            } catch (Exception e) {
                log.error("error", e);
            }
        }
    }


    public void doPush(String dest,String payload){
        if(client != null && dest != null) {
            try {
                MqttMessage message = new MqttMessage(payload.getBytes("utf-8"));
                message.setQos(QoS);
                client.publish(dest, message);
            } catch (Exception e) {
                log.error("error", e);
            }
        }
    }
}
