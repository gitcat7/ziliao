<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/10
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <base href="<%=basepath%>">
    <title>Title</title>
    <script src="js/jquery-1.12.4.js"></script>
    <script>
        function yue(accid) {
            $.ajax({
                type : "POST",
                url : "main/balance?accid="+accid,
                dataType : "json",
                contentType : "application/x-www-form-urlencoded",
                success : function(data) {
                    var value = parseFloat(data);
                    $("#money").html(value);
                }
            });
        }
    </script>
</head>
<body>
<table width="400px" cellpadding="0" cellspacing="0">
    <tr>
        <td>用户名:</td>
        <td>${myUser.loginname}</td>
    </tr>

    <tr>
        <td>真实姓名:</td>
        <td>${myUser.realname}</td>
    </tr>

    <tr>
        <td>账户:</td>
        <td>
            <select onchange="yue(this.value);" name="account">
                <option value="0">---------请选择账户--------</option>
                <c:forEach items="${list_account}" var="account">
                    <option value="${account.accid}">${account.accname}</option>
                </c:forEach>
            </select>
            余额：<span id="money"></span>
        </td>
    </tr>

    <tr>
        <td>联系方式:</td>
        <td>${myUser.phone}</td>
    </tr>

    <tr>
        <td></td>
        <td>
            <a href="main/allBook?page=${page}">返回</a>
        </td>
    </tr>
</table>
</body>
</html>
