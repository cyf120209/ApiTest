package com.spring.dao;

import com.spring.bean.Shade;
import org.apache.ibatis.annotations.Param;

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
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return
     */
    List<Shade> queryAll();
//    List<Shade> queryAll(@Param("offset") int offset, @Param("limit") int limit);

}
