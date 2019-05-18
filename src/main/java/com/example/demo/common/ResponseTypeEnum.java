package com.example.demo.common;

public enum ResponseTypeEnum {

    SUCCESS("0000","SUCCESS"),
    FAILED("9999","FAILED"),
    ;
    private String code;
    private String message;

    ResponseTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
