package com.whhp.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whhp.entity.District;
import com.whhp.entity.DistrictExample;
import com.whhp.mapper.DistrictMapper;
import com.whhp.mapper.StreetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ASUS mjt
 * 2019/6/18
 */

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;

    //增加
    @Override
    public int addDistrict(District district) {
        int v = districtMapper.insertSelective(district);

        return  v;
    }

    //修改
    @Override
    public int updateDistrict(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }
   //删除的批量删除
    @Override
    public int deleteDistricts(Integer[] ids) {
        return districtMapper.deleteDistricts(ids);
    }

    //删除
    @Override
    @Transactional
    public int deleteDistrict(Integer id) {
        try {
            //删除街道
            streetMapper.deleteStreetByDId(id);
            //删除区域
            districtMapper.deleteByPrimaryKey(id);
            //如果正确返回1，如果错误返回0；
            return 1 ;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<District> getAllDistrict() {
        return districtMapper.selectByExample(new DistrictExample());
    }

    //查询和分页
    @Override
    public PageInfo<District> districtAll(Integer page, Integer pageSize) {
        //启用分页
         PageHelper.startPage(page, pageSize);
        //创建 条件实体
        DistrictExample example=new DistrictExample();
        //2.获得criteria对象添加条件
        //DistrictExample.Criteria criteria=example.createCriteria();
        //criteria.andNameLike("%东%");

        //调用查询全部的方法
        List<District> districts = districtMapper.selectByExample(example);



        return  new PageInfo<>(districts);
    }
}
