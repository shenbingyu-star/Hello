<!-- src/main/webapp/WEB-INF/views/register.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="<c:url value="/auth/register"/>">
    <label>
        <input type="text" name="username" placeholder="用户名" required>
    </label>
    <label>
        <input type="password" name="password" placeholder="密码" required>
    </label>
    <label>
        <input type="email" name="email" placeholder="邮箱">
    </label>
    <button type="submit">注册</button>
    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>
</form>