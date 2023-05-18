<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="../fragment/header2.jsp"></jsp:include>

    
  <form class="container mb-3 mt-5" action="/myweb/board/write" method="post">
    <div class="mb-3">
      <label class="form-label">제목</label>
      <input type="text" class="form-control" name="title">
    </div>
    <div class="mb-3">
      <label class="form-label">내용</label>
      <textarea class="form-control" rows="3" name="content"></textarea>
    </div>
    <input type="hidden" name="author" value="${username}">
    <button type="submit" class="btn btn-primary">제출</button>
  </form>
    
</body>
</html>