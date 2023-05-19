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

  <!-- 부트스트랩 CSS 파일 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
  <!-- 상단 네비게이션 바 -->
  <nav class="navbar navbar-dark bg-primary fixed-top">
    <div class="container-fluid">
      <a class="navbar-brand" href="/myweb/board">${nickname}님 반갑습니다!</a>
      <button type="button" class="btn btn-danger">
      <a href="/myweb/logout" style="color: white; text-decoration: none;">로그아웃</a></button>
</div>
  </nav>