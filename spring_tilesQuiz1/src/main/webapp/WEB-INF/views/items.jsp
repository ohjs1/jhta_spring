<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>	
	<h1>판매상품들</h1>
	<ul>	
		<c:forEach var="a" items="${list}">
		<li>${a}</li>
		</c:forEach>
	</ul>

</div>