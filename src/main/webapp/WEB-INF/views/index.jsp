<%@page import="project.com.contents.ContentVO"%>
<%@page import="project.com.member.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 


<%
	String user_id=(String)session.getAttribute("user_id");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<link href ="resources/css/watch.css" rel="stylesheet"/>
<script src="resources/js/jquery-1.11.2.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="menu/header.jsp"></jsp:include>
<div id="center">
			<c:if test="${wlist==null }">
			<table>	
			<tr align="left" >
				<td><h3>최근 동영상</h3></td>
			</tr>
			<c:forEach var="vo" items="${clist}">
			<tr id="view" align="left" class="col-sm-2">
			<td>	
				<a href="watch.do?con_id=${vo.con_id}&user_id=${user_id}">			 
			 	<img width="196" height="110" src="http://222.121.91.248:5000/${vo.con_link}.png"></a>
			 	<font color="blue" size="3"><a href="watch.do?con_id=${vo.con_id}&user_id=${user_id}">제목:${vo.con_name }</a></font><br>
				<font color="blue" size="2">게시자:${vo.con_writer}</font><br>
				<font color="blue" size="2">조회수:${vo.scount }</font><br>
				<font color="blue" size="2">게시일:${vo.con_regedate }</font><br>
			</td>	
			</tr>
			</c:forEach>
		
	    	<tr align="left">
				<td><h3>인기 Top 10</h3></td>
			</tr>
			<c:forEach var="vo" items="${tlist}">
			<tr id="view" align="left" class="col-sm-2">
			
			<td>	
				<a href="watch.do?con_id=${vo.con_id}&user_id=${user_id}">			 
			 	<img width="196" height="110" src="http://222.121.91.248:5000/${vo.con_link}.png"></a>
				<font color="blue" size="3"><a href="watch.do?con_id=${vo.con_id}&user_id=${user_id}">제목:${vo.con_name }</a></font><br>
				<font color="blue" size="2">게시자:${vo.con_writer}</font><br>
				<font color="blue" size="2">조회수:${vo.scount }</font><br>
				<font color="blue" size="2">게시일:${vo.con_regedate }</font><br>
			</td>	
			</tr>
			</c:forEach>
		
		<c:if test="${user_id != null}">
			<tr align="left">
				<td><h3>내 동영상</h3></td>
			</tr>
			<c:forEach var="vo" items="${mylist}">
			<tr id="view" align="left" class="col-sm-2">
			
				<td>	
				<a href="watch.do?con_id=${vo.con_id}&user_id=${user_id}">			 
			 	<img width="196" height="110" src="http://222.121.91.248:5000/${vo.con_link}.png"></a>
				<font color="blue" size="3"><a href="watch.do?con_id=${vo.con_id}&user_id=${user_id}">제목:${vo.con_name }</a></font><br>
				<font color="blue" size="2">게시자:${vo.con_writer}</font><br>
				<font color="blue" size="2">조회수:${vo.scount }</font><br>
				<font color="blue" size="2">게시일:${vo.con_regedate }</font><br>
				</td>	
			</tr>
			</c:forEach>
			<tr>
				<td class="line_default" height='30' align='center' colspan='7'/>
			</tr>
		</c:if>
		</table>
		</c:if>
	</div>	
		
		
		<c:if test="${wlist!=null}">
		<div id="lcenter">
			<table>
			<tr align="left">
				<td><h3>내가 검색한 동영상</h3></td>
			</tr>
			<c:forEach var="vo" items="${wlist}">
			<tr id="view" align="left" >
				<td colspan="2">	
				<a href="watch.do?con_id=${vo.con_id}&user_id=${user_id}">			 
			 	<img width="196" height="116" src="http://222.121.91.248:5000/${vo.con_link}.png"></a>
			 	</td>
			 	<td colspan="2">
				<font color="blue" size="3"><a href="watch.do?con_id=${vo.con_id}&user_id=${user_id}">제목:${vo.con_name }</a></font><br>
				<font color="blue" size="2">게시자:${vo.con_writer}</font><br>
				<font color="blue" size="2">조회수:${vo.scount }</font><br>
				<font color="blue" size="2">게시일:${vo.con_regedate }</font><br>
				</td>	
			</tr>
			<tr>
				<td class="line_default" height='30' align='center' colspan='7'/>
			</tr>
			</c:forEach>
			</table>
		</div>	
			
	<div id="side_right">
		 <table>
			<c:if test="${user_id!=null}">
			<tr align="left">
				<td><h3>내 동영상</h3></td>
			</tr>
			<c:forEach var="vo" items="${mylist}">
				<tr id="view" align="left">
					<td>
						<a href="watch.do?con_id=${vo.con_id}&user_id=${user_id}"> <img
							width="196" height="110"
							src="http://222.121.91.248:5000/${vo.con_link}.png"></a></td>
					<td>
					 <a href="watch.do?con_id=${vo.con_id}&user_id=${user_id}">제목:${vo.con_name }</a><br>
					  게시자:${vo.con_writer} <br>
					  조회수:${vo.scount }<br> 
					  게시일:${vo.con_regedate }</td>
				</tr>
				<tr>
				<td class="line_default" height='30' align='center' colspan='7'/>
			</tr>
			</c:forEach>
			</c:if>			
			
			<c:if test="${user_id==null}">
				<tr align="left">
				<td><h3>최근 동영상</h3></td>
			</tr>
			<c:forEach var="vo" items="${clist}">
				<tr id="view" align="left">
					<td>
						<a href="watch.do?con_id=${vo.con_id}&user_id=${user_id}"> <img
							width="196" height="110"
							src="http://222.121.91.248:5000/${vo.con_link}.png"></a></td>
					<td >
					 <a href="watch.do?con_id=${vo.con_id}&user_id=${user_id}">제목:${vo.con_name}</a><br>
					  게시자:${vo.con_writer} <br>
					  조회수:${vo.scount }<br> 
					  게시일:${vo.con_regedate }</td>
				</tr>
				<tr>
				<td class="line_default" height='30' align='center' colspan='7'/>
			</tr>
			</c:forEach>
			
			</c:if>
			
			
		</table>
	</div>
			
			
	</c:if>
		
		


	
</body>

</html>