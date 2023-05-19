<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>CodePen - RegView - Sign Up</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css" type="text/css">
</head>
<body>
  <div class="login-page" ng-app="">
    <div class="login-content login-content-signup">
      <div>
        <h2>Sign Up</h2>
        <form class="wrapper-box" role="form" ng-submit="register()" action="/myweb/register" method="post">
          <input type="text"
          minlength=6
            ng-model="username"
            class="form-control form-control-username"
            placeholder="Username"
            required
            name="username">
          <input type="password"
          minlength=6
            ng-model="password"
            class="form-control form-control-password"
            placeholder="Password"
            required
            name="password">
          <input type="email"
            ng-model="email"
            class="form-control form-control-email"
            placeholder="Email address"
            required
            name="email">
          <input type="text"
            ng-model="nickname"
            minlength=3
            class="form-control form-control-password"
            placeholder="Nickname"
            required
            name="nickname">
          <!-- <div class="checkbox pull-left">
            <label>
              <input type="checkbox"> Remember me.
            </label>
          </div> -->
          <button type="submit" class="btn btn-submit btn-default pull-right">Sign up</button>
        </form>
      </div>
    </div>

    <div class="login-switcher">
      <div class="login-switcher-signin">
        <h3>Have an account?</h3>
        <a href="/myweb/login">Login</a>
      </div>
    </div>
  </div>

  <script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script src='//cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.5/angular.min.js'></script>
</body>
</html>
