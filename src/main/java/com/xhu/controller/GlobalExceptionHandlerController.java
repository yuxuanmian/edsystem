package com.xhu.controller;


import com.xhu.common.ex.CustomRuntimeException;
import com.xhu.utils.ResultVoUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author yxm
 */
@RestControllerAdvice
public class GlobalExceptionHandlerController {
    @ExceptionHandler({CustomRuntimeException.class})
    public String normalExceptionHandler(Exception e){
        return ResultVoUtil.returnWithoutAttahment(500, e.getMessage());
    }

}
