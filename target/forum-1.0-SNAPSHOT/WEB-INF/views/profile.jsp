<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<!views/profile.jsp>
<main class="container">
    <div class="form-container" style="max-width: 600px;">
        <h1 style="text-align: center; margin-bottom: 30px;">用户资料</h1>

        <div class="form-group">
            <label>用户名</label>
            <div style="padding: 10px; background-color: #f9f9f9; border-radius: 4px;">
                ${user.username}
            </div>
        </div>

        <div class="form-group">
            <label>邮箱</label>
            <div style="padding: 10px; background-color: #f9f9f9; border-radius: 4px;">
                ${user.email}
            </div>
        </div>

        <div class="form-group">
            <label>注册时间</label>
            <div style="padding: 10px; background-color: #f9f9f9; border-radius: 4px;">
                ${user.createdAt}
            </div>
        </div>

        <div style="text-align: center; margin-top: 30px;">
            <a href="<c:url value="/"/>" class="btn" style="display: inline-block;">返回论坛</a>
        </div>
    </div>
</main>
<script src="<c:url value="/static/js/main.js"/>"></script>
</body>
</html>