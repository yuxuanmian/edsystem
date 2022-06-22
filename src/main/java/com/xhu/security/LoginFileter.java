package com.xhu.security;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class LoginFileter extends UsernamePasswordAuthenticationFilter {

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
                String username = map.get(super.getUsernameParameter());
                String password = map.get(super.getPasswordParameter());
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

