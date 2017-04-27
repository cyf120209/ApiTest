package com.spring.bean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/4/20.
 */
@ApiModel(value = "shade" ,description = "shade")
public class Shade implements Serializable{

    @ApiModelProperty(value = "shadId",required = true)
    private Integer id;

    @ApiModelProperty(value = "shadeName")
    private String name;

    @ApiModelProperty(value = "shadePosition")
    private Integer position;

    @ApiModelProperty(value = "shadePriority")
    private Integer priority;

    @ApiModelProperty(value = "shadeStatus")
    private String status;

    public Shade() {
    }

    public Shade(Integer id) {
        this.id = id;
    }

    public Shade(Integer id, String name, Integer position, Integer priority, String status) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.priority = priority;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Build{
        private Integer id;

        private String name;

        private Integer position;

        private Integer priority;

        private String status;

        public Build(){

        }

        public Integer getId() {
            return id;
        }

        public Build setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public Build setName(String name) {
            this.name = name;
            return this;
        }

        public Integer getPosition() {
            return position;
        }

        public Build setPosition(Integer position) {
            this.position = position;
            return this;
        }

        public Integer getPriority() {
            return priority;
        }

        public Build setPriority(Integer priority) {
            this.priority = priority;
            return this;
        }

        public String getStatus() {
            return status;
        }

        public Build setStatus(String status) {
            this.status = status;
            return this;
        }

        public Shade create(){
            return new Shade(id,name,position,priority,status);
        }
    }
}
