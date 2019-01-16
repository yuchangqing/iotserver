package com.kyee.iot.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/16.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Topic implements Serializable {
    private String topic;
    private String count;
}
