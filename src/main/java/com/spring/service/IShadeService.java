package com.spring.service;

import com.spring.bean.Shade;

import java.util.List;

/**
 * Created by lenovo on 2017/5/3.
 */
public interface IShadeService {

    List<Shade> getShadeList(List<Integer> idList,List<String> nameList ,Integer priotity,String status);

    Shade getById(Integer id);

    List<Shade> getAll();
}