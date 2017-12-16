package com.spring.dao.impl;

import com.spring.common.Common;
import manager.rmi.IRmi;
import manager.rmi.IShade;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public abstract class Rmi<T> implements IRmi<T> {

    T rmi = null;

    /**
     * 远程方法的名称
     * @return
     */
    abstract String getRmiName();

    @Override
    public T getRmi() {
        if(rmi==null) {
            try {
                rmi = (T) Naming.lookup("//" + Common.HOST_IP + ":" + Common.RMI_PORT + "/" + getRmiName());
            } catch (NotBoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return rmi;
    }

    @Override
    public T resetRmi() {
        try {
            rmi = (T) Naming.lookup("//" + Common.HOST_IP + ":" + Common.RMI_PORT + "/" + getRmiName());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return rmi;
    }
}
