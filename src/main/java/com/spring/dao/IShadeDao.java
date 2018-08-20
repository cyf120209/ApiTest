package com.spring.dao;

import com.spring.bean.Shade;
import entity.DraperInformation;

import java.util.List;

/**
 * Created by lenovo on 2017/10/19.
 */
public interface IShadeDao {

    /**
     * 通过ID查询电机单台电机
     *
     * @param id
     * @return
     */
    Shade queryById(Integer id);

    /**
     * 查询所有
     *
     * @return
     */
    List<Shade> queryAll();
//    List<Shade> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    void identify(Integer id);

    void move(Integer id, Integer cmd);

    void move(Integer id,Integer cmd,Integer cmdService);

    DraperInformation limitAndStopOperation(Integer id, Integer cmd);

    DraperInformation limitAndStopOperation(Integer id, Integer cmd,Integer cmdService);

    DraperInformation getDraperInformation(Integer id);
}
