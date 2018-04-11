<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 18-4-11
  Time: 下午2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="wrapper wrapper-content">
    <div class="member-banner" style="background-image: url(${basePath}/res/common/images/member_banner.png);">
        <div class="attempts"></div>
        <div class="container">
            <div class="container content">
                <div class="left">
                    <div class="avatar">
                        <img src="${basePath}${loginUser.avatar}" class="img-circle" width="80px" height="80px"/>
                    </div>
                    <div class="info">
                        <div class="name">
                            ${loginUser.name}
                            <#if loginUser.sex=='女'>
                            <span class="sex"><i class="fa fa-venus"></i></span>
                            <#elseif loginUser.sex=='男'>
                            <span class="sex"><i class="fa fa-mars"></i></span>
                            <#else>
                            <span class="sex"><i class="fa fa-intersex"></i></span>
                        </#if>
                    </div>
                    <p>${loginUser.website}</p>
                    <p>${loginUser.introduce}</p>
                    <p class="operator">
                        <a class="btn btn-info btn-outline member-follows" href="${basePath}/member/editInfo">
                            <i class="fa fa-edit"></i> 编辑个人资料
                        </a>
                    </p>
                </div>
            </div>
            <div class="right">
                <div class="follows">
                    <span>关注</span>
                    <a href="${basePath}/u/${loginUser.id}/home/follows">${loginUser.follows}</a>
                </div>
                <div class="fans">
                    <span>粉丝</span>
                    <a href="${basePath}/u/${loginUser.id}/home/fans">${loginUser.fans}</a>
                </div>
            </div>
        </div>
    </div>
</div>>
</body>
</html>
