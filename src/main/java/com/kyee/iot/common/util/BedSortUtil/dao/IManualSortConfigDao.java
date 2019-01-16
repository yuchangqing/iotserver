package com.kyee.iot.common.util.BedSortUtil.dao;

import com.kyee.iot.common.util.BedSortUtil.ManualSortConfig;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IManualSortConfigDao {
    @ResultType(ManualSortConfig.class)
    @Select("SELECT wardNo, sortMode FROM `ward_info`;")
    List<ManualSortConfig> queryConfigs();

    @Select("SELECT bedOrder FROM `bed_info` WHERE wardNo = #{wardNo} AND bedNo = #{bedNo} LIMIT 1;")
    Integer queryManualOrder(@Param("wardNo") String wardNo, @Param("bedNo") String bedNo);
}
