<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>스프링</title>
</head>
<body>
	<script type="text/javascript">
		let msg = ${msg};
		if(msg != null | msg.msg != null){
			alert(msg.msg);
		}
		location.href = '<c:url value="/"/>' + msg.url;
	</script>
</body>
</html>
