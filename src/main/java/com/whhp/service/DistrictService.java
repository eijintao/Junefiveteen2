package com.whhp.service;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.District;

import java.util.List;

/**
 * ASUS mjt
 * 2019/6/18
 */
public interface DistrictService {
    /** 查询全部*/
    PageInfo<District>  districtAll(Integer page,Integer pageSize);




    /**
     * //新增
     * @param district
     * @return
     */
    public int addDistrict(District district);



    /**
     * //修改区域
     * @param district
     * @return
     */
    public int updateDistrict(District district);



    /**
     *  //删除
     * @param id
     * @return
     */
    public int deleteDistrict(Integer id);



    /**
     * //删除的批量删除
     * @param ids
     * @return
     */
    public int deleteDistricts(Integer[] ids);

    /**
     *
     * @return
     */
     List<District> getAllDistrict();

}
