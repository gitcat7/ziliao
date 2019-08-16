<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/8
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basepath%>">
    <title>登录页面</title>
</head>
<body>

<form action="main/login" method="post">
    用户名:<input type="text" id="loginname" name="loginname" value="zhangsan" />
    <p/>
    密&nbsp;&nbsp;&nbsp;码:<input type="password" id="loginpwd" name="loginpwd" value="123" />
    <p/>
    <input type="submit" value="登 录" />
</form>
</body>
</html>
