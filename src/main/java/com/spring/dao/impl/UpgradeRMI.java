package com.spring.dao.impl;

import manager.rmi.IUpgrade;
import manager.rmi.IUpgradeCallback;
import model.FirmWareInformation;

import java.io.File;
import java.rmi.RemoteException;
import java.util.List;

public class UpgradeRMI extends Rmi<IUpgrade> implements IUpgrade {

    @Override
    String getRmiName() {
        return "upgrade";
    }


    @Override
    public List<FirmWareInformation> chooseFirmware(String path) throws RemoteException {
        return getRmi().chooseFirmware(path);
    }

    @Override
    public List<FirmWareInformation> chooseFirmware(File file) throws RemoteException {
        return null;
    }

    @Override
    public void startUpdate(IUpgradeCallback callback) throws RemoteException {
        getRmi().startUpdate(callback);
    }

    @Override
    public void startUpdate() throws RemoteException {

    }
}
