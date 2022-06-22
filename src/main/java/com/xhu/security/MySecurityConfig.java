package com.xhu.security;

import com.xhu.constant.AuthenticationCode;
import com.xhu.security.handler.LoginAuthenticationFailureHandler;
import com.xhu.security.handler.LoginAuthenticationSuccessHandler;
import com.xhu.security.handler.MyPasswordEncoder;
import com.xhu.utils.ResultVoUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //放行验证码接口
        http.authorizeRequests().mvcMatchers("/vc.jpg").permitAll()
                //其余的url进行认证
                .anyRequest().authenticated()
                //表单登录（已重写）
                .and().formLogin()
                .and()
                //处理异常
                .exceptionHandling()
                //没有认证被拦截
                .authenticationEntryPoint((request, response, authException) -> {
                    String res = ResultVoUtil.returnWithoutAttahment(AuthenticationCode.UNAUTHORIZED.code(), "用户未登录");
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.setContentType("application/json;charset=utf-8");
                    response.getWriter().println(res);
                })
                .and()
                //登出
                .logout().logoutUrl("/logout")
                //登出成功处理器
                .logoutSuccessHandler((request, response, authentication) -> {
                    String res = ResultVoUtil.returnWithoutAttahment(AuthenticationCode.LOG_OUT.code(), "登出成功");
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.setContentType("application/json;charset=utf-8");
                    response.getWriter().println(res);
                })
                //关闭csrf
                .and().csrf().disable();
        //重写过滤器，并将原生PasswordAuthenticationFilter进行替换
        http.addFilterAt(loginFileter(), UsernamePasswordAuthenticationFilter.class);

    }


    @Bean
    public MyUserDetailService userDetailService() {
        return new MyUserDetailService();
    }

    /**
     * 暴露bean
     */
    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    /**
     * 暴露bean
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public LoginFileter loginFileter() throws Exception {
        LoginFileter loginFileter = new LoginFileter();
        //设置参数名
        loginFileter.setPasswordParameter("password");
        loginFileter.setUsernameParameter("username");
        //设置处理url
        loginFileter.setFilterProcessesUrl("/doLogin");
        //设置authenticationManager
        loginFileter.setAuthenticationManager(this.authenticationManagerBean());
        //设置成功、失败的处理器
        loginFileter.setAuthenticationSuccessHandler(new LoginAuthenticationSuccessHandler());
        loginFileter.setAuthenticationFailureHandler(new LoginAuthenticationFailureHandler());
        return loginFileter;
    }

    /**
     * 重写以从数据库中获得数据源
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService())
                .passwordEncoder(new MyPasswordEncoder());
    }


}