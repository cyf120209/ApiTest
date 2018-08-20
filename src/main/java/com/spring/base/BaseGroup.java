package com.spring.base;

import entity.ShadeGroup;

import java.util.List;

public interface BaseGroup {

    List<ShadeGroup> getGroupList() ;

    ShadeGroup getByGroupId(int id) ;

    void groupSubscriptionToSelect(Integer id, Boolean remove, Integer deviceId, Integer groupId);

}
