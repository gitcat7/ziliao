<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/13
  Time: 15:03
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
    <title>出错了</title>
    <style>
        div{
            display: inline-block;
            color: red;
        }
    </style>
    <script src="js/jquery-1.12.4.js"></script>
    <script>
        $(function(){
           if("${login_err}".length>0){
               $("a").attr("href","login.jsp");
               pub("${login_err}","登录页面...","login.jsp");
           } else if ("${add_err}".length>0){
               $("a").attr("href","main/allBook");
               pub("${add_err}","主页面","main/allBook")
           } else if ("${bal_err}".length>0) {
               $("a").attr("href","main/allBook");
               pub("${bal_err}","主页面","main/allBook")
           } else if ("${pay_err}".length>0) {
               $("a").attr("href","main/allBook");
               pub("${pay_err}","主页面","main/allBook")
           } else if("${sto_err}".length>0){
               $("a").attr("href","main/allBook");
               pub("${sto_err}","主页面","main/allBook")
           }
        });

        //倒计时跳转
        function pub(errInfo,tishi,page){
            $("#div1").html(errInfo);
            $("#div2").html(tishi);
            setInterval(time,1000);
            function time(){
                var value = $("span").html();
                console.log(value);
                $("span").html(parseInt(value)-1);
                if(parseInt($("span").html())<=1){
                    window.location.href=page;
                }
            }
        }

    </script>
    <div id="div1"></div>
    <span>3</span>秒后返回
    <div id="div2"></div>,或者直接<a href="">前往</a>
</head>
<body>

</body>
</html>
