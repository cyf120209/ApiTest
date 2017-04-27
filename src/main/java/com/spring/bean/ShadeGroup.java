package com.spring.bean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by lenovo on 2017/4/22.
 */
@ApiModel(value = "group")
public class ShadeGroup {

    @ApiModelProperty(value = "groupId")
    private Integer groupId;

    @ApiModelProperty(value = "groupName")
    private String groudName;

    public ShadeGroup() {
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroudName() {
        return groudName;
    }

    public void setGroudName(String groudName) {
        this.groudName = groudName;
    }
}
