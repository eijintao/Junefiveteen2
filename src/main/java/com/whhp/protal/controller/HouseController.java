package com.whhp.protal.controller;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.District;
import com.whhp.entity.House;
import com.whhp.entity.Type;
import com.whhp.entity.Users;
import com.whhp.service.DistrictService;
import com.whhp.service.HouseService;
import com.whhp.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.commons.CommonsMultipartFile;



import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

/**
 * ASUS mjt
 * 2019/6/28
 */
@Controller
@RequestMapping("/page/")
public class HouseController {

    @Autowired
    private TypeService typeService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private HouseService houseService;

    @RequestMapping("gofabu")
    public String gofabu(Model model){
        //查询所有类型
        List<Type> allType = typeService.getAllType();

        //查询所有区域
        List<District> allDistrict = districtService.getAllDistrict();

        //传域
        model.addAttribute("type",allType);
        model.addAttribute("district",allDistrict);


        //跳转
        return "fabu";
    }



    @RequestMapping("addHouse")
    public String addHouse(House house, @RequestParam(value="pfile" ,required = false) CommonsMultipartFile pfile, HttpSession session)throws IOException {
        //将文件保存在服务器中
        String originalFilename = pfile.getOriginalFilename();

        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String s = System.currentTimeMillis() + substring;//保存文件名
       File file=new File("C:\\Users\\ASUS\\Pictures\\Saved Pictures" + s);

        //FileCopyUtils.copy(pfile.getBytes(),file);//保存
        pfile.transferTo(file);

        //保存数据库的记录  house已经接收部分表单数据
        //设置编号
        house.setId(System.currentTimeMillis()+"");
        //设置用户编号    session保存的事件有限，所以当 用户 重启/过了预定时间后，只有重新登陆后才能处理操作

        Users user=(Users)session.getAttribute("user");

        house.setUserId(user.getId());
        System.out.println("user = " + user);

        //设置审核状态 0  如果表中有默认值 可不设
        house.setIspass(0);
        //设置是否删除  0
        house.setIsdel(0);
        //设置图片路径
        house.setPath(s);

        if(houseService.addHouse(house)>0){ //保存数据
            //调用业务
            //houseService.addHouse(house); //添加信息到数据库
            return "redirect:gofabu";  //跳转页面
        }
        else{
            //成功上传的图片删除
            file.delete();
            return "redirect:gofabu";  //跳转页面
        }
    }
    //查询出租房   用户id在session中
    //page 表示页面传的页码
    @RequestMapping("getUserHouse")
    public String getUserHouse(Integer page,HttpSession session,Model model) throws  Exception{
        //调用业务
        Users user=(Users)session.getAttribute("user");
        PageInfo<House> pageInfo=houseService.getUserHouseByPage(page==null?1:page,1,user.getId());
        //将分页信息填充到作用域
        model.addAttribute("pageInfo",pageInfo);
        return "guanli";//管理
    }

}
