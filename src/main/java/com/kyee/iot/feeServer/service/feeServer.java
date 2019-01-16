package com.kyee.iot.feeServer.service;

import com.kyee.iot.feeServer.dao.feeDao;
import com.kyee.iot.feeServer.domain.*;
import com.kyee.iot.common.service.*;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class feeServer implements IfeeServer{
    @Autowired
    private feeDao ifeeDao;
    @Autowired
    private PushService pushService;
    public List<feeDomain> selectfee(String id)
    {
        return ifeeDao.fee(id);
    }

    public feeHomeDomain selectHomefee2(String patId,String dateTime)
    {
        feeHomeDomain feeHomeDomains = new feeHomeDomain();
        feeAllCostDomain feeAllCostDomains = ifeeDao.allCostFee(patId);
        feeHomeDomains.setPatTotalFee(feeAllCostDomains.getPatTotalFee());
        feeHomeDomains.setPatTotalPrepaid(feeAllCostDomains.getPatTotalPrepaid());
        feeHomeDomains.setFeeDataDomainList(ifeeDao.dateFee(patId,dateTime));
        feeHomeDomains.setFeeTypeDomainList(ifeeDao.typeFee(patId,dateTime));
        return feeHomeDomains;
    }

    public List<feeDetailedDomain> selectDetailedFee(String patId,String dateTime)
    {
       // pushService.pushByTopic("/World","看看地方！！！！");
        return ifeeDao.detailedFee(patId,dateTime);
    }
}
