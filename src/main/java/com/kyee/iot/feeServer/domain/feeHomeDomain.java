package com.kyee.iot.feeServer.domain;

import lombok.Data;

import java.util.List;

@Data
public class feeHomeDomain {
    //预存款
   public String patTotalPrepaid;
    //应交费用用
   public String patTotalFee;
    //日期费用
    public List<feeDateDomain> feeDataDomainList;
    //类型费用
    public List<feeTypeDomain> feeTypeDomainList;

}
