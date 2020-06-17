<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btn1").click(function(){
			$.ajax({
				url: '/spring12/member/xml',
				dataType: "xml",
				success: function(data){
					$(data).find("member").each(function(d){
						var num = $(this).find("num").text();
						var name = $(this).find("name").text();
						var phone = $(this).find("phone").text();
						var addr = $(this).find("addr").text();
						var regdate = $(this).find("regdate").text();
						
						var html = "이름:" + num + "<br>" +
									"폰번호:" + phone + "<br>" +
									"주소:" + addr + "<br>" +
									"가입일:" + regdate + "<br>";
							
						$("#list").append(html);
					});
				}
			});
		});
		
		$("#btn2").click(function(){
			//alert("btn2");
			$.ajax({
				url: '/spring12/login/xml',
				dataType: "xml",
				success: function(data){
					var name = $(data).find("login").find("name").text();
					var email = $(data).find("login").find("email").text();
					var id = $(data).find("login").find("id").text();
					
					var name_t = $("input[name='name']").val();
					var email_t = $("input[name='email']").val();
					
					
					if(name == name_t && email == email_t){
						$("#result").html("조회된 아이디 : " + id);
					}
 				}
			});
		});
	});
</script>
</head>
<body>
	<input type="button" id="btn1" value="버튼1"/>
	<div id="list"></div>
	
	<h1>아이디찾기</h1>
	<!-- 이름과 이메일을 입력받아 해당하는 id를 조회해서 result에 출력해 보세요. -->
	이름 <input type="text" name="name"/><br>
	이메일 <input type="email" name="email"/><br>
	<input type="button" value="버튼2" id="btn2" />
	<div id="result"></div>
</body>
</html>