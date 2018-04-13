package com.spring.upgrade;

import com.spring.socket.SpringWebSocketHandler;
import manager.rmi.IUpgradeCallback;
import org.springframework.web.socket.TextMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UpgradeCallBack extends UnicastRemoteObject implements IUpgradeCallback {

    private final SpringWebSocketHandler handler;

    public UpgradeCallBack(SpringWebSocketHandler handler) throws RemoteException {
//        super();
        this.handler=handler;
    }

    @Override
    public void onStart() {
        handler.sendMessageToUsers(new TextMessage("onstart"));
        System.out.println("onStart");
    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onFinish() {
        handler.sendMessageToUsers(new TextMessage("onstart"));
        System.out.println("onFinish");
    }

    @Override
    public void onProgressChanged(Integer masterProgress, Integer slaveProgress) {
        handler.sendMessageToUsers(new TextMessage("percent,"+masterProgress+","+slaveProgress));
        System.out.println("masterProgress: "+masterProgress+" slaveProgress: "+slaveProgress);
    }

    @Override
    public void showLog(String masterInfo, String slaveInfo) {
        System.out.println("showLog: "+masterInfo);
    }
}
