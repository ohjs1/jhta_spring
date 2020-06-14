<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
   <style>
  .fakeimg {
    height: 200px;
    background: #aaa;
  }
  </style>
<meta charset="UTF-8">
<title>spring / quest 0612</title>
<%
	String ipage = (String)session.getAttribute("ipage");
%>
</head>
<body>
<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>My First Bootstrap 4 Page</h1>
  <p>Resize this responsive page to see the effect!</p> 
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="<%=request.getContextPath() %>/">HOME</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath() %>/member/join">회원가입</a>
      </li>
      
      <c:choose>
      	<c:when test="${ loginchk == false || loginchk == '' || loginchk == null }">
		    <li class="nav-item">
		        <a class="nav-link" href="<%=request.getContextPath() %>/login">로그인</a>
		    </li>    
      	</c:when>
      	<c:otherwise>
      		<li class="nav-item">
		        <a class="nav-link" href="<%=request.getContextPath() %>/logout">로그아웃</a>
		    </li> 
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath() %>/member/view/users?pageNum=1">전체 유저 보기</a>
      </li>
      	</c:otherwise>
      </c:choose>
    </ul>
  </div>  
</nav>

<div class="container" style="margin-top:30px">
  	<div class="row">
  	<jsp:include page="/WEB-INF/views/${ ipage }.jsp"></jsp:include>
	</div>
</div>

<div class="jumbotron text-center" style="margin-bottom:0">
  <p>Footer</p>
</div>
</body>
</html>