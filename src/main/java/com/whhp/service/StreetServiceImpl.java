package com.whhp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whhp.entity.Street;
import com.whhp.entity.StreetExample;
import com.whhp.mapper.StreetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ASUS mjt
 * 2019/6/24
 */
@Service
public class StreetServiceImpl implements StreetService {

    @Autowired
    private StreetMapper streetMapper;

    @Override
    public List<Street> selectStreetAll(Integer districtId) {
        StreetExample example=new StreetExample();
        StreetExample.Criteria criteria=example.createCriteria();
        //传条件
        criteria.andDistrictIdEqualTo(districtId);

        List<Street> streets = streetMapper.selectByExample(example);

        return streets;
    }

    @Override
    public PageInfo<Street> selectStreetAll(Integer page, Integer rows, Integer districtId) {
        PageHelper.startPage(page,rows);
        //查询街道
        StreetExample example=new StreetExample();
        StreetExample.Criteria criteria=example.createCriteria();
        //传条件
        criteria.andDistrictIdEqualTo(districtId);

        List<Street> streets = streetMapper.selectByExample(example);
        return new PageInfo<>(streets);
    }
}
