package com.spring.service;

import com.spring.bean.DraperEntity;
import com.spring.bean.Shade;
import com.spring.dao.IShadeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by lenovo on 2017/3/21.
 */
@Service
public class ShadeServiceImpl implements IShadeService{

    @Autowired
    private IShadeDao iShadeDao;

//    private IShadeService IShadeService =new ShadeCache();

//    public void setIShadeDao(IShadeService IShadeService) {
//        this.IShadeService = IShadeService;
//    }

//

    /**
     * 获取电机列表
     * @return
     */
//    @Transactional
//    public List<Shade> getShadeList(){
//        return shadeDao.getShadeList(null,null,null,null);
//    }

    /**
     * 移动操作
     * @param draperEntity
     */
    public void move(DraperEntity draperEntity){
    }

//    @Override
    public Shade queryById(Integer id) {
        return null;
    }

//    @Override
    public List<Shade> queryAll(int offset, int limit) {
        return null;
    }

    @Override
    public List<Shade> getShadeList(List<Integer> idList, List<String> nameList, Integer priotity, String status) {
        return null;
    }

    @Override
    public Shade getById(Integer id) {
        return iShadeDao.queryById(id);
    }

    @Override
    public List<Shade> getAll() {
        return iShadeDao.queryAll();
    }
}
