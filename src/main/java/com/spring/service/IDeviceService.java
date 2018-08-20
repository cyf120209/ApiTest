package com.spring.service;

import com.spring.bean.Device;
import com.spring.bean.ShadeGroup;

import java.util.List;

/**
 * Created by lenovo on 2017/5/3.
 */
public interface IDeviceService {

    List<Device> getDeviceList(Integer[] id, String[] name, String mac, String modelName, String version);

    List<Device> getMoveList(Integer[] id, String[] name, Integer[] groupId, String[] groupName, Integer position, Integer percentage, Integer command, Integer priority);

    List<ShadeGroup> getShadeGroupList(Integer[] id, String[] name);

    public Boolean updateDevice(Device device);
}