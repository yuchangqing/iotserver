package com.kyee.iot.common.emqMessage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * 推送服务需要的设备相关字段
 *
 * @author zhanghao
 * @version 4.0（2017年3月8日13:26:50）
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceInfo {
    private String wardNo;
    private String devNo;
    private String devType;
    private String macAddress;
    private String wardName;

    public boolean hasEmptyData(){
        return StringUtils.isEmpty(wardNo) ||
                StringUtils.isEmpty(devNo) ||
                StringUtils.isEmpty(devType) ||
                StringUtils.isEmpty(macAddress) ||
                StringUtils.isEmpty(wardName);
    }
}
