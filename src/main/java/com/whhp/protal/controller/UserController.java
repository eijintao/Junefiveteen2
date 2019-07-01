package com.whhp.protal.controller;

import com.whhp.entity.Users;
import com.whhp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * ASUS mjt
 * 2019/6/25
 */
@Controller
@RequestMapping("/page/")
public class UserController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("checkUname")
    @ResponseBody
    public String  checkUname(String username){
        //调用业务;
        int i = usersService.checkUname(username);
        /** 返回的是json */
        return "{\"result\":"+i+"}";

    }

    @RequestMapping("addUname")
    public String  addUname(Users users){
        //调用业务;
        int i = usersService.addUser(users);
        /** 返回的是json */
        if(i>0) {
            return "login";
        }
        else {
            return "error";
        }
    }

    @RequestMapping("loginUname")
    public String  loginUname(String username, String password, Model model, HttpSession session){
        //调用业务;
        Users login = usersService.login(username, password);
        /** 返回的是json */
        if(login==null) {

            model.addAttribute("info","用户名密码错误");
            //如果login为空   意思就是失败之后继续登陆。
            return "login";
        }
        else {
            //用户中心的管理页  就是登陆成功后转到那个页面
            //只要登入：使用session 或者cookie保存登入人的信息
          session.setAttribute("user",login);
          //设置session域的保存时间
          session.setMaxInactiveInterval(600);
            return "guanli";
        }
    }
}
