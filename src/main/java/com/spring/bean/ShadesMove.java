package com.spring.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lenovo on 2017/4/20.
 */
@ApiModel(value = "shadesMove",description = "shadesMove")
public class ShadesMove{

    @ApiModelProperty(value = "shadesId",required = true)
    private Integer id;

    @ApiModelProperty(value = "groupId")
    private Integer groupId;

    @ApiModelProperty(value = "absolute position")
    private Integer position;

    @ApiModelProperty(value = "percent")
    private Integer percentage;

    @ApiModelProperty(value = "shades command",required = true)
    private Integer command;

    @ApiModelProperty(value = "priority")
    private Integer priority;

    public ShadesMove() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
