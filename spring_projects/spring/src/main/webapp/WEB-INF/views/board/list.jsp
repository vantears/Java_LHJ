<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
</head>
<body>
	<h1>BOARD</h1>
	<c:choose>
		<c:when test="${pm.totalCount != 0}">
			<table class="table table-hover">
			    <thead>
			      <tr>
			      	<th>NO.</th>
			        <th>USER</th>
			        <th>TITLE</th>
			        <th> </th>
			      </tr>
			    </thead>
			    <c:forEach items="${list}" var="board">
			      <tr>
			        <td>${board.bo_num}</td>
			        <td>${board.bo_me_id}</td>
			        <td>
			        	<a href="<c:url value='/board/detail${pm.cri.currentUrl}&bo_num=${board.bo_num}' />" style="color:black; text-decoration:none;">${board.bo_title}</a>
			        </td>
			        <td style="text-align:right;">&#128488; ${board.bo_comment}　&#128065; ${board.bo_views}　&#128077; ${board.bo_up} &#128078; ${board.bo_down}　&#128197; ${board.bo_reg_date_str}</td>
			      </tr>
			    </c:forEach>
  			</table>
		  	<ul class="pagination justify-content-center" style="margin:20px 0">
				<c:if test="${pm.prev}">
					<li class="page-item"><a class="page-link" href="<c:url value='${pm.cri.getUrl(pm.startPage-1)}'/>">Prev</a></li>
				</c:if>
				<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
					<li class="page-item <c:if test='${pm.cri.page == i}'> active</c:if>"><a class="page-link" href="<c:url value='${pm.cri.getUrl(i)}'/>">${i}</a></li>
				</c:forEach>
				<c:if test="${pm.next}">
					<li class="page-item"><a class="page-link" href="<c:url value='${pm.cri.getUrl(pm.endPage+1)}'/>">Next</a></li>
				</c:if>
	  		</ul>
  		</c:when>
		<c:otherwise>
			<h2>No threads are posted yet</h2>
		</c:otherwise>
	</c:choose>
  <c:if test="${user != null && user.me_id != null }">
  	<a class="btn btn-outline-danger" href="<c:url value='/board/insert'/>">POST</a>
  </c:if>
</body>
</html>