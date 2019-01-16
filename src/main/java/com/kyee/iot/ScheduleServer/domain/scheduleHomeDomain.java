package com.kyee.iot.ScheduleServer.domain;

import lombok.Data;

import java.util.List;

@Data
public class scheduleHomeDomain {
    public String time;
    public List<scheduleTypeDomain> typeDomains;
}
