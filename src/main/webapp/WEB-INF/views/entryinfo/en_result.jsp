
<%@page import="project.com.entryinfo.EntryInfoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Entry Info Search</title>
<link href="resources/css/watch.css" rel="stylesheet">
</head>
<body>
	<div>
		<header>
			 <h1>이벤트 결과 확인</h1>
		</header>
	</div>
	<div>
		<section>
		
			<c:if test="${evo.is_win==0}">
				<h1>꽝 다음 기회에 </h1>
				<br>
				<a href="index.do"><button>페이지이동</button></a>
			</c:if>
			<c:if test="${evo.is_win==1}">
			<form action="en_updateOK.do" method="post">
					<h1>${evo.win_rank } 등 당첨 되셨습니다.<br>
						 받으실 상품은${pvo.p_name}입니다.</h1>
					<br>	 
					<table>
					<tr>
						<td>수령 여부
						<Input type="hidden" name="e_num" value="${evo.e_num}"/>
						<Input type="checkbox" name="take_result"/></td>
						<td>받으실 곳</td>
						<td>
						<select name="take_office">
							<option value=""></option>
							<option value="seocho">서초</option>
							<option value="yangjae">양재</option>
							<option value="gangnam">강남</option>
						</select>
						</td>
					</tr>
					<tr>
						<td colspan="3">
						<Input type="submit" value="확인"/>
						<Input type="reset" value="취소"/>
						<a href="index.do"><Input type="button" value="다음에 하기"/></a></td>
					</tr>
				
				</table>
				</form>
			</c:if>	
		</section>
	</div>
	
	
	
	
</body>
</html>