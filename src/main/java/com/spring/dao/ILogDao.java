package com.spring.dao;

import entity.Log;

import java.util.List;

public interface ILogDao {

    /**
     * 通过id 查询组信息
     * @param id
     * @return
     */
    Log queryById(Integer id);

    /**
     * 查询所有的组信息
     * @return
     */
    List<Log> queryAll();
}
