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
<!-- 사는 지역을 입력받아 해당 지역에 거주하는 회원목록 출력하기 -->
거주지 <input type="text" name="addr"/><br>
<input type="button" value="조회" id="btn1"/>
<div id="memlist"></div>
</body>

<script type="text/javascript">
	$("#btn1").click(function(){
		$("#memlist").empty();
		var addr = $("input[name='addr']").val();
		$.getJSON("/spring14/member/user", {"addr" : addr}, function(data){
			//alert(data);
			var str = "";
			$(data).each(function(i, mem){
				//alert(mem.num);

				str += "<hr>번호:" + mem.num + "<br> 이름 :" + mem.name + "<br> 폰번호:" + mem.phone + "<br> 주소:"+mem.addr +
				"<br>가입일:" + mem.regdate + "<hr>";
				
				$("#memlist").append(str);
			});
		});
			
	});
</script>
</html>