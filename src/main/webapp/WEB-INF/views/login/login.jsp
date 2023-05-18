<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>CodePen - RegView - Log in</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css" type="text/css">
</head>
<body>
  <div class="login-page" ng-app="">
    <div class="login-content login-content-signin">
      <div>
        <h2>Log in</h2>
        <form class="wrapper-box" role="form" ng-submit="login()" action="/myweb/login" method="post">
          <input type="text"
            ng-model="text"
            class="form-control form-control-email"
            placeholder="ID"
            required
            name="username">
          <input type="password"
            ng-model="password"
            class="form-control form-control-password"
            placeholder="Password"
            required 
            name="password">
          <!-- <div class="checkbox pull-left">
            <label>
              <input type="checkbox"> Remember me.
            </label>
          </div> -->
          <a class="outer-link pull-left" href="#/forgot">Forgot Password</a>
          <button type="submit" class="btn btn-submit btn-default pull-right">Log in</button>
        </form>
      </div>
    </div>

    <div class="login-switcher">
      <div class="login-switcher-signup">
        <h3>Don't have an account?</h3>
        <a href="register">Sign Up</a>
      </div>
    </div>
  </div>

  <script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script src='//cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.5/angular.min.js'></script>
</body>
</html>