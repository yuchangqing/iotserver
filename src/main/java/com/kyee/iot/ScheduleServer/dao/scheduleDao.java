package com.kyee.iot.ScheduleServer.dao;


import com.kyee.iot.ScheduleServer.domain.scheduleHomeDomain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface scheduleDao {
    List<scheduleHomeDomain> scheduleHome(@Param("patId")String patId, @Param("dateTime")String dateTime);
    scheduleHomeDomain scheduleDetailed(@Param("patId")String patId, @Param("dateTime")String dateTime);
}
