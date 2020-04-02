package com.csye6225.spring2020.courseservice.utils;

public class ResponseWrapper<T> {
    private int code;
    private String msg;
    private T body;

    private ResponseWrapper(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private ResponseWrapper(T body){
        this.code = 0;
        this.body = body;
        this.msg = "OK";
    }

    public static <T> ResponseWrapper<T> ofSuc(T responseBody) {
        return new ResponseWrapper<>(responseBody);
    }

    public static <T> ResponseWrapper<T> ofSuc() {
        return new ResponseWrapper<>(null);
    }

    public static <T> ResponseWrapper<T> ofErr(int code, String msg) {
        return new ResponseWrapper<>(code, msg);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", body=" + body +
                '}';
    }
}
