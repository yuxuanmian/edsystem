package com.xhu.security;

import com.alibaba.fastjson.JSON;
import com.xhu.constant.ParameterConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class LoginFileter extends UsernamePasswordAuthenticationFilter {

    public static final String KAPTCHA_KEY = "kaptcha";

    private String kapchakeyParameter=KAPTCHA_KEY;

    public void setKapchakeyParameter(String kapchakeyParameter) {
        this.kapchakeyParameter = kapchakeyParameter;
    }

    public String getKapchakeyParameter() {
        return kapchakeyParameter;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {



        if (!"POST".equalsIgnoreCase(request.getMethod())) {
            throw new AuthenticationServiceException("方法不支持:" + request.getMethod());
        }
        //判断是否为json请求
        String contentType = request.getContentType();

        if ("application/json;charset=utf-8".equalsIgnoreCase(contentType)
                || MediaType.APPLICATION_JSON_VALUE.equalsIgnoreCase(contentType)) {

            try {
                Map<String, String> map = JSON.parseObject(request.getInputStream(), Map.class);
                //获取参数
                String username = map.get(super.getUsernameParameter());
                String password = map.get(super.getPasswordParameter());
                String verifycode = map.get(this.getKapchakeyParameter());

                //先判断验证码
                Object sessionCaptcha = request.getSession().getAttribute(ParameterConstant.VERIFY_CODE.value());
                if (ObjectUtils.isEmpty(sessionCaptcha)) {
                    throw new AuthenticationServiceException("非法登录");
                }
                if (!StringUtils.equalsIgnoreCase(verifycode, sessionCaptcha.toString().trim())) {
                    throw new AuthenticationServiceException("验证码错误");
                }

                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
                setDetails(request, token);
                return this.getAuthenticationManager().authenticate(token);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return super.attemptAuthentication(request, response);

    }


}

