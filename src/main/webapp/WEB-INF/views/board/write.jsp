<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="../fragment/header2.jsp"></jsp:include>

    
   <div class="container">
    <div class="custom-form">
      <form class="mb-3 mt-5" action="/myweb/board/write" method="post">
        <div class="mb-3">
          <label class="form-label">제목</label>
          <input type="text" class="form-control" name="title" required>
        </div>
        <div class="mb-3">
          <label class="form-label">내용</label>
          <textarea class="form-control" rows="3" name="content" required></textarea>
        </div>
        <input type="hidden" name="author" value="${username}">
        <button type="submit" class="btn btn-primary">제출</button>
      </form>
    </div>
  </div>
  
  <script>
    var alertScript = "${alertScript}";
    if (alertScript) {
        eval(alertScript);
    }
</script>
    
</body>
</html>