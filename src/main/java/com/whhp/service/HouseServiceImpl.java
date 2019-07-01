package com.whhp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whhp.entity.House;
import com.whhp.mapper.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ASUS mjt
 * 2019/6/29
 */
@Service
public class HouseServiceImpl implements HouseService {

   @Autowired
   private HouseMapper houseMapper;

    @Override
    public int addHouse(House house) {

        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getUserHouseByPage(Integer page, Integer rows, Integer uid) {
        PageHelper.startPage(page,rows);
         //调用dao层查询出租房
        List<House> houses = houseMapper.selectHouseByUserId(uid);

         return new PageInfo<House>(houses);
    }
}
