package com.spring.service;

import com.spring.base.BaseGroup;
import com.spring.bean.ShadeGroup;

import java.util.List;

public interface IGroupService{

    ShadeGroup getById(Integer id);

    List<ShadeGroup> getShadeGroupList(Integer[] id,String[] name);

    Boolean groupSubscriptionToSelect(Integer id, Boolean remove, Integer deviceId, Integer groupId);

}
