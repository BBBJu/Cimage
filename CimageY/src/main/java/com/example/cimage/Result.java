package com.example.cimage;

public class Result<T> {
    public String msg;
    public T data;
    public Result(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }
    public static <T> Result success(T data) {
        Result r = new Result("success!",data);
        return r;
    }
    public static <T> Result failed() {
        Result r = new Result("failed!",null);
        return r;
    }
}
