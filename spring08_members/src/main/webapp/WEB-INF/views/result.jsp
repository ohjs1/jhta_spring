<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${ code=='success' }">
		<h1>요청작업 성공!</h1>
	</c:when>
	<c:otherwise>
		<h1>요청작업 실패!</h1>
	</c:otherwise>
</c:choose>
<a href="${ pageContext.request.contextPath }/">메인으로</a>
</body>
</html>