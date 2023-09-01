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
				<h2>삭제된 게시글이거나 등록되지 않은 게시글입니다.</h2>
				<a href="<c:url value='/board/list${cri.currentUrl}'/>" class="btn btn-outline-primary">목록으로</a>
			</c:when>
			<c:otherwise>
			<div class="form-group">
					<div>게시글 번호 ${board.bo_num}</div>
					<div style="font-weight:bold; font-size:40px;">${board.bo_title}</div>
			</div>
				<div class="form-group">
					${board.bo_me_id} ｜ &#128197; ${board.bo_reg_date_str} ｜ &#128065; ${board.bo_views} ｜ &#128077; ${board.bo_up}　&#128078; ${board.bo_down}
				</div>
				<c:if test="${board.bo_up_date != null }">
					<div class="form-group">
						<div style="font-style:italic; font-size:14px">수정일 ${board.bo_up_date_str}</div>
					</div>
				</c:if>
				<div class="form-group">
					<div style="min-height:400px;">${board.bo_contents}</div>
				</div>
				<div class="form-group">
					<c:choose>
						<c:when test="${board.fileVoList.size() != 0 }">
							<label>첨부파일</label>
							<c:forEach items="${board.fileVoList }" var="file">
								<a class="form-control" href="<c:url value='/download${file.fi_name}'/>" download="${file.fi_ori_name}">${file.fi_ori_name}</a>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<label>첨부파일 없음</label>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="form-group">
					<button class="btn btn-outline-primary btn-up">&#128077;</button>
					<button class="btn btn-outline-danger btn-up">&#128078;</button>
				</div>
				<div style="display:inline-block">
				<a href="<c:url value='/board/list${cri.currentUrl}'/>" class="btn btn-outline-primary">목록으로</a>
				<c:if test="${user != null && user.me_id != null && user.me_id.equals(board.bo_me_id)}">
				<%-- <form style="display:inline" action="<c:url value='/board/detail?bo_num=${board.bo_num}'/>" method="post"><button class="btn btn-outline-danger">삭제하기</button></form> --%>
				<a href="<c:url value='/board/update?bo_num=${board.bo_num}'/>" class="btn btn-outline-warning">수정하기</a>
				<a href="<c:url value='/board/delete?bo_num=${board.bo_num}'/>" class="btn btn-outline-danger">삭제하기</a>
				</c:if>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
