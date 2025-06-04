<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<!views/register.jsp>
<main class="container">
    <div class="auth-container">
        <h1>用户注册</h1>

        <form class="auth-form" method="post" action="<c:url value="/auth/register"/>">
            <div class="form-group">
                <label for="username">用户名</label>
                <input type="text" id="username" name="username" placeholder="请输入用户名" required>
            </div>

            <div class="form-group">
                <label for="password">密码</label>
                <input type="password" id="password" name="password" placeholder="请输入密码" required>
                <span class="password-toggle" style="cursor: pointer; color: #3498db; font-size: 0.9em;">显示密码</span>
            </div>

            <div class="form-group">
                <label for="email">邮箱</label>
                <input type="email" id="email" name="email" placeholder="请输入邮箱">
            </div>

            <button type="submit" class="btn">注册</button>

            <c:if test="${not empty error}">
                <div class="error-message">${error}</div>
            </c:if>

            <div class="auth-links">
                已有账号？<a href="<c:url value="/auth/login"/>">立即登录</a>
            </div>
        </form>
    </div>
</main>
<script src="<c:url value="/static/js/main.js"/>"></script>
</body>
</html>