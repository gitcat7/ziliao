<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/9
  Time: 19:40
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
    <title>Title</title>
    <script src="js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form action="main/createBook" method="post" enctype="multipart/form-data">
    <table border="1" width="600px" cellspacing="0" cellpadding="0">
        <tr>
            <td style="width: 80px;">书名:</td>
            <td>
                <input type="text" name="book_name" value="暗室逢灯" />
            </td>
        </tr>
        <tr>
            <td>出版社:</td>
            <td>
                <input type="text" name="public_dept" value="去玩儿" />
            </td>
        </tr>
        <tr>
            <td>价格:</td>
            <td>
                <input type="text" name="book_price" value="11"/>
            </td>
        </tr>
        <tr>
            <td>出版日期:</td>
            <td>
                <input type="text" name="public_date" onClick="WdatePicker()" readonly="readonly" />
            </td>
        </tr>
        <tr>
            <td>作者:</td>
            <td>
                <input type="text" name="book_auth" value="张三"/>
            </td>
        </tr>
        <tr>
            <td>图片:</td>
            <td>
                <input type="file" name="img" />
            </td>
        </tr>
        <tr>
            <td>简介:</td>
            <td>
                <textarea name="summary" id="summary">按时发撒的发</textarea>
            </td>
        </tr>
        <tr>
            <td>库存:</td>
            <td>
                <input type="number" name="count" value="12" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="提 交" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
