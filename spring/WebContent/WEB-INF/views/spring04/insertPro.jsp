<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>!!! Insert Pro !!!</h2>

	<c:if test="${result ==1 }">
		<h3>${testDTO.id } 님, 회원가입 완료</h3>
	</c:if>
	<c:if test="${result !=1 }">
		<script>
			alert("회원가입 실패");
			history.go(-1);
		</script>
	</c:if>
</body>
</html>