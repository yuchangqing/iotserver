package com.kyee.iot.feeServer.controller;

import com.kyee.iot.feeServer.domain.feeHomeDomain;
import com.kyee.iot.feeServer.service.IfeeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kyee.iot.feeServer.domain.feeDomain;
import com.kyee.iot.feeServer.domain.feeDetailedDomain;

import java.util.List;

@RestController
public class feeController {
    @Autowired
    private IfeeServer ifeeServer;

    @RequestMapping(value = "/fee/selectFeeServer",method = RequestMethod.GET)
    public List<feeDomain> selectFee(@RequestParam String id)
    {
        return ifeeServer.selectfee(id);
    }
    @RequestMapping(value = "/fee/feeHome",method = RequestMethod.GET)
    public feeHomeDomain selectFee2(@RequestParam String patId, @RequestParam String dateTimeForM)
    {
        return ifeeServer.selectHomefee2(patId,dateTimeForM);
    }
    @RequestMapping(value = "/fee/feeDetailedFee",method = RequestMethod.GET)
    public List<feeDetailedDomain> selectDetailedFee(@RequestParam String patId, @RequestParam String dateTimeForD)
    {
        return ifeeServer.selectDetailedFee(patId,dateTimeForD);
    }

}
