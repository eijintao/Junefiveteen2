package com.whhp.controller;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.Users;
import com.whhp.entity.UsersCondition;
import com.whhp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * ASUS mjt
 * 2019/6/24
 */

@Controller
@RequestMapping("/admin/")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("selectUsersAll")
    /**如果没有了 responsebody 那么即使代码正确也是传空指针到jsp页面去的 */
    @ResponseBody
    public Map<String, Object> selectAll(UsersCondition condition){
        //调用业务
        PageInfo<Users> pageInfo=usersService.selectUsersAll(condition);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }



}
