<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="<%=request.getContextPath() %>/join_ok">
  <div class="form-group">
    <label for="id">ID:</label>
    <input type="text" class="form-control" id="id">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="pwd">
  </div>
  <div class="form-group">
    <label for="email">email:</label>
    <input type="email" class="form-control" id="email">
  </div>

  <button type="submit" class="btn btn-default">가입 하기</button>
</form>