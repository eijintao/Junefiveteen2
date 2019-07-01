<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/6/18
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>前端框架之二</title>

    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css"/>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/users.js"></script>

</head>
<body>
<%--展示数据--%>
<table id="dg"></table>

<!--定义工具栏-->
<div id="ToolBar">
    <div style="height: 40px;">
        <a href="javascript:Add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>
        <a
                href="javascript:ModifyBySelect()" class="easyui-linkbutton"
                iconCls="icon-edit" plain="true">修改</a>
        <a
                href="javascript:DeleteMore()" class="easyui-linkbutton"
                iconCls="icon-remove" plain="true">删除选中项</a>
    </div>
    <%--搜索条件--%>
    <div>
        电话本：<input type="text" name="tel" id="tel">
        开始年龄：<input type="text" name="starAge" id="starAge">
        结束年龄：<input type="text" name="endAge" id="endAge">
        <a id="btn" href="javascript:searchUser();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
    </div>

</div>

<!--添加窗口-->
<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="saveDialogForm" method="post">
        <table>

            <tr>
                <td>名称 :</td>
                <td><input type="text" name="name" id="author" /></td>
            </tr>

        </table>
    </form>
</div>

<!--给添加对话框添加按钮-->
<div id="AddDialogButtons">
    <a href="javascript:SaveDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>

<%--修改对话框--%>
<div id="upDialog" class="easyui-dialog" buttons="#upDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="upDialogForm" method="post">
        <table>
            <tr>
                <td>编号 :</td>
                <td><input type="text" readonly  name="id" id="author" /></td>
            </tr>
            <tr>
                <td>名称 :</td>
                <td><input type="text" name="name" id="author" /></td>
            </tr>

        </table>
    </form>
</div>

<%--给修改对话框添加修改按钮--%>
<div id="upDialogButtons">
    <a href="javascript:upDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">修改</a>
    <a href="javascript:CloseDialog2()"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>


</body>
</html>
