<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/12
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                success : function(data) {
                    var value = parseFloat(data);
                    $("#money").html(value);
                }
            });
        }
    </script>
</head>
<body>
<form action="main/pay" method="post">
    <input type="hidden" name="bookid" value="${book.bookid}" />
    <input type="hidden" value="${detailsId}" name="detailsId" />
    书名:${book.book_name}<br/>
    单价:${book.book_price}<br/>
    账户:
    <select onchange="yue(this.value);" name="accid">
        <option value="0">---------请选择账户--------</option>
        <c:forEach items="${list_account}" var="account">
            <option value="${account.accid}">${account.accname}</option>
        </c:forEach>
    </select>
    余额：
    <span id="money"></span>
    <br/>
    <input type="submit" value="支 付" />
</form>
</body>
</html>
