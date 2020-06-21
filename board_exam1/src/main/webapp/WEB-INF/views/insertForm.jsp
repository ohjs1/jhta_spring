<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
<h1>게시글 작성</h1>
<form action="/board/write" method="post">
	작성자<input type="text" name="writer"/><br>
	제목<input type="text" name="title"/><br>
	내용 <textarea name="content" cols="30" rows="10"></textarea><br>
	<input type="submit" value="전송" />
</form>
</body>
</html>