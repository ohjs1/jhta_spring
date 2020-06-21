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
<h1>전체게시글</h1>
<table border="1">
	<tr>
		<th>번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>내용</th>
		<th>조회수</th>
		<th>작성일</th>
	</tr>
	<c:forEach items="${ list }" var="li">
		<tr>
			<td>${ li.num }</td>
			<td>${ li.writer }</td>
			<td>${ li.title }</td>
			<td>${ li.content }</td>
			<td>${ li.hit }</td>
			<td>${ li.regdate }</td>
		</tr>
	</c:forEach>
</table>
	<c:if test="${ pu.endPage > pu.pageBlockCount }">
		<a href="/board/list?pageNum=${ pu.startPage - pu.pageBlockCount }">[이전]</a>
	</c:if>
	<c:forEach begin="${ pu.startPage }" end="${ pu.endPage }" var="i">
		<a href="/board/list?pageNum=${ i }">${ i }</a>
	</c:forEach>
	<c:if test="${ pu.endPage < pu.totalPage }">
		<a href="/board/list?pageNum=${ pu.startPage + pu.pageBlockCount }">[다음]</a>
	</c:if>
	
	<form action="/board/list" method="post">
		<select name="field">
			<option value="title" <c:if test="${ field == title }"> selected</c:if>>제목</option>
			<option value="writer" <c:if test="${ field == writer }"> selected</c:if>>글쓴이</option>
			<option value="content" <c:if test="${ field == content }"> selected</c:if>>글내용</option>
		</select>
		<input type="text" name="keyword" value="${ keyword }"/>
		<input type="submit" value="검색" />
	</form>
</body>
</html>