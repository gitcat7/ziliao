<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/14
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <base href="<%=basepath%>">
    <title>订单页面</title>
</head>
<body>
<form action="main/order" method="post">
    <input type="hidden" value="${book.bookid}" name="bookid" />
    <table width="500px">
        <tr>
            <td width="100px">书名</td>
            <td>${book.book_name}</td>
        </tr>

        <tr>
            <td valign="top">简介</td>
            <td>${book.summary}</td>
        </tr>

        <tr>
            <td>购买数量</td>
            <td>1</td>
        </tr>

        <tr>
            <td>
                共1件 小计:
            </td>
            <td>
                <fmt:formatNumber value="${book.book_price}" type="currency" pattern="￥.00"/>
            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="提交订单" />
            </td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>
