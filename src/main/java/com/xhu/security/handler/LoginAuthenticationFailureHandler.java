package com.xhu.security.handler;

import com.xhu.constant.AuthenticationCode;
import com.xhu.utils.ResultVoUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        String json = ResultVoUtil.returnWithoutAttahment(AuthenticationCode.LOGIN_FAIL.code(), "登录失败");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.OK.value());
        response.getWriter().println(json);

    }
}
