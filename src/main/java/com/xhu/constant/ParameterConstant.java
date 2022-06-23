package com.xhu.constant;

/**
 * 参数常量类
 * @author yxm
 */
public enum ParameterConstant {
    TOKEN("token"),

    VERIFY_CODE("verify_code"),

    ID("id"),

    /**
     * header中的token参数
     */
    TOKEN_FROM_HEADER_PARAM("x-token");

    private final String value;

    ParameterConstant(String value) {
        this.value=value;
    }

    public String value(){
        return this.value;
    }

}

