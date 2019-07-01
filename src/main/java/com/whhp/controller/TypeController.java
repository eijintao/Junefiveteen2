package com.whhp.controller;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.District;
import com.whhp.entity.Type;
import com.whhp.service.DistrictService;
import com.whhp.service.TypeService;
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
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("typeAll")
    @ResponseBody
    public Map<String,Object> typeAll(Integer page,Integer rows){
        PageInfo<Type> typePageInfo = typeService.typeAll(page, rows);

        Map<String,Object> map=new HashMap<>();
        map.put("total",typePageInfo.getTotal());
        map.put("rows",typePageInfo.getList());

        return map;

    }

    @RequestMapping("addType")
    @ResponseBody
    public  String addType(Type type){

        int i = typeService.addtype(type);

        return " {\"result\":"+i+"}";//因为使用了ResponseBody 所以这里返回不是什么url
        //  而是json数据。
    }

    @RequestMapping("updateType")
    @ResponseBody
    public String updateType(Type type){
        int i = typeService.updatetype(type);

        return " {\"result\":"+i+"}";//因为使用了ResponseBody 所以这里返回不是什么url
        //  而是json数据。

    }

    @RequestMapping("deleteType")
    @ResponseBody
    public String deleteType(Integer id){
        int i = typeService.deletetype(id);

        return " {\"result\":"+i+"}";//因为使用了ResponseBody 所以这里返回不是什么url
        //  而是json数据。

    }
    //批量删除多个
    @RequestMapping("deleteMoreType")
    @ResponseBody
    public String deleteMoreType(String ids){/* id传的是字符串 {1,2,3,...} */
        //将字符串转化成数组
        String[] arrays = ids.split(",");
        Integer[] id=new Integer[arrays.length];
        for (int i = 0; i < arrays.length ; i++) {
              id[i]=Integer.parseInt(arrays[i]);
        }

        int i = typeService.deleteMoreType(id);

        return " {\"result\":"+i+"}";//因为使用了ResponseBody 所以这里返回不是什么url
        //  而是json数据。

    }


}
