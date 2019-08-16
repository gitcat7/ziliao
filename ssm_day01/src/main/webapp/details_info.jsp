<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/14
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basepath%>">
    <title>订单详情</title>
</head>
<body>
<form action="" method="post">
    <table>
        <tr>
            <td>订单编号</td>
            <td>${details.detailsId}</td>
        </tr>

        <tr>
            <td>书名</td>
            <td>${details.bookName}</td>
        </tr>

        <tr>
            <td>作者</td>
            <td>${details.bookAuth}</td>
        </tr>

        <tr>
            <td>出版社</td>
            <td>${details.publicDept}</td>
        </tr>

        <tr>
            <td>价格</td>
            <td>${details.bookPrice}</td>
        </tr>

        <tr>
            <td>图片</td>
            <td>
                <img src="${details.imgPath}"/>
            </td>
        </tr>

        <tr>
            <td>简介</td>
            <td>${details.summary}</td>
        </tr>

        <tr>
            <td>
                ${details.orderStatus==0?"需付款":"已付款"}
            </td>
            <td>${details.bookPrice}</td>
        </tr>

        <tr>
            <td>创建时间</td>
            <td>${details.createDate}</td>
        </tr>

        <tr>
            <td></td>
            <td>
                <a href="main/detailsPay?bookid=${details.bookId}&detailsid=${details.detailsId}">去支付</a>
                <a href="main/allBook">返回主页面</a>
                <a href="">返回</a>
            </td>
        </tr>
    </table>
</form>


</body>
</html>
