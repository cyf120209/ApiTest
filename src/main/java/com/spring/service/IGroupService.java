package com.spring.service;

import com.spring.bean.ShadeGroup;

import java.util.List;

public interface IGroupService {

    ShadeGroup getById(Integer id);

    List<ShadeGroup> getShadeGroupList(Integer[] id,String[] name);
}
