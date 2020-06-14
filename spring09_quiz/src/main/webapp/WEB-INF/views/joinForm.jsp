<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="container">
	<form action="<%=request.getContextPath() %>/member/join" method="post">
	  <div class="form-group">
	    <label for="id">ID:</label>
	    <input type="text" class="form-control" id="id" name="id">
	  </div>
	  <div class="form-group">
	    <label for="pwd">Password:</label>
	    <input type="password" class="form-control" id="pwd" name="pw">
	  </div>
	  <div class="form-group">
	    <label for="email">email:</label>
	    <input type="email" class="form-control" id="email" name="email">
	  </div>
	
	  <button type="submit" class="btn btn-primary">가입 하기</button>
	</form>
	<br>
</div>