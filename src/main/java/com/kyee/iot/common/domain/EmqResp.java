package com.kyee.iot.common.domain;

import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2017/5/16.
 */
@Data
public class EmqResp<T> {
        private int currentPage;
        private int pageSize;
        private int totalNum;
        private int totalPage;
        private List<T> result;
}
