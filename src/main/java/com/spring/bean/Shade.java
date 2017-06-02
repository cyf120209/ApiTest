package com.spring.bean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lenovo on 2017/4/20.
 */
@Entity(name = "shade")
@ApiModel(value = "shade" ,description = "shade")
public class Shade implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "shadeId")
    @ApiModelProperty(value = "shadeId",required = true)
    private Integer shadeId;

    @Column(name = "shadeName",length = 50)
    @ApiModelProperty(value = "shadeName")
    private String shadeName;

    @Column(name = "shadePosition")
    @ApiModelProperty(value = "shadePosition")
    private Integer shadePosition;

    @Column(name = "shadePriority")
    @ApiModelProperty(value = "shadePriority")
    private Integer shadePriority;

    @Column(name = "shadeStatus",length = 50)
    @ApiModelProperty(value = "shadeStatus")
    private String shadeStatus;

    public Shade() {
    }

    public Shade(Integer id) {
        this.id = id;
    }

    public Shade(Integer shadeId, String name, Integer position, Integer priority, String status) {
        this.shadeId = shadeId;
        this.shadeName = name;
        this.shadePosition = position;
        this.shadePriority = priority;
        this.shadeStatus = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getShadeId() {
        return shadeId;
    }

    public void setShadeId(Integer shadeId) {
        this.shadeId = shadeId;
    }

    public String getShadeName() {
        return shadeName;
    }

    public void setShadeName(String shadeName) {
        this.shadeName = shadeName;
    }

    public Integer getShadePosition() {
        return shadePosition;
    }

    public void setShadePosition(Integer shadePosition) {
        this.shadePosition = shadePosition;
    }

    public Integer getShadePriority() {
        return shadePriority;
    }

    public void setShadePriority(Integer shadePriority) {
        this.shadePriority = shadePriority;
    }

    public String getShadeStatus() {
        return shadeStatus;
    }

    public void setShadeStatus(String shadeStatus) {
        this.shadeStatus = shadeStatus;
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
