<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link href ="resources/css/watch.css" rel="stylesheet"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script>
	
	$(function(){

	$("form").submit(function() {
			if ($("#user_id").val().length === 0) {
				alert("아이디를 입력하세요");
				return false;
			}

			if ($("#user_pw").val().length === 0) {
				alert("패스워드를 입력하세요");
				return false;
			}
			
		});
		
	});
	
	
	
</script>
<body>
<div>
	<header>	
	<h1> 로그인</h1>
	</header>
</div>
 <br>
 	<c:choose>
	<c:when test="${check =='-1'}">
	<script>
		alert("패스워드를 다시 입력하세요"); 
	</script>
	</c:when>
	<c:when test="${check =='-2'}">
	<script>
		alert("아이디를 다시 입력하세요"); 
	</script>
	</c:when>
	<c:otherwise></c:otherwise>
	
	</c:choose>

 <form action="loginOK.do" method="post">

	<table>
		<tr>
		<td>아이디</td>
		<td >
		<input type="text" name="user_id" id="user_id" value="">
		</td>
		<tr>
		<tr>
		<td>패스워드</td>
		<td >
		<input type="password" name="user_pw" id="user_pw" value="">
		</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="입력">
			<a href="index.do"><input type="button" value="취소"></a>
		</tr>
	</table>
</form>
</body>
</html>