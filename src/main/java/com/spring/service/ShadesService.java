package com.spring.service;

import com.serotonin.bacnet4j.RemoteDevice;
import com.spring.bean.DraperEntity;
import com.spring.bean.Shade;
import com.spring.dao.ShadeDao;
import com.spring.utils.Draper;
import com.spring.utils.MyLocalDevice;
import com.spring.utils.RemoteUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by lenovo on 2017/3/21.
 */
@Service
public class ShadesService {

//    private IShadeDao IShadeDao =new ShadeCache();

//    public void setIShadeDao(IShadeDao IShadeDao) {
//        this.IShadeDao = IShadeDao;
//    }

    private ShadeDao shadeDao;

    public ShadeDao getShadeDao() {
        return shadeDao;
    }

    public void setShadeDao(ShadeDao shadeDao) {
        this.shadeDao = shadeDao;
    }

    /**
     * 获取电机列表
     * @return
     */
    @Transactional
    public List<Shade> getShadeList(){
        return shadeDao.getShadeList(null,null,null,null);
    }

    /**
     * 移动操作
     * @param draperEntity
     */
    public void move(DraperEntity draperEntity){
        RemoteUtils remoteUtils = MyLocalDevice.remoteUtils;
        Map<Integer, RemoteDevice> remoteDeviceMap = remoteUtils.getRemoteDeviceMap();
        RemoteDevice remoteDevice = remoteDeviceMap.get(draperEntity.getDraperID());
        try {
            Draper.sendCmd(remoteDevice,draperEntity.getCmd());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
