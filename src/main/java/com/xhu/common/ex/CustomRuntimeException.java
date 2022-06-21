package com.xhu.common.ex;

public class CustomRuntimeException extends RuntimeException{

    private int code;

    public CustomRuntimeException(String message,int code) {
        super(message);
        this.code=code;
    }

    public int getCode() {
        return code;
    }
}
