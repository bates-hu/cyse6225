package com.csye6225.spring2020.courseservice.utils;

public class ServiceException extends Exception{
    private int code;

    public ServiceException(int code, String msg) {
        super(msg);
        this.code = code;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
