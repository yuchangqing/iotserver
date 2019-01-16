package com.kyee.iot.feeServer.service;

import com.kyee.iot.feeServer.domain.feeDomain;
import com.kyee.iot.feeServer.domain.feeHomeDomain;
import com.kyee.iot.feeServer.domain.feeDetailedDomain;

import java.util.List;

public interface IfeeServer {
    List<feeDomain> selectfee(String id);
    feeHomeDomain selectHomefee2(String patId, String dateTime);
    List<feeDetailedDomain> selectDetailedFee(String patId,String dateTime);
}
