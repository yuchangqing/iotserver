package com.kyee.iot.common.domain;

import lombok.Data;

@Data
public abstract class AbstractBed {

    /**
     * 床号
     */
    protected String bedNo;
    /**
     * 床位手动排序
     * */
    protected Integer bedOrder;

}
