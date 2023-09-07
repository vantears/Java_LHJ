<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
	<h1>POST</h1>
	<form action="<c:url value=''/>" method="post" enctype="multipart/form-data">
		<input type="hidden" name="bo_ori_num" value="${bo_ori_num}">
		<div class="form-group">
			<label>TITLE</label>
			<input type="text" class="form-control" name="bo_title">
		</div>
		<div class="form-group">
			<label>USER</label>
			<input type="text" class="form-control" name="bo_me_id" value="${user.me_id }" readonly>
		</div>
		<div class="form-group">
			<label>CONTENTS</label>
			<textarea id="summernote" name="bo_contents" class="form-control" rows="10"></textarea>
		</div>
		<div class="form-group">
			<label>ATTACHMENT(S)</label>
			<input type="file" class="form-control" name="files">
			<input type="file" class="form-control" name="files">
			<input type="file" class="form-control" name="files">
		</div>
		<button class="btn btn-outline-success col-12">SUBMIT</button>
	</form>
	<script>
      $('#summernote').summernote({
        placeholder: 'Write your great ideas here.',
        tabsize: 2,
        height: 300
      });
    </script>
</body>
</html>