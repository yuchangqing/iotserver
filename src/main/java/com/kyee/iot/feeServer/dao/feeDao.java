package com.kyee.iot.feeServer.dao;

import com.kyee.iot.feeServer.domain.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface feeDao {
    List<feeDomain> fee(@Param("patId")String patId);
    feeAllCostDomain allCostFee(@Param("patId")String patId);
    List<feeDateDomain> dateFee(@Param("patId")String patId, @Param("dateTime")String dateTime);
    List<feeTypeDomain> typeFee(@Param("patId")String patId,@Param("dateTime")String dateTime);
    List<feeDetailedDomain> detailedFee(@Param("patId")String patId,@Param("dateTime")String dateTime);
}
