<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/spring14/resources/js/jquery-3.5.1.min.js"></script>
</head>
<body>
<p>
	<a href="/spring14/json">json가기</a>
</p>

<input type="button" value="btn1" id="btn1"/>
<div id="list">
<!-- 회원번호를 입력받아 해당 회원의 정보를 조회해 보세요. -->
회원번호 <input type="text" name="num"/><br>
<input type="button" value="조회" id="btn2" /><br>
<div id="result"></div>
</div>
</body>
<script type="text/javascript">
	$(function(){
		$("#btn1").click(function(){
			$.ajax({
				url : '/spring14/member/list',
				dataType : "json",
				success: function(data){
					$(data).each(function(i, mem){
						var str = mem.num + "," + mem.name + "," + mem.phone + "," +
						mem.addr + "," + mem.regdate;
						
						$("#list").append("<div>" + str + "</div>");
					});
				}
			});
		});
		
		$("#btn2").click(function(){
			var num = $("input[name='num']").val();
			$.getJSON("/spring14/member/info/" + num, function(data){
				if(data.error == 'sucess'){
					$(data).each(function(i, mem){
						var str = "이름:" + mem.name + ", 주소:," + mem.addr + ", 폰번호:" + mem.phone;
						$("#result").append(str);
					});
				} else {
					$("#result").empty();
					$("#result").html("조회된 정보가 없습니다.");
				}
			});
			
			/* $.ajax({
				url: '/spring14/member/info/' + num,
				dataType: "json",
				success: function(data){
					if(data.error == 'sucess'){
						$(data).each(function(i, mem){
							var str = "이름:" + mem.name + ", 주소:," + mem.addr + ", 폰번호:" + mem.phone;
							$("#result").append(str);
						});
					} else {
						$("#result").empty();
						$("#result").html("조회된 정보가 없습니다.");
					}
				}
			}); */
		});
	});
</script>
</html>