package com.kyee.iot.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 周乐乐
 * 创建时间：2016-09-14 9:32
 * 创建原因：参数无效异常
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidParamException extends RuntimeException {
    public InvalidParamException(String msg) {
        super(msg);
    }
}