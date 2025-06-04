<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>欢迎来到简单论坛</title>
    <link rel="stylesheet" href="<c:url value="/static/css/style.css"/>">
</head>
<body>
<main class="container">
    <!-- 搜索表单 -->
    <form action="<c:url value="/search"/>" method="get" class="search-form">
        <input type="text" name="keyword" placeholder="搜索帖子..." value="${searchKeyword}">
        <button type="submit">搜索</button>
    </form>

    <!-- 如果用户进行了搜索，显示搜索结果 -->
    <c:if test="${not empty searchKeyword}">
        <h2>搜索结果</h2>
    </c:if>

    <!-- 用户帖子 -->
    <c:if test="${isUserPosts}">
        <h2>我的帖子</h2>
    </c:if>

    <h2>最新帖子</h2>

    <c:forEach var="post" items="${posts}">
        <div class="post">
            <h3>${post.title}</h3>
            <div class="post-meta">
                <span>板块: ${post.board}</span> |
                <span>作者: ${post.author}</span> |
                <span>时间: <fmt:formatDate value="${post.timestamp}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
            </div>
            <div class="post-content">
                    ${post.content}
            </div>

            <!-- 评论区 -->
            <div class="comments-section">
                <h4>评论 (${commentsMap[post.id].size()})</h4>

                <!-- 评论列表 -->
                <div class="comments-list">
                    <c:forEach var="comment" items="${commentsMap[post.id]}">
                        <div class="comment">
                            <div class="comment-meta">
                                <span class="comment-author">${comment.username}</span>
                                <span class="comment-time">
                                    <fmt:formatDate value="${comment.createdAt}" pattern="yyyy-MM-dd HH:mm" />
                                </span>
                            </div>
                            <div class="comment-content">${comment.content}</div>
                        </div>
                    </c:forEach>
                </div>

                <!-- 发表评论表单 -->
                <c:if test="${not empty sessionScope.currentUser}">
                    <form class="comment-form" action="<c:url value="/forum/comment"/>" method="post">
                        <input type="hidden" name="postId" value="${post.id}" />
                        <div class="form-group">
                            <textarea name="content" placeholder="写下你的评论..." required></textarea>
                        </div>
                        <button type="submit" class="btn btn-sm">发表评论</button>
                    </form>
                </c:if>
                <c:if test="${empty sessionScope.currentUser}">
                    <p class="login-prompt">请<a href="<c:url value="/auth/login"/>">登录</a>后发表评论</p>
                </c:if>
            </div>
        </div>
    </c:forEach>
</main>

<script src="<c:url value="/static/js/main.js"/>"></script>
</body>
</html>