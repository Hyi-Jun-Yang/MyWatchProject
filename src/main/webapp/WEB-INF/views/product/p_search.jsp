<%@page import="project.com.product.ProductVO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Search View</title>
<link href="resources/contents.css" rel="stylesheet" />
</head>
<body>
	<div>
		<header>
			<h1>Product Search</h1>
		</header>
	</div>
	<div>
		<section>
			<form action="p_updateOK.do" method="post">
				<table>
					<% ProductVO svo = (ProductVO) request.getAttribute("svo"); %>
					<tr>
						<td>P_NUM</td>
						<td><Input type="hidden" name=p_num value="<%=svo.getP_num()%>"/><%=svo.getP_num()%></td>
					</tr>	
					<tr>
						<td>P_NAME</td>
						<td><Input type="text" name=p_name value="<%=svo.getP_name()%>"/></td>
					</tr>
					<tr>
						<td>P_COUNT</td>
						<td><Input type="text" name=p_count value="<%=svo.getP_count()%>"/></td>
					</tr>
					<tr>
						<td>P_LEVEL</td>
						<td colspan="2">
							<select name=p_level>
							<%for(int i =0;i<10;i++){%>
								
								<% if(svo.getP_level()==i){%>
								<option value="<%=svo.getP_level()%>" selected><%=i%></option>
									
								<%} else{%>
								<option value="<%=i%>"><%=i%></option>
								<%} %>
							<%} %>
							
							</select>
						</td>
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