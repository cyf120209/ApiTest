package com.spring.service.impl;

import com.spring.bean.AddGroupEntity;
import com.spring.bean.GroupEntity;
import com.spring.bean.ShadeGroup;
import com.spring.dao.impl.GroupRmi;
import com.spring.dao.IGroupDao;
import com.spring.service.IGroupService;
import com.spring.utils.Entity2BeanUtils;
import org.springframework.stereotype.Service;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import javax.annotation.Resource;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/3/23.
 */
@Service
public class GroupServiceImpl implements IGroupService {

//    @Resource
//    private IGroupDao groupDao;

    private IGroupDao groupDao;

    public GroupServiceImpl() {
        groupDao = new GroupRmi();
    }

    @Override
    public ShadeGroup getById(Integer id) {
        ShadeGroup group = groupDao.queryById(id);
        return group;
    }

    @Override
    public List<ShadeGroup> getShadeGroupList(Integer[] id, String[] name) {
        List<ShadeGroup> groupList = new ArrayList<>();
        List<ShadeGroup> list = groupDao.queryAll();
        Observable.from(list)
                .filter(new Func1<ShadeGroup, Boolean>() {
                    @Override
                    public Boolean call(ShadeGroup shadeGroup) {
                        if (id == null || id.length == 0) {
                            return true;
                        } else {
                            return getShadeGroupById(shadeGroup.getId(), id);
                        }
                    }
                })
                .filter(new Func1<ShadeGroup, Boolean>() {
                    @Override
                    public Boolean call(ShadeGroup shadeGroup) {
                        if (name == null || name.length == 0) {
                            return true;
                        } else {
                            return getShadeGroupByName(shadeGroup.getGroupName(), name);
                        }
                    }
                })
                .subscribe(new Action1<ShadeGroup>() {
                    @Override
                    public void call(ShadeGroup shadeGroup) {
                        groupList.add(shadeGroup);
                    }
                });
        return groupList;
    }

    /**
     * 组的基本操作
     *
     * @param groupEntity 组操作的实体（设备ID，组ID，命令）
     */
    public void operation(GroupEntity groupEntity) {
    }


    /**
     * 添加组
     *
     * @param groupID 组ID
     */
    public void add(int deviceID, int groupID, AddGroupEntity entity) {
    }

    /**
     * 更新组
     *
     * @param groupID   组ID
     * @param groupName 组名称
     */
    public void update(int groupID, String groupName) {
        //TODO

    }

    /**
     * 删除设备下的某个组
     *
     * @param deviceID 设备ID
     * @param groupID  组ID
     */
    public void delete(int deviceID, int groupID) {
    }

    /**
     * 删除组下面的某个电机
     *
     * @param deviceID 设备ID
     * @param groupID  组ID
     * @param draperID 电机ID
     */
    public void delete(int deviceID, int groupID, int draperID) {
    }

    private Boolean getShadeGroupById(Integer groupId, Integer[] id) {
        for (Integer i : id) {
            if (i.intValue() == groupId.intValue()) {
                return true;
            }
        }
        return false;
    }

    private Boolean getShadeGroupByName(String groupName, String[] name) {
        for (String i : name) {
            if (i.equals(groupName)) {
                return true;
            }
        }
        return false;
    }

}
