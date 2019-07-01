package com.whhp.service;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.Users;
import com.whhp.entity.UsersCondition;

/**
 * ASUS mjt
 * 2019/6/24
 */
public interface UsersService {

    /**查询所有用户*/
    PageInfo<Users> selectUsersAll(UsersCondition condition);

    /** 检查用户名是否存在 所以传参的是  用户名。 返回的是 有或者没有*/
    public int checkUname(String username);


    /** 添加用户名  注册*/
    public int addUser(Users users);

    /** 实现登陆  */
    public Users login(String username,String password);



}
