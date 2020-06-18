<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
  font-family: Arial;
}

* {
  box-sizing: border-box;
}

form.example input[type=text] {
  padding: 10px;
  font-size: 17px;
  border: 1px solid grey;
  float: left;
  width: 80%;
  background: #f1f1f1;
}

form.example button {
  float: left;
  width: 20%;
  padding: 10px;
  background: #2196F3;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}

form.example button:hover {
  background: #0b7dda;
}

form.example::after {
  content: "";
  clear: both;
  display: table;
}

.checkbox {
	text-align: center;
}

.table {
	text-align: center;
}
</style>
</head>
<body>
	<h1>파일 리스트</h1>
	<table class="table">
  	<thead class="thead-dark">
    <tr>
      <th scope="col">번호</th>
      <th scope="col">작성자</th>
      <th scope="col">제목</th>
      <th scope="col">내용</th>
      <th scope="col">첨부파일</th>
      <th scope="col">첨부파일 크기</th>
      <th scope="col"></th>
      <th scope="col">다운로드</th>
    </tr>
  </thead>
  <tbody>
 
  <c:forEach items="${ flist }" var="f">
    <tr>
      <td>${ f.filenum }</td>
      <td>${ f.writer }</td>
      <td>${ f.title }</td>
      <td><a href="/spring11/update/file?filenum=${ f.filenum }">${ f.content }</a></td>
      <td><a href="/spring11/resources/upload/${ f.savefilename }">${ f.savefilename }</a></td>
      <td>${ f.filesize }</td>
      <td><a href="/spring11/del/file?filenum=${ f.filenum }">삭제</a></td>
      <td><a href="/spring11/file/download?filenum=${ f.filenum }">다운로드</a></td>
    </tr>
	</c:forEach>
  </tbody>
</table>
	
	<nav aria-label="...">
	  <ul class="pagination justify-content-center">
	    <c:choose>
	    	<c:when test="${ pg.pageNum == 1 }">
		    	<li class="page-item disabled">
			      	<a class="page-link" href="#" tabindex="-1">Previous</a>
		    	</li>	
	    	</c:when>
	    	<c:otherwise>
	    		<li class="page-item">
	    			<a class="page-link" href="/spring11/file/list?pageNum=${ pg.pageNum - 1 }" tabindex="-1">Previous</a>
	    		</li>
	    	</c:otherwise>
	    </c:choose>
	    <c:forEach var="i" begin="${ pg.startPage }" end="${ pg.endPage }">
		    <c:choose>
		    	<c:when test="${ i == pg.pageNum }">
				    <li class="page-item active"><a class="page-link" href="/spring11/file/list?pageNum=${ i }">${ i }</a></li>
		    	</c:when>
		    	<c:otherwise>
		    		<li class="page-item"><a class="page-link" href="/spring11/file/list?pageNum=${ i }">${ i }</a></li>
		    	</c:otherwise>
		    </c:choose>
	    </c:forEach>
	    
	    <c:choose>
	    	<c:when test="${ pg.pageNum == pg.endPage }">
	    		<li class="page-item disabled">
	    			<a class="page-link" href="#">Next</a>
	    		</li>
	    	</c:when>
	    	<c:otherwise>
	    		<li class="page-item">
	    			<a class="page-link" href="/spring11/file/list?pageNum=${ pg.pageNum + 1 }">Next</a>
	    		</li>
	    	</c:otherwise>
	    </c:choose>
	    
	    
	  </ul>
	</nav>
	
	<form class="example" action="/spring11/file/list?pageNum=${ pg.pageNum }" style="margin:auto;max-width:300px">
		 <input type="text" placeholder="Search.." name="keyword">
		 <button type="submit"><i class="fa fa-search"></i></button>
		 <div class="checkbox">
		      <input type="checkbox" name="searchbox" value="writer"
		      <c:if test="${ writer == 'checked' && writer != null }">
		      	checked="checked"
		      </c:if>
		      >작성자
		      <input type="checkbox" name="searchbox" value="title"
		      <c:if test="${ title == 'checked' && title != null }">
		      	checked="checked"
		      </c:if>
		      >제목
		      <input type="checkbox" name="searchbox" value="content"
		      <c:if test="${ content == 'checked' && content != null }">
		      	checked="checked"
		      </c:if>
		      >내용
		</div>
	</form>
</body>
</html>