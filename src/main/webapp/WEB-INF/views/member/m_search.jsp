<%@page import="project.com.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Search</title>
<link href ="resources/css/watch.css" rel="stylesheet"/>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">
</script>
</head>
<script>
	$(function() {
		$("#delete").click(function(){
			var result =confirm("정말삭제");
			if(result){
				return true;
			}
			else{
				return false;
			}
				
		});
	});


</script>
<body>
<div>
	<header>
		<h1>회원정보 수정</h1>
	</header>
</div>
	<br>
	<section>
			<%MemberVO mvo =(MemberVO)request.getAttribute("mvo");
			  String user_id =(String)session.getAttribute("user_id");
			%>
		<form action="m_update.do" method="post" 
			enctype="multipart/form-data" modelAttribute="uploadForm">
		<table>	
			<tr id="view" align="left">
				<td>아이디</td>
				<td>
				<input type="hidden" name="m_id" value="<%=mvo.getM_id()%>"/>
				<%=mvo.getM_id()%>
			 	</td>
			</tr> 
			<tr id="view" align="left">
				<td>이름</td>
			 	<td>
			 	<input type="text" name="m_name" value="<%=mvo.getM_name()%>"/>
				</td>	 
			</tr> 
			<tr id="view" align="left">
				<td>패스워드</td>
				<td>
			 	<input type="password" name="m_pw" value="<%=mvo.getM_pw()%>"/>
				</td>
			</tr>		
			<tr id="view" align="left"> 
				<td>이메일</td>
			 	<td>
			 	<input type="text" name="m_email" value="<%=mvo.getM_email()%>"/>
				</td>
			</tr> 
			<tr id="view" align="left">
				<td>생일</td>
				<td>
			 	<input type="date" name="m_birthday" value="<%=mvo.getM_birthday()%>"/>
				</td>
			</tr>
			
			<tr id="view" align="left">
				<td>프로필</td>
				<td>
			 	<input type="file"  name="mutilpartfile"/>
				</td>
			</tr>
		 	<tr id="view" >
		 		<td colspan="3">
		 		<input type="submit" value="수정"/>
		 		<%if(user_id.compareTo("admin")==0){%>
		 		<a href="m_delete.do?m_id=<%=mvo.getM_id()%>" id="delete">
		 		<input type="button" value="삭제" /></a>
		 		<%} %>
		 		<a href="index.do"><input type="button" value="취소"/></a>
		 		</td>
		 	</tr>
		
		</table>
		</form>
	</section>


</body>
</html>