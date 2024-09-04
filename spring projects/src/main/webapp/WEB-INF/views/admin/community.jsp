<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<h1 class="mt-3">커뮤니티 관리</h1>
<ul class="list-group mt-3 mb-3">
	<c:forEach items="${list}" var="community">
	<li class="list-group-item d-flex justify-content-between align-items-center">
	    <span>${community.co_name}</span>
	    <span>
	   <span class="badge badge-primary badge-pill">${community.co_count}</span>
	   <button class="btn btn-outline-danger btn-co-update" data-num="${community.co_num}">수정</button>
	   <!--<a href="/community/delete?co_num=${co_num}" class="btn-community-del btn btn-outline-dark">삭제</a>-->
	   <a href="<c:url value="/admin/community/delete?co_num=${community.co_num}"/>" class="btn-community-del btn btn-outline-dark">삭제</a>
	   </span>
	</li>
	</c:forEach>
</ul>
		<form action="<c:url value="/admin/community/insert"/>"method="post"id=form1>
			<div class="input-group mb-3">
				<input type="text" class="form-control" placeholder="등록할 커뮤니티명을 입력하세요" name="name" required>
				<div class="input-group-append">
					<button type="submit" class="btn btn-outline-info col-12">등록</button>
				</div>
			</div>
		</form>
<script type="text/javascript">
$('.btn-co-update').click(function(){
	$('#form2').remove();
	var co_num = $(this).data('num');
	var co_name = $(this).parent().prev().text();
	var str = `
		<form action="<c:url value="/admin/community/update"/>" method="post" id="form2">
			<div class="input-group mb-3">
				<input type="text" class="form-control" placeholder="등록할 커뮤니티명을 입력하세요." 
					   name="co_name" required
					   value="\${co_name}">
				<input type="hidden" name="co_num" value="\${co_num}"/>
				<div class="input-group-append">
					<button type="submit" class="btn btn-outline-info col-12">수정</button>
				</div>
			</div>
		</form>
	`;
	$('#form1').hide().after(str);
});
</script>
		<!-- 
		community.jsp
		1. 삭제 버튼을 a태그롤 수정
			-href에 삭제할 커뮤니티 번호를 추가
		컨트롤러
		1. 메소드를 추가
			-getMapping추가
			-매개변수로 커뮤니티 번호를 받아옴
			-서비스에게 커뮤니티 번호를 주면서 삭제하라고 요청
			-삭제 여부를 알림으로 출력
		 -->
		<!-- 
		community.jsp
		1. 수정 버튼에 커뮤니티 번호를 추가
			-data-xxx
		2. 수정 버튼 클릭 이벤트를 등록
			- 앞서 만들어진 커뮤니티 수정창을 제거
			- 커뮤니티 등록창과 형태가 같은 커뮤니티 수정창을 만들고
				- 커뮤니티 번호를 수정창 안에 input:hidden으로 추가
			- 커뮤니티 등록창 뒤에 추가
			- 커뮤니티 등록창은 감춤
		3. 수정 버튼 클릭 이벤트를 등록(2번에서 만든 수정창에 있는 수정 버튼)
			- 커뮤니티 번호와 커뮤니티 명을 전송
			- post로 전송
		컨트롤러
		1. 메소드를 추가
			-PostMappin 추가
			-커뮤니티 번호와 커뮤니티 명을 가져옴
			-서비스에게 커뮤니티 번호와 커뮤니티 명을 주면서 수정하라고 요청
			-결과에 따라 알림을 출력	
		 -->

</body>
</html>