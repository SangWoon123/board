<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <!-- 문서 인코딩 및 viewport 설정 -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- 문서 제목 -->
  <title>Bootstrap demo</title>
  
   <style>
     .container-center {
      display: flex;
      justify-content: center;
      align-items: center;
      width: 100vw;
      height: 100vh;
    }
    
    .custom-form {
      width: 80%;
      max-width: 500px;
    }
  </style>

  <!-- 부트스트랩 CSS 파일 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
  <!-- 상단 네비게이션 바 -->
  <nav class="navbar navbar-dark bg-success fixed-top">
    <div class="container-fluid">
      <a class="navbar-brand" href="/myweb/board">${nickname}님 반갑습니다!</a>
</div>
  </nav>

    <div class="container-center">
    <div class="custom-form">
      <form class="mb-3 mt-5" action="/myweb/board/${post.id}/edit" method="post">
        <div class="mb-3">
          <label class="form-label">제목</label>
          <input type="text" class="form-control" name="title" value="${post.title}">
        </div>
        <div class="mb-3">
          <label class="form-label">내용</label>
          <textarea class="form-control" rows="3" name="content">${post.content}</textarea>
        </div>
        <input type="hidden" name="author" value="${username}">
        <a href="/myweb/board" class="btn btn-primary">게시글로</a>
      </form>
    </div>
  </div>
  
    
</body>
</html>