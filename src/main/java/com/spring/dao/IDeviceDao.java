package com.spring.dao;

import com.spring.bean.Device;

import java.util.List;

/**
 * Created by lenovo on 2017/10/19.
 */
public interface IDeviceDao {

    /**
     * 通过ID查询电机单台电机
     *
     * @param id
     * @return
     */
    Device queryById(Integer id);

    /**
     * 查询所有
     *
     * @return
     */
    List<Device> queryAll();
//    List<Shade> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    Boolean updateDevice(Device device);
}
