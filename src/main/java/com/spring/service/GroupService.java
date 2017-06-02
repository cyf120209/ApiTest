package com.spring.service;

import com.serotonin.bacnet4j.RemoteDevice;
import com.serotonin.bacnet4j.exception.BACnetException;
import com.serotonin.bacnet4j.type.Encodable;
import com.serotonin.bacnet4j.type.constructed.Sequence;
import com.serotonin.bacnet4j.type.primitive.ObjectIdentifier;
import com.serotonin.bacnet4j.type.primitive.UnsignedInteger;
import com.spring.bean.AddGroupEntity;
import com.spring.bean.GroupEntity;
import com.spring.bean.Shade;
import com.spring.bean.ShadeGroup;
import com.spring.dao.GroupDao;
import com.spring.model.DraperSubItem;
import com.spring.model.DraperSubList;
import com.spring.utils.Draper;
import com.spring.utils.MyLocalDevice;
import com.spring.utils.RemoteUtils;
import com.spring.utils.RxBus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rx.Subscription;
import rx.functions.Action1;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by lenovo on 2017/3/23.
 */
@Service
public class GroupService {

    @Resource
    private GroupDao groupDao;

    public GroupDao getGroupDao() {
        return groupDao;
    }

    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    /**
     * 获取map关系列表
     * @return
     */
    @Transactional
    public List<ShadeGroup> getGroup(){
        return groupDao.getGroupList();
    }

    public List<Shade> getGroup(Integer groupId){
        return groupDao.getGroup(groupId);
    }

    public Map<Integer,List<Shade>> getGroupShadeMap(){
        return groupDao.getGroupShadeMap();
    }

    /**
     * 组的基本操作
     * @param groupEntity 组操作的实体（设备ID，组ID，命令）
     */
    public void operation(GroupEntity groupEntity){
        try {
            Draper.sendCmd(groupEntity.getDeviceID(), groupEntity.getGroupID(), groupEntity.getCmd());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 添加组
     * @param groupID 组ID
     */
    public void add(int deviceID, int groupID,AddGroupEntity entity){
        List<Integer> draperList = entity.getDraperList();
        RemoteUtils remoteUtils = MyLocalDevice.remoteUtils;
        Map<Integer, RemoteDevice> remoteDeviceMap = remoteUtils.getRemoteDeviceMap();
        for (Integer integer: draperList) {
            RemoteDevice remoteDevice = remoteDeviceMap.get(integer);
            try {
                Draper.sendGroupSubscriptionToSelect(remoteDevice,false,deviceID,groupID);
            } catch (BACnetException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 更新组
     * @param groupID 组ID
     * @param groupName 组名称
     */
    public void update(int groupID,String groupName){
        //TODO

    }

    /**
     * 删除设备下的某个组
     * @param deviceID 设备ID
     * @param groupID 组ID
     */
    public void delete(int deviceID,int groupID){
        try {
            Draper.sendGroupSubscription(true,deviceID,groupID);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 删除组下面的某个电机
     * @param deviceID 设备ID
     * @param groupID 组ID
     * @param draperID 电机ID
     */
    public void delete(int deviceID,int groupID,int draperID){
        try {
            RemoteUtils remoteUtils = MyLocalDevice.remoteUtils;
            Map<Integer, RemoteDevice> remoteDeviceMap = remoteUtils.getRemoteDeviceMap();
            Draper.sendGroupSubscriptionToSelect(remoteDeviceMap.get(draperID),true,deviceID,groupID);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
