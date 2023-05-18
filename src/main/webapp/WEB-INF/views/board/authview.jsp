<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="../fragment/header2.jsp"></jsp:include>

  <form class="container mb-3 mt-5" action="/myweb/board/${post.id}/edit" method="post">
    <div class="mb-3">
        <label class="form-label">제목</label>
        <input type="text" class="form-control" name="title" value="${post.title}">
    </div>
    <div class="mb-3">
        <label class="form-label">내용</label>
        <textarea class="form-control" rows="3" name="content" value="${post.content}">${post.content}</textarea>
    </div>
    <input type="hidden" name="author" value="${username}">
    <input type="hidden" name="postId" value="${post.id}">
    <button type="submit" class="btn btn-primary">수정</button>
    <a href="/myweb/board/${post.id}/delete" class="btn btn-danger">삭제</a>
    <a href="/myweb/board" class="btn btn-primary">게시글로</a>
</form>

  
    
</body>
</html>