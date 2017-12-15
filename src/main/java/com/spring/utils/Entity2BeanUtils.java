package com.spring.utils;


import com.spring.bean.Device;
import com.spring.bean.Shade;
import com.spring.bean.ShadeGroup;

import java.util.ArrayList;
import java.util.List;

public class Entity2BeanUtils {

    public static List<Shade> entity2beanShade(List<entity.Shade> lists){
        List<Shade> shadeList=new ArrayList<>();
        for (entity.Shade list:lists) {
            shadeList.add(new Shade(list.getShadeId(),list.getShadeName(),list.getShadePosition(),list.getShadePriority(),list.getShadeStatus()));
        }
        return shadeList;
    }

    public static Shade entity2bean(entity.Shade shade){
        return new Shade(shade.getShadeId(),shade.getShadeName(),shade.getShadePosition(),shade.getShadePriority(),shade.getShadeStatus());
    }

    public static List<ShadeGroup> entity2beanGroup(List<entity.ShadeGroup> lists){
        List<ShadeGroup> groupList=new ArrayList<>();
        for (entity.ShadeGroup list:lists) {
            groupList.add(new ShadeGroup(list.getId(),list.getGroupId(),list.getDeviceId(),list.getGroupName()));
        }
        return groupList;
    }

    public static ShadeGroup entity2bean(entity.ShadeGroup group){
        return new ShadeGroup(group.getId(),group.getGroupId(),group.getDeviceId(),group.getGroupName());
    }

    public static List<Device> entity2beanDevice(List<entity.Device> lists){
        List<Device> deviceList=new ArrayList<>();
        for (entity.Device list:lists) {
            deviceList.add(new Device(list.getId(),list.getDeviceId(),list.getDeviceName(),list.getMac(),list.getModelName(),list.getVersion(),list.getRemarks()));
        }
        return deviceList;
    }

    public static Device entity2bean(entity.Device device){
        return new Device(device.getId(),device.getDeviceId(),device.getDeviceName(),device.getMac(),device.getModelName(),device.getVersion(),device.getRemarks());
    }
}
