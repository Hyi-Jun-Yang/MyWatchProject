<%@page import="project.com.cust.CustVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cust Search View</title>
<link href="resources/contents.css" rel="stylesheet" />
</head>
<body>
	<div>
		<header>
			<h1>Cust Search</h1>
		</header>
	</div>
	<div>
		<section>
			<form action="cu_updateOK.do" method="post">
				<table>
					<% CustVO svo = (CustVO)request.getAttribute("svo"); %>
					<tr>
						<td>C_NUM</td>
						<td><%=svo.getC_num()%></td>
					</tr>	
					<tr>
						<td>C_NAME</td>
						<td><Input type="text" name=c_name value="<%=svo.getC_name()%>"/></td>
					</tr>
					<tr>
						<td>C_Tel</td>
						<td><Input type="hidden" name=c_tel value="<%=svo.getC_tel()%>"/><%=svo.getC_tel()%></td>
					</tr>
					<tr>
						<td colspan="2"><Input type="submit" value="수정"/></td>
					</tr>	

	
				</table>
			</form>

		</section>
	</div>




</body>
</html>