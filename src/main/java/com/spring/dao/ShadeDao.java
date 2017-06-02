package com.spring.dao;

import com.spring.bean.Shade;
import com.spring.service.IShadeDao;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by lenovo on 2017/5/12.
 */
public class ShadeDao implements IShadeDao{

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Shade> getShadeList(List<Integer> idList, List<String> nameList, Integer priotity, String status) {
        StringBuffer buffer=new StringBuffer(1024);
        buffer.append("from shade");
//        buffer.append(" where id=1");
        String sql=buffer.toString();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(sql);
        return query.list();
    }
}
