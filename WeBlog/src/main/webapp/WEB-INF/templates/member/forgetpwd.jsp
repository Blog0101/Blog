<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 18-4-11
  Time: 上午9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="animated fadeInDown">
    <div class="row login-panel">
        <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="ibox-content">
                    <h2 class="font-bold">忘记密码</h2>
                    <form class="m-t jeesns_form" action="${basePath}/member/forgetpwd" method="post">
                        <div class="form-group">
                            用户名
                            <input type="text" class="form-control" name="name" data-type="require" placeholder="用户名">
                        </div>
                        <div class="form-group">
                            邮箱
                            <input type="email" class="form-control" name="email" placeholder="邮箱" data-type="require,email">
                        </div>
                        <button type="submit" class="btn btn-primary full-width m-b">找回密码</button>
                        <p></p>
                        <p class="text-muted text-center">
                            <a href="login">我要登录</a> |
                            <a href="register">我要注册</a>
                        </p>
                    </form>
                    <p></p>
                </div>
            </div>
    </div>

</div>
</body>
</html>
