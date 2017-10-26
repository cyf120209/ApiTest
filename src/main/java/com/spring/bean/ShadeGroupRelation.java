package com.spring.bean;


/**
 * Created by lenovo on 2017/5/20.
 */
public class ShadeGroupRelation {

    private Integer id;

    private Integer shadeGroupId;

    private Integer shadeId;

    public ShadeGroupRelation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShadeGroupId() {
        return shadeGroupId;
    }

    public void setShadeGroupId(Integer shadeGroupId) {
        this.shadeGroupId = shadeGroupId;
    }

    public Integer getShadeId() {
        return shadeId;
    }

    public void setShadeId(Integer shadeId) {
        this.shadeId = shadeId;
    }
}
