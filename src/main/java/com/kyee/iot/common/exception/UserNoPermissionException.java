package com.kyee.iot.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 周乐乐
 * 创建时间: 2016-09-14 12:47
 * 创建原因: 请求参数与用户实际信息不符异常
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNoPermissionException extends RuntimeException {
    public UserNoPermissionException(String message) {
        super(message);
    }
}
