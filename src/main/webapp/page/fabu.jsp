﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514">
<script language="JavaScript" src="../admin/js/jquery-1.8.3.js"></script>
  <script language="JavaScript">
    $(function () {//加载
        //网页加载完显示
        showStreet($("#district").val());

        //给区域添加改变事件，显示对应的街道
        $("#district").change(function () {
             //获取区域的id  去后台查询对应的街道
               var did=$(this).val();
                //发送异步请求获取街道
            showStreet(did);

        });
    });

    function showStreet(did) {
        $.post("selectStreetAll2",{"did":did},function (data) {
            $("#streetId>option").remove();//清空选项
            for (var i = 0; i < data.length; i++) {
                //创建一个dom节点
                var options = $("<option value="+data[i].id+">"+data[i].name+"</option>");
                $("#streetId").append(options);//追加节点

            }

        },"json");

    }


  </script>
</HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新房屋信息发布</DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>
<FORM id=add_action method=post name=ss action="../page/addHouse"  enctype="multipart/form-data">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>标　　题：</TD>
    <TD><INPUT id=add_action_title class=text type=text name=title> </TD></TR>
  <TR>
    <TD class=field>户　　型：</TD>
    <TD><SELECT class=text name=typeId>
        <c:forEach items="${type}" var="t" >
          <option value="${t.id}">${t.name}</option>
        </c:forEach>
        </SELECT>
    </TD>
  </TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage class=text type=text 
name=floorage></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text type=text name=price> </TD></TR>
  <TR>
    <TD class=field>房产证日期：</TD>
    <TD><INPUT class=text type=date name=pubdate></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    <TD>区：<%-- name的属性必须要跟实体类中的字段名一致。毕竟实体类的字段名 在Mapper映射里面已经
            映射好了，它自己对应的数据库中的字段--%>
           <SELECT class=text id="district" name=district_id>
             <c:forEach items="${district}" var="d" >
               <option value="${d.id}">${d.name}</option>
             </c:forEach>
           </SELECT>
        街：
           <SELECT id="streetId" class=text name=streetId>
                   <OPTION selected value=1001>请选择街道</OPTION>
           </SELECT>
    </TD>
  </TR>
  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact class=text type=text name=contact> </TD></TR>
  <TR>
    <TD class=field>图片：</TD>
    <TD><INPUT id=sss class=text type=file  name="pfile"> </TD></TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=description></TEXTAREA></TD></TR></TBODY></TABLE>
<DIV class=buttons>
  <INPUT  value=立即发布 name="dd" type="submit">
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
