<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>main.jsp</title>
</head>
<body>
<ul>
<c:choose>
	<c:when test="${ id == null }">
		<li><a href="${ pageContext.request.contextPath }/login">로그인</a></li>
	</c:when>
	<c:otherwise>
		<li><a href="${ pageContext.request.contextPath }/logout">로그아웃</a></li>
	</c:otherwise>
</c:choose>
	<li><a href="${ pageContext.request.contextPath }/insert">회원가입</a></li>
	<li><a href="${ pageContext.request.contextPath }/list">회원목록</a></li>
</ul>
</body>
</html>