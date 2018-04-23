package com.spring.dao.impl;

import manager.rmi.IUpgrade;
import manager.rmi.IUpgradeCallback;
import model.FirmWareInformation;
import model.FirmWareResult;

import java.io.File;
import java.rmi.RemoteException;
import java.util.List;

public class UpgradeRMI extends Rmi<IUpgrade> implements IUpgrade {

    @Override
    String getRmiName() {
        return "upgrade";
    }


    @Override
    public FirmWareResult chooseFirmware(String path) throws RemoteException {
        FirmWareResult firmWareResult = getRmi().chooseFirmware(path);
        return firmWareResult;
    }

    @Override
    public void startUpdate(IUpgradeCallback callback) throws RemoteException {
        getRmi().startUpdate(callback);
    }

    @Override
    public void startUpdate() throws RemoteException {

    }
}
