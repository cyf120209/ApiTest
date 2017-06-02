package com.spring.service;

import com.spring.bean.Shade;

import java.util.List;

/**
 * Created by lenovo on 2017/5/3.
 */
public interface IShadeDao {

    List<Shade> getShadeList(List<Integer> idList,List<String> nameList ,Integer priotity,String status);
}