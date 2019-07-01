package com.whhp.controller;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.District;
import com.whhp.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * ASUS mjt
 * 2019/6/18
 */
@Controller
@RequestMapping("/admin/")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("districtAll")
    @ResponseBody
    public Map<String,Object> districtAll(Integer page,Integer rows){
        PageInfo<District> districtPageInfo = districtService.districtAll(page, rows);

        Map<String,Object> map=new HashMap<>();
        map.put("total",districtPageInfo.getTotal());
        map.put("rows",districtPageInfo.getList());

        return map;

    }

    @RequestMapping("addDistrict")
    @ResponseBody
    public  String addDistrict(District district){

        int i = districtService.addDistrict(district);

        return " {\"result\":"+i+"}";//因为使用了ResponseBody 所以这里返回不是什么url
        //  而是json数据。
    }

    @RequestMapping("updateDistrict")
    @ResponseBody
    public String updateDistrict(District district){
        int i = districtService.updateDistrict(district);

        return " {\"result\":"+i+"}";//因为使用了ResponseBody 所以这里返回不是什么url
        //  而是json数据。

    }

    @RequestMapping("deleteDistrict")
    @ResponseBody
    public String deleteDistrict(Integer id){
        int i = districtService.deleteDistrict(id);

        return " {\"result\":"+i+"}";//因为使用了ResponseBody 所以这里返回不是什么url
        //  而是json数据。

    }
    //批量删除多个
    @RequestMapping("deleteMoreDistrict")
    @ResponseBody
    public String deleteMoreDistrict(String ids){/* id传的是字符串 {1,2,3,...} */
        //将字符串转化成数组
        String[] arrays = ids.split(",");
        Integer[] id=new Integer[arrays.length];
        for (int i = 0; i < arrays.length ; i++) {
              id[i]=Integer.parseInt(arrays[i]);
        }

        int i = districtService.deleteDistricts(id);

        return " {\"result\":"+i+"}";//因为使用了ResponseBody 所以这里返回不是什么url
        //  而是json数据。

    }


}
