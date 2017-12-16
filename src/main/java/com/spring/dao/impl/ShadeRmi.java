package com.spring.dao.impl;

import com.spring.bean.Shade;
import com.spring.common.Common;
import com.spring.dao.IShadeDao;
import com.spring.utils.Entity2BeanUtils;
import manager.rmi.IRmi;
import manager.rmi.IShade;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ShadeRmi extends Rmi<IShade> implements IShadeDao{

    @Override
    String getRmiName() {
        return "shade";
    }

    @Override
    public Shade queryById(Integer id) {
        return null;
    }

    @Override
    public List<Shade> queryAll() {
        List<entity.Shade> shadeList = new ArrayList<>();
        List<Shade> list = new ArrayList<>();
        try {
            shadeList = getRmi().getShadeList();
            list = Entity2BeanUtils.entity2beanShade(shadeList);
        } catch (RemoteException e) {
            resetRmi();
            e.printStackTrace();
        }
        return list;
    }
}
