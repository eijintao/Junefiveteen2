package com.whhp.controller;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.Street;
import com.whhp.entity.Users;
import com.whhp.entity.UsersCondition;
import com.whhp.service.StreetService;
import com.whhp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ASUS mjt
 * 2019/6/24
 */

@Controller
@RequestMapping("/admin/")
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("selectStreetAll")
    @ResponseBody
    /** 这里是rows 不是pageSize  但是在实现类里面是pageSize  */
    public Map<String, Object> selectAll(Integer page,Integer rows,Integer did){
        //调用业务
        PageInfo<Street> pageInfo=streetService.selectStreetAll(page,rows,did);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }




}
