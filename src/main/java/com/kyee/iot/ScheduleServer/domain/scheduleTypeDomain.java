package com.kyee.iot.ScheduleServer.domain;

import lombok.Data;

@Data
public class scheduleTypeDomain {
    public String orderClass;
    public String startTime;
    public String endTime;
    public String orderText;
}
