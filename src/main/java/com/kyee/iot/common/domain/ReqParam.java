package com.kyee.iot.common.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/16.
 */
@Data
@Builder
public class ReqParam implements Serializable{
    private int page_size;
    private int curr_page;
}
