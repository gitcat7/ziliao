<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/14
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <base href="<%=basepath%>">
    <title>我的订单</title>
</head>
<body>
    <table align="center" border="1" cellpadding="0" cellspacing="0" width="800px">
        <tr>
            <td>商品名称</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${allOrder}" var="order">
            <tr>
                <td>${order.bookName}</td>
                <td>
                    <a href="main/details?orderId=${order.orderId}">详情</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
