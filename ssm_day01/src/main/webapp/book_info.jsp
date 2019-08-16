<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/9
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <base href="<%=basepath%>">
    <title>Title</title>
</head>
<body>
<table border="0" width="600px" cellspacing="0" cellpadding="0">
    <tr>
        <td style="width: 80px;">书名:</td>
        <td>${book.book_name}</td>
    </tr>
    <tr>
        <td>出版社:</td>
        <td>${book.public_dept}</td>
    </tr>
    <tr>
        <td>价格:</td>
        <td>${book.book_price}</td>
    </tr>
    <tr>
        <td>出版日期:</td>
        <td>
            <fmt:formatDate value="${book.public_date}" pattern="yyyy-MM-dd"/>
        </td>
    </tr>
    <tr>
        <td>作者:</td>
        <td>${book.book_auth}</td>
    </tr>

    <tr>
        <td>图片:</td>
        <td>
            <img src="${book.img_path  }" width="200px"/>
        </td>
    </tr>

    <tr>
        <td>简介:</td>
        <td>${book.summary}</td>
    </tr>
    <tr>
        <td></td>
        <td>
            <a href="main/allBook?page=${page}">返回</a>
            <a href="main/buy?bookid=${book.bookid}">购买</a>
        </td>
    </tr>
</table>
</body>
</html>
