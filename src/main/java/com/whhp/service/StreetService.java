package com.whhp.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.whhp.entity.Street;

import java.util.List;

/**
 * @author 梅锦涛
 * ASUS mjt
 * 2019/6/24
 */
public interface StreetService {

   /** 通过区域显示街道*/
    PageInfo<Street> selectStreetAll(Integer page,Integer pageSize, Integer districtId);

    /**
     * 通过区域显示街道
     */
    List<Street> selectStreetAll(Integer districtId);
}
