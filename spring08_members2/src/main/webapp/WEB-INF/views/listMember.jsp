<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <h2>회원 목록</h2>
  <p>가입된 회원들의 목록들 입니다.</p>            
  <table class="table table-condensed">
    <thead>
      <tr>
        <th>글번호</th>
        <th>이름</th>
        <th>폰번호</th>
        <th>주소</th>
        <th>가입일</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${ list }" var="i">
      <tr>
        <td>${ i.num }</td>
        <td>${ i.name }</td>
        <td>${ i.phone }</td>
        <td>${ i.addr }</td>
        <td>${ i.regdate }</td>
        <td><a href="${ pageContext.request.contextPath }/delete?num=${i.num}">삭제</a></td>
        <td><a href="${ pageContext.request.contextPath }/update?num=${i.num}">수정</a></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <br>
  <a href="${ pageContext.request.contextPath }/">메인으로</a>
</div>

</body>
</html>