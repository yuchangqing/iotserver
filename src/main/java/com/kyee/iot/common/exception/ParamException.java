package com.kyee.iot.common.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 周乐乐
 * 创建时间：2016-9-13 12:02
 * 创建说明：参数错误异常
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ParamException extends RuntimeException {
    public ParamException(String message) {
        super(message);
    }
}