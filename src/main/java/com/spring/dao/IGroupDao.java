package com.spring.dao;

import com.spring.bean.ShadeGroup;

import java.rmi.RemoteException;
import java.util.List;

public interface IGroupDao {

    /**
     * 通过id 查询组信息
     * @param id
     * @return
     */
    ShadeGroup queryById(Integer id);

    /**
     * 查询所有的组信息
     * @return
     */
    List<ShadeGroup> queryAll();
}
