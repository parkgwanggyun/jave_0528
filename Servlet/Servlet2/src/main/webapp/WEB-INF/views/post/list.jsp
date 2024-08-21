
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="/WEB-INF/views/common/head.jsp"/>
<title>메인</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<div class="container" style="min-height: calc(100vh - 240px)">
<h1 class="mt-3 mb-3">xx 커뮤니티 목록</h1>
	<!-- 
	1. 가져온 커뮤니티 정보를 이용해서 xx를 수정
	2. 게시글 목록을 이용해서 화면을 구성
	3. 페이지네이션 정보를 이용해서 화면을 구성
	4. 검색 기능 구현
	 -->
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
	
</body>
</html>
