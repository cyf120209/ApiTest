package com.spring.service.impl;

import com.spring.bean.Shade;
import com.spring.bean.ShadeGroup;
import com.spring.dao.IShadeDao;
import com.spring.dao.impl.ShadeRmi;
import com.spring.service.IShadeService;
import org.springframework.stereotype.Service;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.*;

/**
 * Created by lenovo on 2017/3/21.
 */
@Service
public class ShadeServiceImpl implements IShadeService {

//    @Autowired
    private IShadeDao iShadeDao;

    private IShadeDao shadeDao;

    public ShadeServiceImpl() {
        shadeDao = new ShadeRmi();
    }

    @Override
    public List<Shade> getShadeList(Integer[] id, String[] name, Integer priority, String status, Integer pageSize, Integer pageStartIndex) {
        List<Shade> shadeList=new ArrayList<>();
        List<Shade> list = shadeDao.queryAll();
//        List<Shade> list = iShadeDao.queryAll();
        if(pageSize!=null){
            list=list.subList((pageStartIndex-1) * pageSize,(list.size()<=(pageStartIndex * pageSize))?(list.size()-1):pageStartIndex * pageSize);
        }
        Observable.from(list)
                .filter(new Func1<Shade, Boolean>() {
                    @Override
                    public Boolean call(Shade shade) {
                        if (id == null || id.length == 0) {
                            return true;
                        } else {
                            return getShadeById(shade.getShadeId(), id);
                        }
                    }
                })
                .filter(new Func1<Shade, Boolean>() {
                    @Override
                    public Boolean call(Shade shade) {
                        if (name == null || name.length == 0) {
                            return true;
                        } else {
                            return getShadeByName(shade.getShadeName(), name);
                        }
                    }
                })
                .filter(new Func1<Shade, Boolean>() {
                    @Override
                    public Boolean call(Shade shade) {
                        if (priority == null) {
                            return true;
                        } else {
                            return priority.intValue()==shade.getShadePriority().intValue();
                        }
                    }
                })
                .filter(new Func1<Shade, Boolean>() {
                    @Override
                    public Boolean call(Shade shade) {
                        if (status == null) {
                            return true;
                        } else {
                            return status.equals(shade.getShadeStatus());
                        }
                    }
                })
                .subscribe(new Action1<Shade>() {
                    @Override
                    public void call(Shade shade) {
                        shadeList.add(shade);
                    }
                });
        return shadeList;
    }

    @Override
    public List<Shade> getMoveList(Integer[] id, String[] name, Integer[] groupId, String[] groupName, Integer position, Integer percentage, Integer command, Integer priority) {
        List<Shade> shadeList=new ArrayList<>();
        List<Shade> list = shadeDao.queryAll();
//        if(pageSize!=null){
//            list=list.subList((pageStartIndex-1) * pageSize,pageStartIndex * pageSize);
//        }
        Observable.from(list)
                .filter(new Func1<Shade, Boolean>() {
                    @Override
                    public Boolean call(Shade shade) {
                        if (id == null || id.length == 0) {
                            return true;
                        } else {
                            return getShadeById(shade.getShadeId(), id);
                        }
                    }
                })
                .filter(new Func1<Shade, Boolean>() {
                    @Override
                    public Boolean call(Shade shade) {
                        if (name == null || name.length == 0) {
                            return true;
                        } else {
                            return getShadeByName(shade.getShadeName(), name);
                        }
                    }
                })
                .filter(new Func1<Shade, Boolean>() {
                    @Override
                    public Boolean call(Shade shade) {
                        if (position == null) {
                            return true;
                        } else {
                            return position.intValue()==shade.getShadePosition().intValue();
                        }
                    }
                })
                .filter(new Func1<Shade, Boolean>() {
                    @Override
                    public Boolean call(Shade shade) {
                        if (priority == null) {
                            return true;
                        } else {
                            return priority.intValue()==shade.getShadePriority().intValue();
                        }
                    }
                })
                .subscribe(new Action1<Shade>() {
                    @Override
                    public void call(Shade shade) {
                        shadeList.add(shade);
                    }
                });
        return shadeList;
    }

    @Override
    public List<ShadeGroup> getShadeGroupList(Integer[] id, String[] name) {
        shadeDao.queryAll();
        return null;
    }

    private Boolean getShadeById(Integer shadeId, Integer[] id) {
        for (Integer i : id) {
            if (i.intValue() == shadeId.intValue()) {
                return true;
            }
        }
        return false;
    }

    private Boolean getShadeByName(String shadeName, String[] name) {
        for (String i : name) {
            if (i.equals(shadeName)) {
                return true;
            }
        }
        return false;
    }

}
