<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%  String path = request.getContextPath();
    String basePath =request.getScheme()+"://"+request.getServerName()+":"
            +request.getServerPort()+path;
    pageContext.setAttribute("basePath",basePath);
%>

<html>
<head>
    <meta charset="UTF-8">
    <title>test</title>
</head>


<script>

</script>

<body>
<p id="test">Hello ${basePath} ${4+3} World!</p>
<p>hello <%=path%> world!</p>

<h2 class="font-bold">Login</h2>
<form class="m-t jeesns_form" action="<%=path%>/member/login" method="post">
    <input type="hidden" name="redirectUrl" value="${redirectUrl}">
    <div class="form-group">
        用户名/邮箱
        <input type="text" class="form-control" name="name" placeholder="用户名/邮箱" data-type="require">
    </div>
    <div class="form-group">
        密码
        <input type="password" class="form-control" name="password" placeholder="密码"
               data-type="require">
    </div>
    <button type="submit" class="btn btn-primary block full-width m-b">登录</button>
</form>
<p></p>
<p class="text-muted text-center">
    <a href="forgetpwd">忘记密码?</a> |
    <a href="register">我要注册</a>
</p>
</body>


</html>
