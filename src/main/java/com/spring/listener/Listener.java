package com.spring.listener;

import com.serotonin.bacnet4j.LocalDevice;
import com.serotonin.bacnet4j.RemoteDevice;
import com.serotonin.bacnet4j.RemoteObject;
import com.serotonin.bacnet4j.event.DeviceEventAdapter;
import com.serotonin.bacnet4j.type.Encodable;
import com.serotonin.bacnet4j.type.constructed.Sequence;
import com.serotonin.bacnet4j.type.primitive.ObjectIdentifier;
import com.serotonin.bacnet4j.type.primitive.UnsignedInteger;
import com.spring.model.DraperSubItem;
import com.spring.model.DraperSubList;
import com.spring.utils.MyLocalDevice;
import com.spring.utils.RemoteUtils;
import com.spring.utils.RxBus;
import com.spring.utils.STExecutor;

import java.util.*;


/**
 * Created by lenovo on 2017/1/19.
 */
public class Listener extends DeviceEventAdapter {
    private Object lock=new Object();
    public LocalDevice localDevice;

    /**
     * announce类型 1：代表全部，2：代表组
     */
    private int mAnnounceType=1;

    /**
     * serviceParameters参数列表，主要防止重复添加
     */
    private List<Sequence> mSequence = new ArrayList<>();

    /**
     * 电机，设备和组的关系列表
     */
    private Map<Integer, Map<Integer, List<Integer>>> mRelativeList = new HashMap<>();

    /**
     * 设备ID列表
     */
    private List<Integer> mDevicesIDList = new ArrayList<>();

    public Listener() {
        this.localDevice = MyLocalDevice.getInstance();
    }

    @Override
    public void iAmReceived(RemoteDevice d) {
//        super.iAmReceived(d);
        System.out.println("iHaveReceived"+d);
        RemoteUtils remoteUtils = MyLocalDevice.remoteUtils;
        boolean exist = remoteUtils.isExist(d);
        if(exist){
            return;
        }
//        RxBus.getDefault().post(d);
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                remoteUtils.addRemoteDevice(d);
            }
        };
        STExecutor.submit(runnable);
    }

    @Override
    public void iHaveReceived(final RemoteDevice d, final RemoteObject o) {

    }

    @Override
    public void privateTransferReceived(UnsignedInteger vendorId, UnsignedInteger serviceNumber, Encodable serviceParameters) {
//        super.privateTransferReceived(vendorId, serviceNumber, serviceParameters);
        paraseServiceParameter(serviceNumber,(Sequence)serviceParameters);
    }

    public synchronized void paraseServiceParameter(UnsignedInteger serviceNumber, Sequence serviceParameters) {
        Sequence parms = serviceParameters;
        if (serviceNumber.intValue() == 7) {
            if (mAnnounceType == 1) {
                deviceAnnounce(parms);
            } else {
                groupAnnounce(parms);
            }
        }
    }

    private void groupAnnounce(Sequence parms) {
        Map<String, Encodable> values1 = parms.getValues();
        ObjectIdentifier draperID1 = (ObjectIdentifier) values1.get("draperID");
        int instanceNumber1 = draperID1.getInstanceNumber();
        List<Integer> list = new ArrayList<>();
        list.add(instanceNumber1);
    }

    private void deviceAnnounce(Sequence parms) {
        //parms 去重处理
        if (mSequence.contains(parms)) {
            return;
        }
        mSequence.add(parms);
        Map<String, Encodable> values1 = parms.getValues();
        //获取draperID
        ObjectIdentifier draperID1 = (ObjectIdentifier) values1.get("draperID");
        int instanceNumber1 = draperID1.getInstanceNumber();
        //该draperID下的设备-组关系
        DraperSubList deviceGroup1 = (DraperSubList) values1.get("DeviceGroup");
        for (DraperSubItem item1 : deviceGroup1.getList()) {
            Map<Integer, List<Integer>> CdevGrpInf = null;
            CdevGrpInf = mRelativeList.get(item1.getDevicID().getInstanceNumber());
            if (CdevGrpInf == null) {
                CdevGrpInf = new HashMap<Integer, List<Integer>>();
                mRelativeList.put(item1.getDevicID().getInstanceNumber(), CdevGrpInf);
            }
            if (!mDevicesIDList.contains(item1.getDevicID().getInstanceNumber())) {
                mDevicesIDList.add(item1.getDevicID().getInstanceNumber());
            }
            List<Integer> devList = null;
            devList = CdevGrpInf.get(item1.getGroupID().intValue());
            if (devList == null) {
                devList = new LinkedList<Integer>();
                CdevGrpInf.put(item1.getGroupID().intValue(), devList);
            }
            if (!devList.contains(instanceNumber1)) {
                devList.add(instanceNumber1);
            }
        }
        RemoteUtils remoteUtils = MyLocalDevice.remoteUtils;
        List<Integer> remoteDeviceIDList = remoteUtils.getRemoteDeviceIDList();
        if(remoteDeviceIDList.contains(new Integer(instanceNumber1))){
            remoteDeviceIDList.remove(new Integer(instanceNumber1));
        }
        System.out.println("------------"+remoteDeviceIDList.size());
        if(remoteDeviceIDList.size()==0){
            remoteUtils.setMap(mRelativeList);
        }
//        Vector vector = new Vector();
//        mGroupOperationView.updateDevice(mDevicesIDList.toArray());
    }
}