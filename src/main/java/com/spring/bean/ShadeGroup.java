package com.spring.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * Created by lenovo on 2017/4/22.
 */
@ApiModel(value = "group")
public class ShadeGroup implements Serializable{

    @ApiModelProperty(value = "groupId")
    private Integer id;

    @ApiModelProperty(value = "groupId")
    private Integer groupId;

    @ApiModelProperty(value = "deviceId")
    private Integer deviceId;

    @ApiModelProperty(value = "groupName")
    private String groupName;

    public ShadeGroup() {
    }

    public ShadeGroup(Integer id, Integer groupId, Integer deviceId, String groupName) {
        this.id = id;
        this.groupId = groupId;
        this.deviceId = deviceId;
        this.groupName = groupName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
