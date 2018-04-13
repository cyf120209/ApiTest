package com.spring.upgrade;

import com.spring.dao.impl.UpgradeRMI;
import com.spring.socket.SpringWebSocketHandler;
import manager.rmi.IUpgradeCallback;
import model.FirmWareInformation;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.List;

@Service("upgradeService")
public class UpgradeService {

    private final SpringWebSocketHandler handler;
    private UpgradeRMI upgradeRMI;

    public UpgradeService() {
        upgradeRMI = new UpgradeRMI();
        handler = new SpringWebSocketHandler();
    }

    public List<FirmWareInformation> chooseFirmware(String path)  {
        try {
            List<FirmWareInformation> firmWareInformations = upgradeRMI.chooseFirmware(path);
            return firmWareInformations;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void startUpdate(){
        try {
            IUpgradeCallback upgradeCallBack = new UpgradeCallBack(handler);
            upgradeRMI.startUpdate(upgradeCallBack);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }

}
