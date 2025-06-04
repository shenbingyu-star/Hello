<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<!views/forum.jsp>
<main class="container">
    <h1 style="margin: 30px 0;">发表帖子</h1>
    <div class="form-container">
        <form action="<c:url value="/forum/add"/>" method="post">
            <div class="form-group">
                <label for="title">标题</label> <!-- 新增标题输入框 -->
                <input type="text" id="title" name="title" placeholder="请输入标题" required>
            </div>
            <div class="form-group">
                <label for="content">发表帖子</label>
                <textarea id="content" name="content" rows="5" placeholder="分享你的想法..."></textarea>
            </div>
            <div class="form-group">
                <label for="author">作者</label>
                <input type="text" id="author" name="author" value="${sessionScope.currentUser.username}" readonly>
            </div>
            <div class="form-group">
                <label for="board">板块</label>
                <select id="board" name="board">
                    <option value="励志板块">励志板块</option>
                    <option value="生活板块">生活板块</option>
                    <option value="感恩板块">感恩板块</option>
                    <option value="成长板块">成长板块</option>
                    <option value="团队板块">团队板块</option>
                    <option value="健康板块">健康板块</option>
                    <option value="创新板块">创新板块</option>
                    <option value="心态板块">心态板块</option>
                </select>
            </div>
            <button type="submit" class="btn">发表</button>
        </form>
    </div>

</main>