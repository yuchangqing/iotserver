package com.kyee.iot.ScheduleServer.service;

import com.kyee.iot.ScheduleServer.dao.*;
import com.kyee.iot.ScheduleServer.domain.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class scheduleService implements IscheduleService{
    @Autowired
   public scheduleDao scheduleDao;
    //获取日程主页第二拦信息
   public List<scheduleHomeDomain> scheduleHome(String patId, String dateTime)
   {
      return scheduleDao.scheduleHome(patId,dateTime);
   }
   //获取当天日程详细信息
   public scheduleHomeDomain scheduleDetailed(String patId,String dateTime)
   {
       return scheduleDao.scheduleDetailed(patId,dateTime);
   }
}
