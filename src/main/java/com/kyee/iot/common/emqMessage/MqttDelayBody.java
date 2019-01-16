package com.kyee.iot.common.emqMessage;


import com.kyee.iot.common.service.PushServiceWorker;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 消息主题，并进行延时消息推送。2017年5月9日10:42:20
 */
@Component
@Data
@Slf4j
@NoArgsConstructor
public class MqttDelayBody  implements Delayed,Runnable{

//    @Autowired
    PushServiceWorker pushServiceWorker;

    private String mac;
    private String body;
    private  long endTime;
    private static AtomicLong count = new AtomicLong();

    public MqttDelayBody(String mac,String body,PushServiceWorker pushServiceWorker){
        this.mac = mac;
        this.body = body;
        this.pushServiceWorker = pushServiceWorker;
        endTime =  TimeUnit.MILLISECONDS.convert(count.incrementAndGet()*100, TimeUnit.MILLISECONDS) + System.currentTimeMillis();
    }

    // 延时时间 , 1秒以后开始。
    @Override
    public long getDelay(TimeUnit unit) {
        synchronized (pushServiceWorker) {
            return unit.convert(endTime - System.currentTimeMillis(), unit.MILLISECONDS);
        }
    }

    //排序
    @Override
    public int compareTo(Delayed o) {
        MqttDelayBody that = (MqttDelayBody) o;
        return endTime > that.endTime?1:(endTime < that.endTime ? -1 : 0);
    }

    @Override
    public void run() {
        count.decrementAndGet();
        pushServiceWorker.doPush(mac,body);
        if (log.isDebugEnabled()) {
            log.debug(mac + "----:" + count.get() + "----:" + body);
        }
    }
}
