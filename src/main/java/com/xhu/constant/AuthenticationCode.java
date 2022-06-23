package com.xhu.constant;

/**
 * 认证相关枚举常量
 */
public enum AuthenticationCode {

    /**
     * 登录成功状态码
     */
    LOGIN_SUCCESS(200),

    /**
     * 登录失败状态码
     */
    LOGIN_FAIL(1000),

    /**
     * 未认证状态码
     */
    UNAUTHORIZED(-1),

    /**
     * logout成功
     */
    LOG_OUT(200);


    private final int value;

    AuthenticationCode(int value) {
        this.value = value;
    }

    public int code(){
        return value;
    }


}
