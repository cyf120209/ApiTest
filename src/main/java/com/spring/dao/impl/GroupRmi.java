package com.spring.dao.impl;

import com.spring.bean.ShadeGroup;
import com.spring.common.Common;
import com.spring.dao.IGroupDao;
import com.spring.utils.Entity2BeanUtils;
import manager.rmi.IApi;
import manager.rmi.IGroup;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/5/15.
 */
public class GroupRmi implements IGroupDao {

    private static IGroup group;

    static {
        try {
            group = (IGroup) Naming.lookup("//"+ Common.HOST_IP+":"+Common.RMI_PORT+"/group");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ShadeGroup queryById(Integer id) {
        try {
            entity.ShadeGroup group = GroupRmi.group.getByGroupId(id);
            return Entity2BeanUtils.entity2bean(group);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ShadeGroup> queryAll(){
        List<ShadeGroup> groupList=new ArrayList<>();
        try {
            List<entity.ShadeGroup> list = group.getGroupList();
            groupList.addAll(Entity2BeanUtils.entity2beanGroup(list));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return groupList;
    }

//    private SessionFactory session;
//
//    public SessionFactory getSession() {
//        return session;
//    }

//    public void setSession(SessionFactory session) {
//        this.session = session;
//    }

//    public List<ShadeGroup> getGroupList(){
//        StringBuffer buffer=new StringBuffer(1024);
//        buffer.append("from shadegroup");
//        Session session1 = session.openSession();
//        Query query = session1.createQuery(buffer.toString());
//        List list = query.list();
//        return list;
//    }

//    public List<Shade> getGroup(Integer groupId){
//        StringBuffer buffer=new StringBuffer(1024);
//        buffer.append("select s.id,s.shadeId,s.shadeName,s.shadePosition,s.shadePriority,s.shadeStatus ");
//        buffer.append("from shadeGroupRelation sgr,shade s where shadeGroupId="+groupId+" and sgr.shadeId=s.shadeId");
//        Session session1 = session.openSession();
//        Query query = session1.createQuery(buffer.toString());
//        List<Object[]> list = query.list();
//        List<Shade> shadeList=new ArrayList<>();
//        for (Object[] o:list){
//            shadeList.add(new Shade((Integer) o[1],(String) o[2],(Integer) o[3],(Integer) o[4],(String) o[5]));
//        }
//        return shadeList;
//    }
//
//    public Map<Integer,List<Shade>> getGroupShadeMap(){
//        StringBuffer buffer=new StringBuffer(1024);
//        buffer.append("select sgr.shadeGroupId,s.id,s.shadeId,s.shadeName,s.shadePosition,s.shadePriority,s.shadeStatus ");
//        buffer.append("from shadeGroupRelation sgr,shade s where sgr.shadeId=s.shadeId");
//        Session session1 = session.openSession();
//        Query query = session1.createQuery(buffer.toString());
//        List<Object[]> list = query.list();
//        Map<Integer,List<Shade>> groupShadeMap=new HashMap<>();
//        for (Object[] o:list){
//            Integer id = (Integer) o[0];
//            List<Shade> shadeList = groupShadeMap.get(id);
//            if(shadeList==null){
//                shadeList=new ArrayList<>();
//                shadeList.add(new Shade((Integer) o[2],(String) o[3],(Integer) o[4],(Integer) o[5],(String) o[6]));
//            }else {
//                shadeList.add(new Shade((Integer) o[2],(String) o[3],(Integer) o[4],(Integer) o[5],(String) o[6]));
//            }
//            groupShadeMap.put(id,shadeList);
//        }
//        return groupShadeMap;
//    }
}
