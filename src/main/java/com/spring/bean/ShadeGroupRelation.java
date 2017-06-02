package com.spring.bean;

import javax.persistence.*;

/**
 * Created by lenovo on 2017/5/20.
 */
@Entity(name = "shadeGroupRelation")
public class ShadeGroupRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "shadeGroupId")
    private Integer shadeGroupId;

    @Column(name = "shadeId")
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
