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
	<c:choose>
		<c:when test="${ pu.pageNum == i }">
			<a href="/spring10/board/list?pageNum=${i }&field=${field}&keyword=${keyword}"><span style="color:blue">${ i }</span></a>
		</c:when>
		<c:otherwise>
			<a href="/spring10/board/list?pageNum=${i }&field=${field}&keyword=${keyword}"><span style="color:gray">${ i }</span></a>
		</c:otherwise>
	</c:choose>
		
	</c:forEach>
</div>
<a href="/spring10/board/list">전체글보기</a>
<!-- 검색 -->
<form method="post" action="/spring10/board/list">
	<select name="field">
		<option value="title"
		<c:if test="${ field == 'title' }">selected></c:if>>제목</option>
		
		<option value="writer"
		<c:if test="${ field == 'writer' }">selected></c:if>>작성자</option>
		
		<option value="content"
		<c:if test="${ field == 'content' }">selected></c:if>>내용</option>
	</select>
	
	<input type="text" name="keyword" value="${ keyword }">
	<input type="submit" value="검색">
</form>
</body>
</html>









