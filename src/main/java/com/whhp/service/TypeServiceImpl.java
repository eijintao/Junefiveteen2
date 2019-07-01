package com.whhp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whhp.entity.District;
import com.whhp.entity.DistrictExample;
import com.whhp.entity.Type;
import com.whhp.entity.TypeExample;
import com.whhp.mapper.DistrictMapper;
import com.whhp.mapper.StreetMapper;
import com.whhp.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ASUS mjt
 * 2019/6/18
 */

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public PageInfo<Type> typeAll(Integer page, Integer pageSize) {
        //启用分页
        PageHelper.startPage(page, pageSize);
        //创建 条件实体
        TypeExample example=new TypeExample();
        //2.获得criteria对象添加条件
        //DistrictExample.Criteria criteria=example.createCriteria();
        //criteria.andNameLike("%东%");

        //调用查询全部的方法
        List<Type> typeList = typeMapper.selectByExample(example);


        return  new PageInfo<>(typeList);
    }

    @Override
    public int addtype(Type type) {
        return typeMapper.insert(type);
    }

    @Override
    public int updatetype(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type);
    }

    @Override
    public int deletetype(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Type> getAllType() {


        return typeMapper.selectByExample(new TypeExample());
    }

    @Override
    public int deleteMoreType(Integer[] ids) {
        return typeMapper.deleteMoreType(ids);
    }
}
