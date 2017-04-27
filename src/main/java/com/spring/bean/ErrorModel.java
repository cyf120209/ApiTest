package com.spring.bean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by lenovo on 2017/4/22.
 */
@ApiModel(value = "errorModel")
public class ErrorModel {

    @ApiModelProperty(value = "code")
    private Integer code;

    @ApiModelProperty(value = "message")
    private String message;

    public ErrorModel() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
