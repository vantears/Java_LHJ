<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>SIGN UP</title>
</head>
<body>
	<h1>LOG IN</h1>
	<form action="<c:url value='/member/login' />" method="post">
		<div class="form-group">
			<label>ID</label>
			<input type="text" class="form-control" name="me_id">
		</div>
		<div class="form-group">
			<label>PASSWORD</label>
			<input type="password" class="form-control" name="me_pw">
		</div>
		<button class="btn btn-outline-warning col-12">LOG IN</button>
	</form>
</body>
</html>
