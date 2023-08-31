<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>스프링</title>
</head>
<body>
	<div class="container">
		<h1>게시글 상세</h1>
		<c:choose>
			<c:when test="${board == null }">
				<h2>삭제된 게시글이거나 등록되지 않은 게시글입니다.</h2>
				<a href="<c:url value='/board/list${cri.currentUrl}'/>" class="btn btn-outline-primary">목록으로</a>
			</c:when>
			<c:otherwise>
			<div class="form-group">
					<div>게시글 번호 ${board.bo_num}</div>
					<div style="font-weight:bold; font-size:40px;">${board.bo_title}</div>
			</div>
				<div class="form-group">
					&#128197; ${board.bo_reg_date_str} ｜ &#128065; ${board.bo_views} ｜ &#128077; ${board.bo_up}　&#128078; ${board.bo_down}
				</div>
				<c:if test="${board.bo_up_date != null }">
					<div class="form-group">
						<label>수정일</label>
						<div class="form-control">${board.bo_up_date_str}</div>
					</div>
				</c:if>
				<div class="form-group">
					<div style="min-height:400px;">${board.bo_contents}</div>
				</div>
				<div class="form-group">
					<button class="btn btn-outline-primary btn-up">&#128077;</button>
					<button class="btn btn-outline-danger btn-up">&#128078;</button>
				</div>
				<a href="<c:url value='/board/list${cri.currentUrl}'/>" class="btn btn-outline-primary">목록으로</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
