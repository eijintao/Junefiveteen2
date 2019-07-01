package com.whhp.protal.controller;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.Street;
import com.whhp.service.StreetService;
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
 * @author 梅锦涛
 */

@Controller("steetController2")
@RequestMapping("/page/")
public class StreetController {
    @Autowired
    private StreetService streetService;



    @RequestMapping("selectStreetAll2")
    @ResponseBody

    public List<Street>  selectAll2(Integer did){
        //调用业务
      return  streetService.selectStreetAll(did);
    }




}
