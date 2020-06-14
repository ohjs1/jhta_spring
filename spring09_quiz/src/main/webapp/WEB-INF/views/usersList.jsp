<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
  <h2>전체 회원 정보</h2>
  <p>가입된 전체 유저 목록 테이블 입니다.</p>            
  <table class="table table-striped">
    <thead>
      <tr>
        <th>아이디</th>
        <th>이메일</th>
        <th>가입일</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${ usersListAll }" var="ulist">
      <tr>
        <td>${ ulist.id }</td>
        <td>${ ulist.email }</td>
        <td>${ ulist.mydate }</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
		<nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-center">
		  <c:choose>
		  	<c:when test="${ pageNum ==1 }">
			  	<li class="page-item disabled">
			      	<a class="page-link" href="<%=request.getContextPath() %>/member/view/users?pageNum=${pageNum - 1}" tabindex="-1">Previous</a>
			    </li>
		  	</c:when>
		  	<c:otherwise>
		  		<li class="page-item enable">
			      	<a class="page-link" href="<%=request.getContextPath() %>/member/view/users?pageNum=${pageNum - 1}" tabindex="-1">Previous</a>
			    </li>
		  	</c:otherwise>
		  </c:choose>
		    <c:forEach begin="${ sNum }" end="${ eNum }" var="i">
		    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath() %>/member/view/users?pageNum=${i}">${ i }</a></li>
			</c:forEach>
			<c:choose>
				<c:when test="${ pageNum == maxPageCount }">
					<li class="page-item disabled">
		      			<a class="page-link" href="<%=request.getContextPath() %>/member/view/users?pageNum=${pageNum + 1}">Next</a>
		    		</li>
				</c:when>
				<c:otherwise>
				    <li class="page-item">
				      <a class="page-link" href="<%=request.getContextPath() %>/member/view/users?pageNum=${pageNum + 1}">Next</a>
				    </li>
				</c:otherwise>
			</c:choose>		   
		  </ul>
		</nav>
</div>