<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="<c:url value='/' />">
    <img src="<c:url value='/resources/img/logo.jpg'/>" alt="logo" style="width:40px;">
  </a>
  <ul class="navbar-nav">
    <c:if test="${user == null}">
	    <li class="nav-item">
	      <a class="nav-link" href="<c:url value='/member/signup' />">SIGN UP</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="<c:url value='/member/login' />">LOGIN</a>
	    </li>
    </c:if>
    <c:if test="${user != null}">
		<li class="nav-item">
	      <a class="nav-link" href="<c:url value='/member/logout' />">LOGOUT</a>
	    </li>
    </c:if>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value='/board/list' />">BOARD</a>
    </li>
  </ul>
  <c:if test="${user != null}">
  	<p id="welcome" class="nav-item m-0" style="color:white; position:absolute; right:16px">WELCOME!　<span style="font-weight:bold; font-size:20px">${user.getMe_id()}</span> <a href="#" style="font-size:20px">&#128146;</a>
  </c:if>
</nav>