<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/update.jsp</title>
</head>
<body>
	<form action="${ pageContext.request.contextPath }/updateOk">
		회원번호 <input type="text" name="num" value="${ updatelist.getNum() }" readonly="readonly"><br>
		이름 <input type="text" name="name" value="${ updatelist.getName() }"><br>
		전화번호 <input type="text" name="phone" value="${ updatelist.getPhone() }"><br>
		주소 <input type="text" name="addr" value="${ updatelist.getAddr() }"><br>
		<input type="submit" value="가입">
	</form>
</body>
</html>