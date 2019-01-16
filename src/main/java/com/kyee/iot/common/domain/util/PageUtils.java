package com.kyee.iot.common.domain.util;

import java.util.List;

/**
 * @author 王恒洋
 * 创建时间: 2017-02-21 11:12
 * 任务号：IOTBEDSIDE-1553
 * 创建原因: 分页结果
 */
public class PageUtils<T> {

    /**
     * 记录总数
     */
    private long sumCount;

    /**
     * 结果集合
     */
    private List<T> entities;

    public long getSumCount() {
        return sumCount;
    }

    public void setSumCount(long sumCount) {
        this.sumCount = sumCount;
    }

    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }
}
