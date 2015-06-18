<%@page import="project.com.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Page</title>
<link href ="resources/css/watch.css" rel="stylesheet"/>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">
</script>
<script>
	$(function(){
		var isCheck =true;
		$("#btn").click(function(){
			$.ajax({
				type:"post",
				url:"m_check.do",
				data :{
					m_id : $("#m_id").val()
				},
				dataType:"json",
				success : function(responseData){
					if(responseData.result==='UnAvailable'){
						alert("동일 아이디가 존재 합니다.");
						isCheck = true;
					}else{
						alert("이용 가능 합니다.");
						isCheck = false;
					}
				},
				error : function(){
					alert("Error");
				}
							
			});
			return false;
	
		});
		$("form").submit(function() {
			if (isCheck) {
				alert("아이디 중복을 체크하세요.");
				return false;
			}
		});	
	});		
					
</script>

</head>

<body>
				

<div>
	<header>
	<h1>회원가입</h1>
	</header>
		 <br>
		<form action="m_insertOK.do" method="post"
		enctype="multipart/form-data" modelAttribute="uploadForm">
		<table >	
			<tr id="view" align="left">
				<td>아이디</td>
				<td>
				<input type="text" name="m_id" id="m_id" value="abhee24"/>
	            <input type="button" id="btn" value="중복체크">
			 	</td>
			</tr> 
			<tr id="view" align="left">
				<td>이름</td>
			 	<td>
			 	<input type="text" name="m_name" value="yang"/>
				</td>	 
			</tr>
			<tr id="view" align="left"> 
				<td>패스워드</td>
				<td><input type="password" name="m_pw" value="hi123456"/>
				</td>
			</tr>		
			<tr id="view" align="left"> 
				<td>이메일</td>
			 	<td>
			 	<input type="text" name="m_email" value="aaa.test"/>
				</td>
			</tr> 
			<tr id="view" align="left">
				<td>생일</td>
				<td>
			 	<input type="date" name="m_birthday" value=""/>
				</td>
			</tr>
		 	<tr id="view" align="left"> 
				<td>프로필</td>
			 	<td align="center">
			 	<input type="file"  name="mutilpartfile"/>
				</td>
			</tr>
		 	<tr id="view">
		 		<td colspan="2">
		 		<input type="submit" value="입력"/>
		 		<a href="index.do"><input type="button" value="취소"/></a>
		 		</td>
		 	</tr>
		 	
		
		</table>
		</form>
</div>


</body>
</html>