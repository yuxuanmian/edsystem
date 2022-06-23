package com.xhu.constant;

/**
 * session常量类
 * @author yxm
 */
public enum  SessionConstant {
    TOKEN("token"),

    VERIFY_CODE("verify_code");

    private String value;

    SessionConstant(String value) {
        this.value=value;
    }

    public String value(){
        return this.value;
    }

}

