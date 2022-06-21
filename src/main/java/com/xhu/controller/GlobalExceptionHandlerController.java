package com.xhu.controller;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author yxm
 */
@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(RuntimeException.class)
    public String dothis(RuntimeException e){
        return null;
    }

}
