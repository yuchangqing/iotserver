package com.kyee.iot.common.domain.response;

import lombok.Data;

/**
 * 作者：郑益豪
 * 描述：与平板交互时的基本JSONBean
 */
@Data
public class RuleResult {
    /**
     * 请求响应情况
     */
    private String statusCode;

    /**
     * 错误消息描述
     */
    private String errorInfo;

    /**
     * 请求内容
     */
    private Object message;

    /**
     * 成功操作
     */
    public void succuss(){
        setStatusCode("200");
        setErrorInfo("");
    }

    /**
     * 错误400
     * @param obj
     */
    public void fail400(Object obj){
        setStatusCode("400");
        setErrorInfo("用户请求的格式不可得");
        setMessage(obj);
    }

    public void fail400(){
        setStatusCode("400");
        setErrorInfo("用户请求的格式不可得");
    }

    /**
     * 错误404
     * @param obj
     */
    public void fail404(Object obj){
        setStatusCode("404");
        setErrorInfo("无相关记录");
        setMessage(obj);
    }

    public void fail404(){
        setStatusCode("404");
        setErrorInfo("无相关记录");
    }

    /**
     * 错误500
     * @param obj
     */
    public void fail500(Object obj){
        setStatusCode("500");
        setErrorInfo("请求异常");
        setMessage(obj);
    }

    public void fail500(){
        setStatusCode("500");
        setErrorInfo("请求异常");
    }


    public void fail403(){
        setStatusCode("403");
        setErrorInfo("问卷未发布");
    }

}
