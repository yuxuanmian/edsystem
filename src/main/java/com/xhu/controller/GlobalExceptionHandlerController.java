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
    public String normalExceptionHandler(CustomRuntimeException e){
        return ResultVoUtil.returnWithoutAttahment(e.getCode(), e.getMessage());
    }

}
