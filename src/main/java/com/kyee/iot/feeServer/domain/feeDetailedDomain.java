package com.kyee.iot.feeServer.domain;

import lombok.Data;

import java.util.List;
@Data
public class feeDetailedDomain {
    public String type;
    public String typeFee;
    public List<feeDetailedListDomain> feeDetailedListDomains;
}
