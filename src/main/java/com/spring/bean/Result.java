package com.spring.bean;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/4/20.
 */
public class Result<T> implements Serializable {

    @ApiModelProperty(value = "error code",required = true)
    private Integer code=200;

    @ApiModelProperty(value = "data",required = true)
    private T data;

    @ApiModelProperty(value = "prompt")
    private String msg;

    public Result() {
        super();
    }

    public Result(Integer code, T data) {
        super();
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
