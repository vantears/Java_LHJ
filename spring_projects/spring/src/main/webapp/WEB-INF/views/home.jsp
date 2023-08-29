<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8"> <!-- 추가할부분 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 추가할부분 -->
	<meta http-equiv="X-UA-Compatible" content="ie=edge"> <!-- 추가할부분 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
  	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<title>스프링</title>
	<style>
	body{
	min-width:400px;
	}
	
	@media screen and (max-width: 575px) {
  	#welcome {
    
    position: absolute;
    left: 80px;
 	 }
	} 
	</style>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="<c:url value='/' />">
    <img src="<c:url value='/resources/img/logo.jpg'/>" alt="logo" style="width:40px;">
  </a>
  <ul class="navbar-nav">
    <c:if test="${user == null}">
	    <li class="nav-item">
	      <a class="nav-link" href="<c:url value='/member/signup' />">회원가입</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<c:url value='/member/login' />">로그인</a>
	    </li>
    </c:if>
    <c:if test="${user != null}">
		<li class="nav-item">
	      <a class="nav-link" href="<c:url value='/member/logout' />">로그아웃</a>
	    </li>
    </c:if>
    <li class="nav-item">
      <a class="nav-link" href="#">게시글 조회</a>
    </li>
  </ul>
  <c:if test="${user != null}">
  	<p id="welcome" class="nav-item m-0" style="color:white; position:absolute; right:16px">${user.getMe_id()}님 환영합니다.
  </c:if>
</nav>

</body>
</html>
