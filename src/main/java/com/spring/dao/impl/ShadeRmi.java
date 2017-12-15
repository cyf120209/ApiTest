package com.spring.dao.impl;

import com.spring.bean.Shade;
import com.spring.common.Common;
import com.spring.dao.IShadeDao;
import com.spring.utils.Entity2BeanUtils;
import manager.rmi.IShade;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ShadeRmi implements IShadeDao {

    private static IShade shade;

    static {
        try {
            shade = (IShade) Naming.lookup("//"+ Common.HOST_IP+":"+Common.RMI_PORT+"/shade");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
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
            shadeList = shade.getShadeList();
            list = Entity2BeanUtils.entity2beanShade(shadeList);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return list;
    }
}
