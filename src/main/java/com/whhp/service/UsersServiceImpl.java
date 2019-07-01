package com.whhp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whhp.entity.Users;
import com.whhp.entity.UsersCondition;
import com.whhp.entity.UsersExample;
import com.whhp.mapper.UsersMapper;
import com.whhp.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ASUS mjt
 * 2019/6/24
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int addUser(Users users) {
        /** 设置为前台注册用户
         * 如果是后台注册用户  那就是 users.setIsadmin(0);
         * */
        users.setIsadmin(0);
        /**
         * 对用户的密码使用MD5加密
         * 做项目的时候一定要考虑密码的加密
         * */
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));


        return usersMapper.insertSelective(users);
    }
          /** 实现登陆*/
    @Override
    public Users login(String username, String password) {
        /* 以下五行代码  其实就是编写并执行一个  sql 语句。
          * select * from users where name=? and  password=?
           * 它是自己拼接的。*/

        //写持久化操作
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        //这是在写条件进行查询，所以接下来就是添加条件

        //andIsadminEqualTo 这一句可要可不要。
        criteria.andIsadminEqualTo(0);
        criteria.andNameEqualTo(username);
        //加密码
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));

        List<Users> users = usersMapper.selectByExample(example);
        if(users.size()==1){
             return users.get(0);
        }
        return null;
    }

    /** 检查用户名是否存在 所以传参的是  用户名。 返回的是 有或者没有*/
    @Override
    public int checkUname(String username) {
        //写持久化操作
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        //这是在写条件进行查询，所以接下来就是添加条件

        //注册用户
        criteria.andNameEqualTo(username);
        criteria.andIsadminEqualTo(0);


        List<Users> users = usersMapper.selectByExample(example);
        //这个是在判断返回的用户名有没有。
        return users.size()==0?0:1;
    }

    @Override
    public PageInfo<Users> selectUsersAll(UsersCondition condition) {
        //查询所有
        PageHelper.startPage(condition.getPage(),condition.getRows());
        UsersExample example=new UsersExample();
        //添加条件
        UsersExample.Criteria criteria=example.createCriteria();
        //表示管理员
        criteria.andIsadminEqualTo(new Integer(1));
         //添加查询条件

        if (condition.getTelephone()!=null){
           criteria.andTelephoneLike("%"+condition.getTelephone()+"%");
        }
        /*大于*/
        if (condition.getStarAge()!=null){
            criteria.andAgeGreaterThan(condition.getStarAge());
        }
        /*小于*/
        if (condition.getEndAge()!=null){
            criteria.andAgeLessThan(condition.getEndAge());
        }

        List<Users> users = usersMapper.selectByExample(example);
        PageInfo<Users> pageInfo=new PageInfo<>(users);

        return pageInfo;
    }
}
