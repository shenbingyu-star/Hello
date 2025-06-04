<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<!views/login.jsp>
<main class="container">
    <div class="auth-container">
        <h1>用户登录</h1>

        <form class="auth-form" method="post" action="<c:url value="/auth/login"/>">
            <div class="form-group">
                <label for="username">用户名</label>
                <input type="text" id="username" name="username" placeholder="请输入用户名" required>
            </div>

            <div class="form-group">
                <label for="password">密码</label>
                <input type="password" id="password" name="password" placeholder="请输入密码" required>
                <span class="password-toggle" style="cursor: pointer; color: #3498db; font-size: 0.9em;">显示密码</span>
            </div>

            <button type="submit" class="btn">登录</button>

            <c:if test="${not empty error}">
                <div class="error-message">${error}</div>
            </c:if>

            <div class="auth-links">
                还没有账号？<a href="<c:url value="/auth/register"/>">立即注册</a>
            </div>
        </form>
    </div>
</main>
<script src="<c:url value="/static/js/main.js"/>"></script>
</body>
</html>