<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>SIGN UP</title>
</head>
<body>
	<h1>My info</h1>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <div class="container mt-4 mb-4">
		<c:choose>
			<c:when test="${user == null }">
				<h2>Please log in first</h2>
			</c:when>
			<c:otherwise>
				<div class="form-group">
					<label>ID</label>
					<input type="text" class="form-control" name="me_id" value="${user.me_id }" readonly>	
				</div>
				<div class="form-group">
					<label>PASSWORD</label>
					<input type="password" class="form-control" name="me_pw" id="password">
				</div>
				<div class="form-group">
					<label>PASSWORD CONFIRMATION</label>
					<input type="password" class="form-control" name="me_pw" id="password2">
				</div>
				<div class="custom-control custom-switch">
    				<input type="checkbox" class="custom-control-input" id="switch1">
    				<label class="custom-control-label" for="switch1">Show password</label>
  				</div>
				<div class="form-group">
					<label>EMAIL</label>
					<input type="text" class="form-control" name="bo_me_id" value="${user.me_email }" readonly>
				</div>
				<a href="#" class="btn btn-outline-warning">CONFIRM</a>
				<a href="#" class="btn btn-outline-danger">RESIGN</a>
			</c:otherwise>
		</c:choose>
	</div>
	<script>
	$(document).ready(function(){
		$('#switch1').on('click', function(){
			
			var passwordField = $('#password');
			var passwordField2 = $('#password2');
			
			var passwordFieldType = passwordField.attr('type');
			var passwordFieldType2 = passwordField2.attr('type');
			
			if(passwordFieldType == 'password'){
				passwordField.attr('type', 'text');
			} else {
				passwordField.attr('type', 'password');
			}
			
			if(passwordFieldType2 == 'password'){
				passwordField2.attr('type', 'text');
			} else {
				passwordField2.attr('type', 'password');
			}
			
				
		});
	});
	</script>
</body>
</html>
