<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html> 
<html>
<head>
<meta charset="UTF-8"> <!-- 추가할부분 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 추가할부분 -->
	<meta http-equiv="X-UA-Compatible" content="ie=edge"> <!-- 추가할부분 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
  	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
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
<title>스프링</title>
</head>
<body>
    <tiles:insertAttribute name="header"/>
    <div class="container" style="min-height: calc(100vh - 66px - 184px)">      
        <tiles:insertAttribute name="body" />
    </div>                                                  
    <tiles:insertAttribute name="footer" />
</body>
</html>
