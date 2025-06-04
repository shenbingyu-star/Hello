<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<html>
<head>
    <title>简单论坛</title>
</head>
<body>
<h1>简单论坛</h1>
<form action="<c:url value="/forum/add"/>" method="post">
    <label>
        <textarea name="content" rows="5" cols="50" placeholder="发表帖子..."></textarea>
    </label><br>
    <label>
        作者：<input type="text" name="author" value="${sessionScope.currentUser.username}" readonly>
    </label><br>
    <button type="submit">发表</button>
</form>
<h2>帖子列表</h2>
<c:forEach var="post" items="${posts}">
    <div>
        <p>${post.content}</p>
        <p>发帖时间：<fmt:formatDate value="${post.timestamp}" pattern="yyyy-MM-dd HH:mm:ss" /></p>
        <p>发帖用户：<c:out value="${post.author}" /></p>
    </div>
</c:forEach>
</body>
</html>