package com.spring.service;

import com.spring.bean.Shade;
import com.spring.bean.ShadeGroup;

import java.util.List;

/**
 * Created by lenovo on 2017/5/3.
 */
public interface IShadeService {

    List<Shade> getShadeList(Integer[] id,String[] name,Integer priority,String status,Integer pageSize,Integer pageStartIndex);

    List<Shade> getMoveList(Integer[] id,String[] name,Integer[] groupId,String[] groupName,Integer position,Integer percentage,Integer command,Integer priority);

    List<ShadeGroup> getShadeGroupList(Integer[] id,String[] name);
}