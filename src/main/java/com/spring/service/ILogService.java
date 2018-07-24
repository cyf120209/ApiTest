package com.spring.service;

import com.spring.bean.Shade;
import com.spring.bean.ShadeGroup;
import entity.Log;

import java.util.List;

/**
 * Created by lenovo on 2017/5/3.
 */
public interface ILogService {

    List<Log> getLogList(Integer[] source,Integer[] frametype,Integer[] destination,Integer pageSize, Integer pageStartIndex);

}