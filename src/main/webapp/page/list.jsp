﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <FORM id=sform method=post action=search.action>
  <DT>
  <UL>
    <LI class=bold>房屋信息</LI>
    <LI>标题：<INPUT class=text type=text name=title> <LABEL class=ui-blue><INPUT onclick=doSearch() value=搜索房屋 type=button name=search></LABEL> 
    </LI></UL></DT>
  <DD>
  <UL>
    <LI class=first>价格 </LI>
    <LI><SELECT name=price> <OPTION selected value="">不限</OPTION> <OPTION 
      value=0-100>100元以下</OPTION> <OPTION value=100-200>100元—200元</OPTION> 
      <OPTION value=200-1000000>200元以上</OPTION></SELECT> </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>房屋位置</LI>
    <LI><SELECT id=street name=street_id> <OPTION selected 
      value="">不限</OPTION> <OPTION value=1000>知春路</OPTION> <OPTION 
      value=1001>中关村大街</OPTION> <OPTION value=1002>学院路</OPTION> <OPTION 
      value=1003>朝阳路</OPTION></SELECT> </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>房型</LI>
    <LI><SELECT name=type_id> <OPTION selected value="">不限</OPTION> <OPTION 
      value=1000>一室一厅</OPTION> <OPTION value=1001>一室两厅</OPTION> <OPTION 
      value=1002>两室一厅</OPTION> <OPTION value=1003>两室两厅</OPTION></SELECT> 
  </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>面积 </LI>
    <LI><SELECT name=floorage> <OPTION selected value="">不限</OPTION> <OPTION 
      value=0-40>40以下</OPTION> <OPTION value=40-500>40-500</OPTION> <OPTION 
      value=500-1000000>500以上</OPTION></SELECT> </LI></UL></DD></FORM></DL></DIV>
<DIV class="main wrap">
<TABLE class=house-list>
  <TBODY>
  <TR>
    <TD class=house-thumb><span><A href="details.jsp" target="_blank"><img src="../images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>
    <TD>
      <DL>
        <DT><A href="details.jsp" target="_blank">尽快回家</A></DT>
        <DD>海淀区中关村大街,346平米<BR>联系方式：3456 </DD></DL></TD>
    <TD class=house-type>一室一厅</TD>
    <TD class=house-price><SPAN>346.0</SPAN>元/月</TD></TR>
  <TR class=odd>
    <TD class=house-thumb><span><A href="details.jsp" target="_blank"><img src="../images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>
    <TD>
      <DL>
        <DT><A href="details.jsp" target="_blank">大房子</A></DT>
        <DD>海淀区中关村大街,100平米<BR>联系方式：123456789 </DD></DL></TD>
    <TD class=house-type>一室一厅</TD>
    <TD class=house-price><SPAN>230.0</SPAN>元/月</TD></TR>
  <TR>
    <TD class=house-thumb><span><A href="details.jsp" target="_blank"><img src="../images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>
    <TD>
      <DL>
        <DT><A href="details.jsp" target="_blank">123</A></DT>
        <DD>海淀区中关村大街,123平米<BR>联系方式：123 </DD></DL></TD>
    <TD class=house-type>一室一厅</TD>
    <TD class=house-price><SPAN>123.0</SPAN>元/月</TD></TR>
  <TR class=odd>
    <TD class=house-thumb><span><A href="details.jsp" target="_blank"><img src="../images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>
    <TD>
      <DL>
        <DT><A href="details.jsp" target="_blank">jjjj</A></DT>
        <DD>海淀区中关村大街,123平米<BR>联系方式：ff </DD></DL></TD>
    <TD class=house-type>一室一厅</TD>
    <TD class=house-price><SPAN>123.0</SPAN>元/月</TD></TR>
  <TR>无租房信息</TR></TBODY></TABLE>
<DIV class=pager>
<UL>
  <LI class=current><A href="#">首页</A></LI>
  <LI><A href="#">上一页</A></LI>
  <LI><A href="#">下一页</A></LI>
  <LI><A href="#">末页</A></LI></UL><SPAN 
class=total>1/2页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
