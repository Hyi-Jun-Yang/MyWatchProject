<%@page import="project.com.cust.CustVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
input {
	display: inline-block;
}
</style>
<link href ="resources/css/watch.css" rel="stylesheet"/>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">
</script>
<script>

	$(function() {
			
		$("button").click(function() {
			$("#e_office", opener.document).val($("#zipcode").val());
				window.close();		
		});
	});
	
	
</script>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 검색</title>
</head>
<body>
	<header>
		<h1>우편번호검색</h1>
	</header>
	<c:if test="${zipcode==null }">
	<br>
	<form action="zipcodeSearch.do" method="post">
		<select id="dong" name="dong">
			<option></option>
			<c:forEach var="svo" items="${dongList}">
				<option value="${svo.dong}">${svo.dong}</option>
			</c:forEach>
		</select>
		<input type="submit" value="검색"/>
	</form>
	</c:if>
	
	<c:if test="${zipcode!=null }">
	<br>
	<select id="zipcode" name="zipcode">
			<option></option>
			<c:forEach var="vo" items="${zipcode}">
				<option value="(${vo.zipcode})${vo.sido} ${vo.gugun} ${vo.dong} ${vo.ri}">(${vo.zipcode})${vo.ri}</option>
			</c:forEach>
		</select>
	<button>확인</button>
	<a href="cu_insert.do"><button>취소</button></a>
	</c:if>
</body>
</html>