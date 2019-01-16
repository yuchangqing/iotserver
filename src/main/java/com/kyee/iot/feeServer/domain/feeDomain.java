package com.kyee.iot.feeServer.domain;

import lombok.Data;

@Data
public class feeDomain {
    public String patId;
    public String visited;
    public String itemId;
    public String itemClass;
    public String itemName;
    public String itemSpec;
    public String itemAmount;
    public String itemCost;
}