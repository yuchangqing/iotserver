package com.kyee.iot.feeServer.domain;

import lombok.Data;

@Data
public class feeDetailedListDomain {
    public String itemName;
    public String itemAmount;
    public String itemUnits;
    public String itemCost;
}
