package com.spring.service;

import com.serotonin.bacnet4j.RemoteDevice;
import com.serotonin.bacnet4j.exception.BACnetException;
import com.spring.bean.Shade;
import com.spring.model.DraperInformation;
import com.spring.utils.Draper;
import com.spring.utils.MyLocalDevice;
import com.spring.utils.RemoteUtils;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.*;

/**
 * Created by lenovo on 2017/5/3.
 */
public class ShadeCache implements IShadeDao {

    @Override
    public List<Shade> getShadeList(List<Integer> idList,List<String> nameList,Integer priotity,String status) {
        RemoteUtils remoteUtils = MyLocalDevice.remoteUtils;
        List<Shade> draperList=new ArrayList<>();
        Map<Integer, Shade> shadeMap = remoteUtils.getShadeMap();
        Iterator<Map.Entry<Integer, Shade>> iterator = shadeMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Shade> next = iterator.next();
            Shade shade = next.getValue();
            draperList.add(shade);
        }
        List<Shade> shades=new ArrayList<>();
        rx.Observable.from(draperList)
                .filter(new Func1<Shade, Boolean>() {
                    @Override
                    public Boolean call(Shade shade) {
                        if(idList==null || idList.size()==0){
                            return true;
                        }else {
                            return idList.contains(shade.getId());
                        }
                    }
                })
                .filter(new Func1<Shade, Boolean>() {
                    @Override
                    public Boolean call(Shade shade) {
                        if(nameList==null || nameList.size()==0){
                            return true;
                        }else {
                            return nameList.contains(shade.getShadeName());
                        }
                    }
                })
                .filter(new Func1<Shade, Boolean>() {
                    @Override
                    public Boolean call(Shade shade) {
                        if(priotity==null || priotity==0){
                            return true;
                        }else {
                            return priotity == shade.getShadePriority();
                        }
                    }
                })
                .filter(new Func1<Shade, Boolean>() {
                    @Override
                    public Boolean call(Shade shade) {
                        if(status==null || "".equals(status)){
                            return true;
                        }else {
                            return status.equals(shade.getShadeStatus());
                        }
                    }
                })
                .subscribe(new Action1<Shade>() {
                    @Override
                    public void call(Shade shade) {
                        shades.add(shade);
                    }
                });
        return shades;
    }

    public List<Shade> getShadeList(Integer[] id,String[] name){
        RemoteUtils remoteUtils = MyLocalDevice.remoteUtils;
        List<Shade> draperList=new ArrayList<>();
        Map<Integer, Shade> shadeMap = remoteUtils.getShadeMap();
        Iterator<Map.Entry<Integer, Shade>> iterator = shadeMap.entrySet().iterator();
        while (iterator.hasNext()){
            if(id.length!=0){

            }
            Map.Entry<Integer, Shade> next = iterator.next();
            Shade shade = next.getValue();
            draperList.add(shade);
        }
        return null;
    }

    public List<Shade> getShadeList(Integer[] id){
        RemoteUtils remoteUtils = MyLocalDevice.remoteUtils;
        List<Shade> draperList=new ArrayList<>();
        Map<Integer, Shade> shadeMap = remoteUtils.getShadeMap();
        for (Integer integer:id){
            draperList.add(shadeMap.get(integer));
        }
        return draperList;
    }

    public List<Shade> getShadeList(String[] name){
        return null;
    }

    public List<Shade> getShadeInfo(Integer id,String name){
        List<Shade> shadeList=new LinkedList<>();
        RemoteUtils remoteUtils = MyLocalDevice.remoteUtils;
        Map<Integer, RemoteDevice> remoteDeviceMap = remoteUtils.getRemoteDeviceMap();
        try {
            DraperInformation draperInformation = Draper.sendAnnounceDraperInformation(remoteDeviceMap.get(id));
            Shade.Build build = new Shade.Build();
            Shade shade = build.setId(id)
                    .setName("")
                    .setPosition(draperInformation.getCurPosition().intValue())
                    .create();
            shadeList.add(shade);
            return shadeList;
        } catch (BACnetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
