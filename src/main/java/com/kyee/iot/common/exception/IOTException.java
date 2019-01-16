package com.kyee.iot.common.exception;

import lombok.Builder;
import lombok.Data;

/**
 */
@Data
@Builder
public class IOTException extends RuntimeException {

    /**异常code*/
    private String message;
    private String businessCode;
    private String systemCode;
    private Throwable cause;

    public IOTException(String message){
        this.message = message;
    }

    public IOTException(String message, String businessCode, String systemCode){
        this.message = message;
        this.businessCode = businessCode;
        this.systemCode = systemCode;
    }

    public IOTException(String message, String businessCode, String systemCode, Throwable cause) {
        this.message = message;
        this.businessCode = businessCode;
        this.systemCode = systemCode;
        this.cause = cause;
    }

    public IOTException(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
    }
}