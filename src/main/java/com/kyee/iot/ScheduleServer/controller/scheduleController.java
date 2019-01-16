package com.kyee.iot.ScheduleServer.controller;

import com.kyee.iot.ScheduleServer.domain.scheduleHomeDomain;
import com.kyee.iot.ScheduleServer.service.IscheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class scheduleController {
    @Autowired
    private IscheduleService ischeduleService;
    @RequestMapping(value = "/schedule/scheduleHomePage",method = RequestMethod.GET)
    public List<scheduleHomeDomain> scheduleHome(@RequestParam String patId,@RequestParam String dateTimeForM)
    {
        return ischeduleService.scheduleHome(patId,dateTimeForM);
    }
    @RequestMapping(value = "/schedule/scheduleDetailedPage",method = RequestMethod.GET)
    public scheduleHomeDomain scheduleDetailed(@RequestParam String patId,@RequestParam String dateTimeForD)
    {
        return ischeduleService.scheduleDetailed(patId,dateTimeForD);
    }
}
