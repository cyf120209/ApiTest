package com.spring.bean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * Created by lenovo on 2017/4/22.
 */
@Entity(name = "shadegroup")
@ApiModel(value = "group")
public class ShadeGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ApiModelProperty(value = "groupId")
    private Integer id;

    @Column(name = "groupId")
    @ApiModelProperty(value = "groupId")
    private Integer groupId;

    @Column(name = "deviceId")
    @ApiModelProperty(value = "deviceId")
    private Integer deviceId;

    @Column(name = "groupName",length = 50)
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
