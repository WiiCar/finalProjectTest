<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test.jsp</title>
</head>
<body>
	<h1>Test Page</h1>
	
	<h3>count = ${requestScope.count }</h3>
	<h3>maxAge = ${requestScope.maxAge }</h3>
	<h3>userList = ${userList}</h3>
	<h3>userOne = ${user.id } / ${user.pw } / ${user.age } / ${user.reg }</h3>
	<h3>userReg = ${userReg }</h3>
	<h3>insert result = ${res }</h3>
	
	<c:forEach var="user" items="${userList }" varStatus="status">
		<h3>${status.count } : ${user.id } / ${user.pw } / ${user.age } / ${user.reg }</h3>
	</c:forEach>

</body>
</html>