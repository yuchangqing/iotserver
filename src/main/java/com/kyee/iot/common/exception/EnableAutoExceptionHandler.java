package com.kyee.iot.common.exception;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({StdExceptionHandler.class})
public @interface EnableAutoExceptionHandler {
}
