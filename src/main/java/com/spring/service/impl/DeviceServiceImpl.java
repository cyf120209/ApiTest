package com.spring.service.impl;

import com.spring.bean.Device;
import com.spring.bean.Shade;
import com.spring.bean.ShadeGroup;
import com.spring.dao.IDeviceDao;
import com.spring.dao.IShadeDao;
import com.spring.dao.impl.DeviceRmi;
import com.spring.dao.impl.ShadeRmi;
import com.spring.service.IDeviceService;
import com.spring.service.IShadeService;
import org.springframework.stereotype.Service;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/3/21.
 */
@Service
public class DeviceServiceImpl implements IDeviceService {

//    @Autowired
//    private IDeviceDao iDeviceDao;

    private IDeviceDao deviceDao;

    public DeviceServiceImpl() {
        deviceDao = new DeviceRmi();
    }

    @Override
    public List<Device> getDeviceList(Integer[] id, String[] name, String mac, String modelName, String version) {
        List<Device> deviceList=new ArrayList<>();
        List<Device> list = deviceDao.queryAll();
//        List<Shade> list = iShadeDao.queryAll();
        Observable.from(list)
                .filter(new Func1<Device, Boolean>() {
                    @Override
                    public Boolean call(Device device) {
                        if (id == null || id.length == 0) {
                            return true;
                        } else {
                            return getDeviceById(device.getDeviceId(), id);
                        }
                    }
                })
                .filter(new Func1<Device, Boolean>() {
                    @Override
                    public Boolean call(Device device) {
                        if (name == null || name.length == 0) {
                            return true;
                        } else {
                            return getDeviceByName(device.getDeviceName(), name);
                        }
                    }
                })
                .filter(new Func1<Device, Boolean>() {
                    @Override
                    public Boolean call(Device device) {
                        if (mac == null) {
                            return true;
                        } else {
                            return mac.equals(device.getMac());
                        }
                    }
                })
                .filter(new Func1<Device, Boolean>() {
                    @Override
                    public Boolean call(Device device) {
                        if (modelName == null) {
                            return true;
                        } else {
                            return modelName.equals(device.getModelName());
                        }
                    }
                })
                .filter(new Func1<Device, Boolean>() {
                    @Override
                    public Boolean call(Device device) {
                        if (version == null) {
                            return true;
                        } else {
                            return version.equals(device.getVersion());
                        }
                    }
                })
                .subscribe(new Action1<Device>() {
                    @Override
                    public void call(Device device) {
                        deviceList.add(device);
                    }
                });
        return deviceList;
    }

    @Override
    public List<Device> getMoveList(Integer[] id, String[] name, Integer[] groupId, String[] groupName, Integer position, Integer percentage, Integer command, Integer priority) {
        List<Device> deviceList=new ArrayList<>();
        List<Device> list = deviceDao.queryAll();
//        if(pageSize!=null){
//            list=list.subList((pageStartIndex-1) * pageSize,pageStartIndex * pageSize);
//        }
//        Observable.from(list)
//                .filter(new Func1<Shade, Boolean>() {
//                    @Override
//                    public Boolean call(Shade shade) {
//                        if (id == null || id.length == 0) {
//                            return true;
//                        } else {
//                            return getShadeById(shade.getShadeId(), id);
//                        }
//                    }
//                })
//                .filter(new Func1<Shade, Boolean>() {
//                    @Override
//                    public Boolean call(Shade shade) {
//                        if (name == null || name.length == 0) {
//                            return true;
//                        } else {
//                            return getShadeByName(shade.getShadeName(), name);
//                        }
//                    }
//                })
//                .filter(new Func1<Shade, Boolean>() {
//                    @Override
//                    public Boolean call(Shade shade) {
//                        if (position == null) {
//                            return true;
//                        } else {
//                            return position.intValue()==shade.getShadePosition().intValue();
//                        }
//                    }
//                })
//                .filter(new Func1<Shade, Boolean>() {
//                    @Override
//                    public Boolean call(Shade shade) {
//                        if (priority == null) {
//                            return true;
//                        } else {
//                            return priority.intValue()==shade.getShadePriority().intValue();
//                        }
//                    }
//                })
//                .subscribe(new Action1<Shade>() {
//                    @Override
//                    public void call(Shade shade) {
//                        shadeList.add(shade);
//                    }
//                });
        return deviceList;
    }

    @Override
    public List<ShadeGroup> getShadeGroupList(Integer[] id, String[] name) {
//        shadeDao.queryAll();
        return null;
    }

    @Override
    public Boolean updateDevice(Device device) {
        Boolean aBoolean = deviceDao.updateDevice(device);
        return aBoolean;
    }

    private Boolean getDeviceById(Integer deviceId, Integer[] id) {
        for (Integer i : id) {
            if (i.intValue() == deviceId.intValue()) {
                return true;
            }
        }
        return false;
    }

    private Boolean getDeviceByName(String deviceName, String[] name) {
        for (String i : name) {
            if (i.equals(deviceName)) {
                return true;
            }
        }
        return false;
    }

}
