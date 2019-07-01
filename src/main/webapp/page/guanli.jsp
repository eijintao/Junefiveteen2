<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   //判断当前用户有没有登入
    Object o =session.getAttribute("user");
    if(o==null){
        out.print("<script>alert('你登陆超时，请你重新登陆，谢谢');location.href='login.jsp';</script>");
    }

%>
<!DOCTYPE>
<!-- saved from url=(0050)http://localhost:8080/HouseRent/manage!list.action -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<TITLE>青鸟租房 - 用户管理</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">

<META name=GENERATOR ></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV>

<DIV class=search> 【欢迎：${user.name}】<LABEL class="ui-green searchs"><a href="gofabu" title="">发布房屋信息</a></LABEL> <LABEL class="ui-green searchs">
  <a href="${pageContext.request.contextPath}/page/getUserHouse" title="">管理房屋信息</a></LABEL>
<LABEL class=ui-green><INPUT onclick='document.location="index.jsp"' value="退       出" type=button name=search></LABEL> 
</DIV></DIV>
<DIV class="main wrap">
<DIV id=houseArea>
<TABLE class=house-list>
   <TBODY>
   <c:forEach items="${pageInfo.list}" var="h">
  <TR>
    <TD class=house-thumb><SPAN>
      <A href="details.jsp" target="_blank">
        <img src="../images/thumb_house.gif" width="100" height="75" alt=""></A>
    </SPAN>
    </TD>
    <TD>
      <DL>
        <DT><A href="details.jsp" target="_blank">${h.title}</A></DT>
        <DD>${h.dname}区${h.sname},${h.floorage}平米，户型:${h.tname}<BR>联系方式：${h.contact} </DD></DL></TD>
    <TD class=house-type><LABEL class=ui-green><INPUT onclick=update(46) value="修    改" type=button name=search></LABEL></TD>
    <TD class=house-price><LABEL class=ui-green><INPUT value="删    除" type=button name=search>
    </LABEL></TD>
  </TR>
   </c:forEach>

   </TBODY>
</TABLE>

</DIV>
<DIV class=pager>
<UL>
  <c:forEach begin="1" end="${pageInfo.pages}" var="h" step="1">
  <LI class=current><A id=widget_338868862 
  href="getUserHouse?page=${h}"
  parseContent="true" showError="true" targets="houseArea" 
  ajaxAfterValidation="false" validate="false" 
dojoType="struts:BindAnchor">${h}</A>
   </LI>
  </c:forEach>

  </UL><SPAN class=total>${pageInfo.pageNum}/${pageInfo.pages}页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
