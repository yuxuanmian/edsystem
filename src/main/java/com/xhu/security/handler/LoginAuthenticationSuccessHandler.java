package com.xhu.security.handler;

import com.xhu.constant.AuthenticationCode;
import com.xhu.utils.ResultVoUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        String json = ResultVoUtil.returnWithoutAttahment(AuthenticationCode.LOGIN_SUCCESS.code(), "登录成功");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.OK.value());
        response.getWriter().println(json);

    }
}
