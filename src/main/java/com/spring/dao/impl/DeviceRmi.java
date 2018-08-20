package com.spring.dao.impl;

import com.spring.bean.Device;
import com.spring.bean.Shade;
import com.spring.dao.IDeviceDao;
import com.spring.dao.IShadeDao;
import com.spring.utils.Entity2BeanUtils;
import manager.rmi.IDevice;
import manager.rmi.IShade;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class DeviceRmi extends Rmi<IDevice> implements IDeviceDao{

    @Override
    String getRmiName() {
        return "device";
    }

    @Override
    public Device queryById(Integer id) {
        return null;
    }

    @Override
    public List<Device> queryAll() {
        List<entity.Device> deviceList = new ArrayList<>();
        List<Device> list = new ArrayList<>();
        try {
            deviceList = getRmi().getDeviceList();
            list = Entity2BeanUtils.entity2beanDevice(deviceList);
        } catch (RemoteException e) {
            resetRmi();
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Boolean updateDevice(Device device) {
        try {
            Boolean aBoolean = getRmi().updateDevice(Entity2BeanUtils.bean2entity(device));
            return aBoolean;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
