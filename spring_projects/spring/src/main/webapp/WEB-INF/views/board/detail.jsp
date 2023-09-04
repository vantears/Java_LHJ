<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>스프링</title>
</head>
<body>
	<div class="container mt-4 mb-4">
		<c:choose>
			<c:when test="${board == null }">
				<h2>This post has been deleted or not posted yet</h2>
				<a href="<c:url value='/board/list${cri.currentUrl}'/>" class="btn btn-outline-primary">BACK</a>
			</c:when>
			<c:otherwise>
			<div class="form-group">
					<div>No. ${board.bo_num}</div>
					<div style="font-weight:bold; font-size:40px;">${board.bo_title}</div>
			</div>
				<div class="form-group">
					${board.bo_me_id} ｜ &#128197; ${board.bo_reg_date_str} ｜ &#128065; ${board.bo_views} ｜ &#128077; ${board.bo_up}　&#128078; ${board.bo_down}
				</div>
				<c:if test="${board.bo_up_date != null }">
					<div class="form-group">
						<div style="font-style:italic; font-size:14px">Edited at ${board.bo_up_date_str}</div>
					</div>
				</c:if>
				<div class="form-group">
					<div style="min-height:400px;">${board.bo_contents}</div>
				</div>
				<div class="form-group">
					<c:choose>
						<c:when test="${board.fileVoList.size() != 0 }">
							<label>Attachment(s)</label>
							<c:forEach items="${board.fileVoList }" var="file">
								<a class="form-control" href="<c:url value='/download${file.fi_name}'/>" download="${file.fi_ori_name}">${file.fi_ori_name}</a>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<label>No attachments</label>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="form-group">
					<c:choose>
						<c:when test="${1 == like.li_state}">
							<a class="btn btn-outline-primary btn-up" style="background-color:#007bff;" href="<c:url value='/board/likeup?bo_num=${board.bo_num}'/>">&#128077;</a>
						</c:when>
						<c:otherwise>
							<a class="btn btn-outline-primary btn-up" href="<c:url value='/board/likeup?bo_num=${board.bo_num}'/>">&#128077;</a>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${-1 == like.li_state}">
								<a class="btn btn-outline-danger btn-up" style="background-color:#dc3545;" href="<c:url value='/board/likedown?bo_num=${board.bo_num}'/>">&#128078;</a>
						</c:when>
						<c:otherwise>
							<a class="btn btn-outline-danger btn-up"href="<c:url value='/board/likedown?bo_num=${board.bo_num}'/>">&#128078;</a>
						</c:otherwise>
					</c:choose>
				</div>
				<div style="display:inline-block">
				<a href="<c:url value='/board/list${cri.currentUrl}'/>" class="btn btn-outline-primary">BACK</a>
				<c:if test="${user != null && user.me_id != null && user.me_id.equals(board.bo_me_id)}">
				<%-- <form style="display:inline" action="<c:url value='/board/detail?bo_num=${board.bo_num}'/>" method="post"><button class="btn btn-outline-danger">삭제하기</button></form> --%>
				<a href="<c:url value='/board/update?bo_num=${board.bo_num}'/>" class="btn btn-outline-warning">EDIT</a>
				<a href="<c:url value='/board/delete?bo_num=${board.bo_num}'/>" class="btn btn-outline-danger">DELETE</a>
				</c:if>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
