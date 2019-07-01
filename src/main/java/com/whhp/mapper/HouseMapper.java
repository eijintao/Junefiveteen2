package com.whhp.mapper;

import com.whhp.entity.House;
import com.whhp.entity.HouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseMapper {
    int countByExample(HouseExample example);

    int deleteByExample(HouseExample example);

    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") House record, @Param("example") HouseExample example);

    int updateByExample(@Param("record") House record, @Param("example") HouseExample example);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    /**
     *fetch data by rule id  //根据规则id获取数据
     *
     * @param uid
     * @return
     */
    List<House> selectHouseByUserId(Integer uid);
}