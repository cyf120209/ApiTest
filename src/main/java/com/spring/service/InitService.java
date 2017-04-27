package com.spring.service;

import com.serotonin.bacnet4j.LocalDevice;
import com.serotonin.bacnet4j.exception.BACnetException;
import com.serotonin.bacnet4j.service.unconfirmed.WhoIsRequest;
import com.spring.utils.Draper;
import com.spring.utils.MyLocalDevice;
import com.spring.utils.RemoteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.border.*;


/**
 * Created by lenovo on 2017/3/20.
 */
public class InitService {

    private LocalDevice localDevice;

    public boolean init(String port){
        boolean isSuccess=false;
        localDevice = MyLocalDevice.getInstance(port);
        if (localDevice!=null){
            isSuccess=true;
        }
        // 设置定时器
        Timer timer = new Timer(1*60*60*1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    RemoteUtils remoteUtils = MyLocalDevice.remoteUtils;
                    localDevice.sendGlobalBroadcast(new WhoIsRequest());
                    remoteUtils.clearRemoteDevice();
                    Thread.sleep(2000);
                    Draper.sendAnnounce();
                    remoteUtils.clearMap();
                } catch (BACnetException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

            }
        });
        timer.start();
        return isSuccess;
    }

}
