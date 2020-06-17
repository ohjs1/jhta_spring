<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style type="text/css">
	.commlist {
		background-color: skyblue;
		width: 560px;
		border: 2px solid gray;
	}
</style>
</head>
<body>
<h1>영화정보</h1>
<div>
	<h1>${ title }</h1>
</div>
<div id="movieComments">
	<!-- 댓글목록 -->
	<div id="commList"></div>
	<!-- 페이징처리 -->
	<div id="page"></div>
	<div id="commAdd">
		아이디 <input type="text" id="writer" /><br />
		영화평 <textarea id="content" cols="40" rows="3"></textarea><br>
		<input type="button" id="addBtn" value="전송"/>
	</div>
</div>
</body>
<script type="text/javascript">
	$(function(){
		getList(1);
		
		
	});
	
	function getList(pageNum){
		$("#commList").empty();
		$.ajax({
			url: '/spring13/comments/list',
			data: {
				pageNum:pageNum,
				mnum: ${mnum}
			},
			dataType: "xml",
			success:function(data){
				//alert(data);
				$(data).find("list").each(function(){
					var num = $(this).find("num").text();
					var mnum = $(this).find("mnum").text();
					var id = $(this).find("id").text();
					var comments = $(this).find("comments").text();
					
					/* console.log(num);
					console.log(mnum);
					console.log(id);
					console.log(comments); */
					
					var html = "<div class='commlist'>"+ "[작성자]" + id + 
					"<br> 내용 <br>" + comments
					"</div>";
					
					$("#commList").append(html);
				});
				
				//페이징 처리
				var pageHTML = "";
				var startPageNum = parseInt( $(data).find("startPageNum").text() )
				var endPageNum = parseInt( $(data).find("endPageNum").text() )
				var pageCount = parseInt( $(data).find("pageCount").text() )
				
				if(startPageNum > 5){
					pageHTML += "<a href='javascript:getList(" + (startPageNum-1) + ")'>이전</a>";
				}
				
				for(var i=startPageNum; i<=endPageNum; i++){
					if(i == pageNum){
						pageHTML += "<a href='javascript:getList(" + i + ")'><span style='color:red'>[" + i + "]</span></a>";
					} else {
						pageHTML += "<a href='javascript:getList(" + i + ")'><span style='color:gray'>[" + i + "]</span></a>";
					}
				}
				
				if(endPageNum < pageCount){
					pageHTML += "<a href='javascript:getList(" + (endPageNum+1) + ")'>다음</a>";
				}
				
				$("#page").html(pageHTML);
			}
		});
	}
</script>
</html>