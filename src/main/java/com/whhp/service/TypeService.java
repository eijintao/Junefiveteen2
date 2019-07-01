package com.whhp.service;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.District;
import com.whhp.entity.Type;

import java.util.List;

/**
 * ASUS mjt
 * 2019/6/18
 */
public interface TypeService {
     /**查询全部*/
    PageInfo<Type>  typeAll(Integer page, Integer pageSize);


   /** 新增*/
    public int addtype(Type type);

   /** 修改区域*/
    public int updatetype(Type type);

    /**删除*/
    public int deletetype(Integer id);

      /**  删除的批量删除*/
    public int deleteMoreType(Integer[] ids);


    /** 查询所有类型*/
    public List<Type> getAllType();

}
