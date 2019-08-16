<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/8
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <base href="<%=basepath%>">
    <title>主页面</title>
    <link href="css/common.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-1.12.4.js"></script>
    <script src="js/jquery.pagination.js"></script>
</head>
<body>
<h1 id="welcome">登录成功!,欢迎您:${myUser.realname}</h1>
<a id="info" href="main/uinfo?uid=${myUser.userid}&page=${page}">个人信息</a>
<a id="exit" href="javascript:logout();">退出</a>
<a id="add" href="main/add">添加书籍</a>
<table align="center" border="1" cellpadding="0" cellspacing="0" width="800px">
    <tr align="center">
        <td>编号</td>
        <td>书名</td>
        <td>出版社</td>
        <td>单价</td>
        <td>出版日期</td>
        <td>作者</td>
        <td>库存</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${allBook}" var="book">
        <c:if test="${book.storeHouse.book_count>0}">
            <tr align="center">
                <td>${book.bookid}</td>
                <td>${book.book_name}</td>
                <td>${book.public_dept}</td>
                <td>${book.book_price}</td>
                <td>
                    <fmt:formatDate value="${book.public_date}" pattern="yyyy-MM-dd"/>
                </td>
                <td>${book.book_auth}</td>
                <td>${book.storeHouse.book_count}</td>
                <td>
                    <a href="main/binfo?bookName=${book.book_name}&page=${page}">详情</a>
                    <a href="main/buy?bookid=${book.bookid}">购买</a>
                </td>
            </tr>
        </c:if>
    </c:forEach>
</table>
<form style="text-align: center;" name="mySplitForm" id="mySplitForm" action="" method="post">
    <input type="button" value="首页" onclick="prev('2')" ${page==1?"disabled":""} />
    <input type="button" value="上一页" onclick="prev('${page}')" ${page==1?"disabled":""} />
    <input type="button" value="下一页" onclick="next('${page}')" ${page==totle?"disabled":""} />
    <input type="button" value="尾页" onclick="next('${totle-1}')" ${page==totle?"disabled":""} />
</form>
<script>
    $(function(){
        var myuser = "${myUser}";
        if(myuser==null||myuser==""){
            $("#welcome").css("display","none");
            $("#info").css("display","none");
            $("#exit").css("display","none");
            $("#add").css("display","none");
        }
    })
    function prev(page) {
        $("#mySplitForm").attr("action","main/allBook?page="+(parseInt(page)-1));
        mySplitForm.submit();
    }
    function next(page){
        $("#mySplitForm").attr("action","main/allBook?page="+(parseInt(page)+1));
        mySplitForm.submit();
    }
    function logout(){
        $.ajax({
            type : "POST",
            url : "main/out",
            dataType : "json",
            success : function(data) {
                if(data>0){
                    $("#welcome").css("display","none");
                    $("#info").css("display","none");
                    $("#exit").css("display","none");
                    $("#add").css("display","none");
                }
            }
        });
    }
</script>
</body>
</html>
