<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/list.jsp</title>
</head>
<body>
<h1>게시글목록</h1>
<table border="1" width="500">
	<tr>
		<th>글번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>작성일</th>
	</tr>
	<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.num }</td>
			<td>${vo.writer }</td>
			<td><a href="/spring10/board/detail?num=${vo.num }">${vo.title }</a></td>
			<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd" var="regdate"/>
			<td>${regdate}</td>
		</tr>
	</c:forEach>
</table>
<div>
	<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
		<a href="/spring10/board/list?pageNum=${i }">${i }</a>
	</c:forEach>
</div>
</body>
</html>









