package com.kyee.iot.feeServer.domain;

import lombok.Data;

@Data
public class feeAllCostDomain {
    //预存款
   public String patTotalPrepaid;
    //应交费用用
   public String patTotalFee;
}
