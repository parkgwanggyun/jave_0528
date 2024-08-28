
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<h1>게시글 목록</h1>
	<div class="mb-3">
		<c:forEach items="${list}" var="co">
			<c:choose>
				<c:when test="${co.co_num eq pm.cri.co_num }">
					<a href="<c:url value="/post/list?co_num=${co.co_num }"/>" class="btn btn-info">${co.co_name }</a>
				</c:when>
				<c:otherwise>
			  		<a href="<c:url value="/post/list?co_num=${co.co_num }"/>" class="btn btn-outline-info">${co.co_name }</a>
				</c:otherwise>
			</c:choose>
	  	</c:forEach>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>추천수</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${postList }" var="post">
				<tr>
					<td>${post.po_num }</td>
					<td>
						<a href="#">${post.po_title }</a>
					</td>
					<td>
						<a href="#">${post.po_me_id }</a>
					</td>
					<td>
						<fmt:formatDate value="${post.po_date }" pattern="yyyy.MM.dd." />
					</td>
					<td></td>
					<td>${post.po_view }</td>	
				</tr>
			</c:forEach>
			<c:if test="${postList.size() eq 0 }">
				<tr>
					<th class="text-center" colspan="6">등록된 게시글이 없습니다.</th>
				</tr>
			</c:if>
		</tbody>
	</table>
	<c:if test="${pm.totalCount ne 0 }">
		<ul class="pagination justify-content-center">
			<c:if test="${pm.prev }">
				<c:url var="url" value="/post/list">
					<c:param name="co_num" value="${pm.cri.co_num }"/>
					<c:param name="page" value="${pm.startPage - 1 }"/>
				</c:url>
			    <li class="page-item">
			    	<a class="page-link" href="${url }">이전</a>
			    </li>
		    </c:if>
		    <c:forEach begin="${pm.startPage }" end="${pm.endPage}" var="i">
		    	<c:url var="url" value="/post/list">
					<c:param name="co_num" value="${pm.cri.co_num }"/>
					<c:param name="page" value="${i}"/>
				</c:url>
				<c:choose>
					<c:when test="${pm.cri.page eq i }">
						<c:set var="active" value="active" />
					</c:when>
					<c:otherwise>
						<c:set var="active" value="" />
					</c:otherwise>
				</c:choose>
			    <li class="page-item ${active}">
			    	<a class="page-link" href="${url }">${i}</a>
			    </li>
		    </c:forEach>
		    <c:if test="${pm.next }">
		    	<c:url var="url" value="/post/list">
					<c:param name="co_num" value="${pm.cri.co_num }"/>
					<c:param name="page" value="${pm.endPage + 1 }"/>
				</c:url>
			    <li class="page-item">
			    	<a class="page-link" href="${url }">다음</a>
			    </li>
		    </c:if>
		</ul>
	</c:if>
</body>
</html>