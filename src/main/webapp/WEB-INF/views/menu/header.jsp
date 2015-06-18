<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%String user_id =(String)session.getAttribute("user_id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="resources/js/jquery-1.11.2.js"></script>
<%-- <jsp:include page="../menu/side_left.jsp"></jsp:include> --%>



<div id="top">

	<div id="side_left">
	<label><font size="6" style="font-weight: bold;"><a href="index.do">HOME</a></font>
	<input id="button" type="image" src="resources/img/icon/menu.png" /></label>
	<br>
	<nav id="menu">
				<ul >
					<li><a href="cu_insert.do">Event</a></li>
				 	<c:if test="${user_id =='admin'}">
					<li><a href="manager.do">Manager</a></li>
					</c:if>
				</ul>
	</nav>
	<script>
	$(document).ready(function() {
		$("#menu").hide();
		$("#button").click("click",function(){
			$("#menu").toggle("slow",function(){
			});
		});

	});	
		
	</script>
</div>
	<table>
			<tr align="left">
			  <td>
				<form action="watchList.do" method="post">
			  	<textarea rows="1" cols="70" name="word"></textarea>
			  	<input type="image" src="resources/img/icon/search.png" />
				
				<%
				if(session.getAttribute("user_id")!=null){
				%>				
				<a href="logout.do"><input type="button" value="로그아웃"/></a>
				<a href="m_search.do?m_id=<%=user_id%>"><input type="button" value="회원정보"></a>
				<%} else{%>
				<a href="login.do"><input type="button" value="로그인"/></a>
				<a href="join.do"><input type="button" value="회원가입"/></a>
				
				<%} %>
				<a href="file_upload.do">
				<input type="button" value="업로드"/>
				</a>
			</form>
			  </td>
			</tr>
			</table>
	</div>
</body>
</html>