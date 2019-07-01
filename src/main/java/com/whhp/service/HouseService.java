package com.whhp.service;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.House;

/**
 * ASUS mjt
 * 2019/6/29
 */
public interface HouseService {

    /**
     * fetch data by rule id
     * @param house
     * @return Result
     * 添加出租房
     */
    public int addHouse(House house);

    /**
     * fetch data by rule id  //根据规则id获取数据
     *
     * @param page
     * @param rows
     * @return  Result<House>
     *     查询用户的出租房
     *
     */
    public PageInfo<House>  getUserHouseByPage(Integer page,Integer rows,Integer uid);
}
