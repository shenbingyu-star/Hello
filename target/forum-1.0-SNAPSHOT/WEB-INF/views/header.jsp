<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>简单论坛</title>
    <link rel="stylesheet" href="<c:url value="/static/css/style.css"/>">
</head>
<body>
<header>
    <div class="container">
        <nav>
            <div>
                <a href="<c:url value="/"/>">简单论坛</a>|
                <a href="<c:url value="/forum/"/>">发表论坛</a>

            </div>
            <div>
                <c:choose>
                    <c:when test="${not empty sessionScope.currentUser}">
                        <a href="<c:url value="/user/posts"/>">我的帖子</a>|
                        <span style="color: white;">欢迎，</span>
                        <a href="<c:url value="/user/profile"/>">${sessionScope.currentUser.username}</a>|
                        <a href="<c:url value="/auth/logout"/>">退出</a>
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value="/auth/login"/>">登录</a>|
                        <a href="<c:url value="/auth/register"/>">注册</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </nav>
    </div>
</header>