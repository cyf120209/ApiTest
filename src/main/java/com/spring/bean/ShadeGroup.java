package com.spring.bean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


/**
 * Created by lenovo on 2017/4/22.
 */
@ApiModel(value = "group")
public class ShadeGroup {

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
