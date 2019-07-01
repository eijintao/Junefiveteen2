package com.whhp.test;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.District;
import com.whhp.service.DistrictService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ASUS mjt
 * 2019/6/18
 */
public class DistrictTest {

    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        DistrictService districtServiceImpl =(DistrictService) app.getBean("districtServiceImpl");

        PageInfo<District> districtPageInfo = districtServiceImpl.districtAll(1, 3);

        for (District arg : districtPageInfo.getList()) {
            System.out.println( arg.getName());
        }
    }
}
