package com.xhu.security.handler;

import com.xhu.constant.AuthenticationCode;
import com.xhu.constant.ParameterConstant;
import com.xhu.security.pojo.AuthUser;
import com.xhu.utils.JWTUtil;
import com.xhu.utils.ResultVoUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {


        AuthUser details = (AuthUser) authentication.getPrincipal();
        //将id存入session
        request.getSession().setAttribute(ParameterConstant.ID.value(), details.getUsername());
        //设置token
        String id = details.getUsername();
        Map<String, String> map = new HashMap<>();
        map.put("token", getToken(id));
        map.put("id", id);
        //返回前端
        String json = ResultVoUtil.returnWithAttachment(AuthenticationCode.LOGIN_SUCCESS.code(), "登录成功", map);
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.OK.value());
        response.getWriter().println(json);

    }

    private String getToken(String id) {
        Map<String, String> map = new HashMap<>();
        map.put(ParameterConstant.ID.value(), id);
        return JWTUtil.createToken(map);
    }
}
