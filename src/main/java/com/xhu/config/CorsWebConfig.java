package com.xhu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 解决跨域问题的配置类
 * @author yxm
 */
@Configuration
public class CorsWebConfig {

    @Bean
    public CorsFilter corsWebFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration cors = new CorsConfiguration();
        //允许验证信息跨域
        cors.setAllowCredentials(true);
        //允许哪些请求跨域
        cors.addAllowedOriginPattern("*");
        //允许哪些头信息跨域
        cors.addAllowedHeader("*");
        //允许哪些方法跨域
        cors.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", cors);

        return new CorsFilter(source);
    }

}
