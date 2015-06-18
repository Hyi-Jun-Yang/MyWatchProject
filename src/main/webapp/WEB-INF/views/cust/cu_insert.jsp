
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cust Insert View</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<link href ="resources/css/watch.css" rel="stylesheet"/>
<script>
	$(function(){
		var ischeck=false;
		$("#btn").click(function(){
			$.ajax({
				type:"post",
				url:"telCheck.do",	
				data:{
					c_name : $("#c_name").val(),
					c_tel : $("#c_tel").val(),
					e_office : $("#e_office").val()
				},
				dataType:"json",
				success: function(responseData){
					 if(responseData.result=="fail"){
						alert("이미 이벤트에 등록 하셨습니다.");
						ischeck=false;
					}else{
						alert("이벤트에 참여 가능 합니다.");
						ischeck=true;
					}
					 
				},
				error :function(){
					alert("Error");
				}
				
			});
			return false;
		});
		
		$("form").submit(function(){
			if(ischeck==true){
				return true;	
			}else{
				alert("응모여부를 체크해 주세요");
				return false;
			}
		
		});
		
		
	});
	
	function popup(){
		window.open('popup.do');
	}
</script>

</head>
<body>
	<header>
			<h1>Event Page</h1>
		</header>

	<br>
	<div>
		<form action="cu_insertOK.do" method="post">
		<section>
				<table>
					<tr align="left">
					<td>이름</td>
						<td><Input type="text" name="c_name" id="c_name" value="yang"/></td>
					</tr>
					<tr align="left">
						<td>전화번호</td>
						<td><Input type="text" name="c_tel" id="c_tel" value="010-9999-9999"/>
						<button id="btn">응모 여부</button>
						</td>
					</tr>
					<tr align="left">
						<td>이벤트장소</td>
						<td colspan="2">
							<Input type="text" name="e_office" id="e_office" value=""/>
							<input type="button" onclick="javascript:popup();" value="주소 검색" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
						<Input type="submit" value="응모하기">
						
						<a href="index.do"><Input type="button" value="그만하기"/></a></td>
					</tr>	

	
				</table>
	 		</section>
		</form>
	</div>



</body>
</html>