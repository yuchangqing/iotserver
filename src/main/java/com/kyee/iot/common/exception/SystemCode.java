package com.kyee.iot.common.exception;

/**
 * Created by Joez on 2017/3/13.
 */
public enum SystemCode {

    OK("200"), CREATED("201"), NO_CONTENT("204"), BAD_REQUEST("400"), NOT_FOUND("404"), SERVE_ERROR("500");
     private String value;
     SystemCode(String code){
       this.value = code;
     }
     public String getValue(){
      return this.value;
    }

}
