<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- src/main/webapp/WEB-INF/views/login.jsp -->
<form method="post" action="<c:url value="/auth/login"/>">
    <label>
        <input type="text" name="username" placeholder="用户名" required>
    </label>
    <label>
        <input type="password" name="password" placeholder="密码" required>
    </label>
    <button type="submit">登录</button>
    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>
</form>