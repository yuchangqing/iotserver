package com.kyee.iot.ScheduleServer.service;

import com.kyee.iot.ScheduleServer.domain.scheduleHomeDomain;

import java.util.List;

public interface IscheduleService {
    List<scheduleHomeDomain> scheduleHome(String patId,String dateTime);
    scheduleHomeDomain scheduleDetailed(String patId,String dateTime);
}
