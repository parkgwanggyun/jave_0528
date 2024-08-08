<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<h1>메인 페이지</h1>
	<p>안녕하세요. 제 이름은 ${name} 나이는 ${age}입니다.</p>
	<!-- person.name은 실제로 person.getName()을 호출  -->
	<p>만나서 반갑습니다. 제 이름은 ${person.name }이고, 나이는${person.age} 살입니다.</p>
	<p>${person.test}</p>
	<a href="<%=request.getContextPath() %>?name=홍길동$age=21">이름은 홍길동, 나이는 21</a>
	<!-- 
	1. main.jsp에 회원가입 링크를 추가
		-링크는 / servlet1/signup
	2. signup 서블릿을 추가
		-views/signup.jsp와 연결
	3.signup.jsp와 연결-->
	<br>
	<a href="<%=request.getContextPath() %>/signup">회원가입</a>
	<br>
	<a href="<%=request.getContextPath() %>/login">로그인</a>
		${user }
</body>
</html>