<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>SIGN UP</title>
</head>
<body>
	<h1>SIGN UP</h1>
	<form action="<c:url value='/member/signup' />" method="post">
		<div class="form-group">
			<label>ID</label>
			<input type="text" class="form-control" name="me_id">
		</div>
		<div class="form-group">
			<label>PASSWORD</label>
			<input type="password" class="form-control" name="me_pw">
		</div>
		<div class="form-group">
			<label>EMAIL</label>
			<input type="email" class="form-control" name="me_email">
		</div>
		<button class="btn btn-outline-warning col-12">SIGN UP</button>
	</form>
</body>
</html>
