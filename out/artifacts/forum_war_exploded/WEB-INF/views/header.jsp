<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- src/main/webapp/WEB-INF/views/header.jsp -->
<div style="float:right">
    <c:choose>
        <c:when test="${not empty sessionScope.currentUser}">
            欢迎，<a href="<c:url value="/user/profile"/>">${sessionScope.currentUser.username}</a> |
            <a href="<c:url value="/auth/logout"/>">退出</a>
        </c:when>
        <c:otherwise>
            <a href="<c:url value="/auth/login"/>">登录</a> |
            <a href="<c:url value="/auth/register"/>">注册</a>
        </c:otherwise>
    </c:choose>
</div>