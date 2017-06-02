package com.spring.service;

import com.spring.bean.Shade;
import com.spring.dao.ShadeDao;

import java.util.List;

/**
 * Created by lenovo on 2017/5/3.
 */
public class ShadeReal implements IShadeDao {

    private ShadeDao shadeDao;

    public ShadeDao getShadeDao() {
        return shadeDao;
    }

    public void setShadeDao(ShadeDao shadeDao) {
        this.shadeDao = shadeDao;
    }

    @Override
    public List<Shade> getShadeList(List<Integer> idList, List<String> nameList, Integer priotity, String status) {
        List<Shade> shadeList = shadeDao.getShadeList(idList,nameList,priotity,status);
        return shadeList;
    }
}
