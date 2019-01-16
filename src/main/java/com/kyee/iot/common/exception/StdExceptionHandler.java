package com.kyee.iot.common.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 */
@Slf4j
@Configuration
public class StdExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        MappingJackson2JsonView v = new MappingJackson2JsonView();
        HashMap<String, Object> attributes = new HashMap<>(8);

        if (ex instanceof IOTException) {
            IOTException exception = (IOTException) ex;
            String businessCode = exception.getBusinessCode();
            if (businessCode != null) {
                attributes.put("businessCode", businessCode);
            }
            if (null != exception.getSystemCode()) {
                attributes.put("responseCode", exception.getSystemCode());
            } else {
                attributes.put("responseCode", SystemCode.NOT_FOUND.getValue());
            }
            attributes.put("message", ex.getMessage());
            attributes.put("status", "ERROR");
            mv.setView(v);
        } else {
            attributes.put("message", ex.getMessage());
            attributes.put("status", "ERROR");
            attributes.put("code", ex.getClass().getSimpleName());
        }

        log.error("URL: {} {}?{} ", request.getMethod(), request.getRequestURL(), request.getQueryString(), ex);
        v.setAttributesMap(attributes);
        mv.setView(v);
        return mv;
    }
}