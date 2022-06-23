package com.xhu.config.interceptor;

import com.xhu.common.ex.CustomRuntimeException;
import com.xhu.constant.ParameterConstant;
import com.xhu.constant.ResultConstant;
import com.xhu.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String header = request.getHeader(ParameterConstant.TOKEN_FROM_HEADER_PARAM.value());
        if (ObjectUtils.isEmpty(handler)) {
            throw new CustomRuntimeException("token验证失败", ResultConstant.FAILED);
        }
        try {
            JWTUtil.verifyJWT(header);
        }catch (RuntimeException e){
            log.error(e.getMessage());
            throw new CustomRuntimeException("token验证失败", ResultConstant.FAILED);
        }
        return true;
    }
}
