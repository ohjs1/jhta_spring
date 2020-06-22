<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div><!-- qna.jsp -->
	<h1>문의게시판</h1>
	<ul>
		<c:forEach var="a" items="${list }">
			<li>${a }</li>
		</c:forEach>
	</ul>
</div>