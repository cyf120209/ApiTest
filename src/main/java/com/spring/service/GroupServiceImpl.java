package com.spring.service;

import com.spring.bean.AddGroupEntity;
import com.spring.bean.GroupEntity;
import com.spring.bean.ShadeGroup;
import com.spring.dao.IGroupDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2017/3/23.
 */
@Service
public class GroupServiceImpl implements IGroupService{

    @Resource
    private IGroupDao groupDao;

//    public GroupDao getGroupDao() {
//        return groupDao;
//    }

//    public void setGroupDao(GroupDao groupDao) {
//        this.groupDao = groupDao;
//    }

    /**
     * 获取map关系列表
     * @return
     */
//    @Transactional
//    public List<ShadeGroup> getGroup(){
//        return groupDao.getGroupList();
//    }

//    public List<Shade> getGroup(Integer groupId){
//        return groupDao.getGroup(groupId);
//    }

//    public Map<Integer,List<Shade>> getGroupShadeMap(){
//        return groupDao.getGroupShadeMap();
//    }

    /**
     * 组的基本操作
     * @param groupEntity 组操作的实体（设备ID，组ID，命令）
     */
    public void operation(GroupEntity groupEntity){
    }



    /**
     * 添加组
     * @param groupID 组ID
     */
    public void add(int deviceID, int groupID,AddGroupEntity entity){
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
    }

    /**
     * 删除组下面的某个电机
     * @param deviceID 设备ID
     * @param groupID 组ID
     * @param draperID 电机ID
     */
    public void delete(int deviceID,int groupID,int draperID){
    }

    @Override
    public ShadeGroup getById(Integer id) {
        return groupDao.queryById(id);
    }

    @Override
    public List<ShadeGroup> getAll() {
        return groupDao.queryAll();
    }
}
