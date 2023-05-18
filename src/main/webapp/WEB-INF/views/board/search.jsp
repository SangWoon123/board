<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../fragment/logoutheader.jsp" %>

<!-- 메인 컨텐츠 -->
<div class="container-fluid mx-auto p-2 mt-5" style="max-width: 800px;">
  <!-- 검색 바 -->
  <div class="d-flex justify-content-end">
    <nav class="navbar">
      <div class="container-fluid">
        <form class="d-flex" role="search" action="/myweb/board/search" method="get">
          <input class="form-control me-2" type="search" name="keyword" placeholder="제목 + 내용" aria-label="Search">
          <button class="d-flex btn btn-outline-primary" type="submit">Search</button>
        </form>
      </div>
    </nav>
  </div>

  <!-- 글 목록 테이블 -->
  <table class="table table-hover ">
    <thead>
      <tr>
        <th scope="col">제목</th>
        <th scope="col">작성자</th>
        <th scope="col">작성일</th>
      </tr>
    </thead>
    <tbody>
  <c:forEach items="${search}" var="post">
    <tr>
      <td scope="row">
        <a href="/myweb/board/${post.id}/edit">${post.title}</a>
      </td>
      <td scope="row">${post.author}</td>
      <td>${post.createdAt}</td>
    </tr>
  </c:forEach>
</tbody>
</table>

  <!-- 글쓰기 버튼 -->
  <div class="d-flex justify-content-end">
    <a class="btn btn-primary" href="/myweb/board/write" role="button">글쓰기</a>
  </div>

  <div class="d-flex justify-content-center">
    <nav aria-label="Page navigation example">
      <ul class="pagination">
        <li class="page-item"><a class="page-link" href="#">이전</a></li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item"><a class="page-link" href="#">다음</a></li>
      </ul>
    </nav>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>

</html>
