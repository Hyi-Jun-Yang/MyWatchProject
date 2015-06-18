<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Insert View</title>
<link href="resources/contents.css" rel="stylesheet" />
</head>
<body>
	<div>
		<header>
			<h1>Product Insert</h1>
		</header>
	</div>
	<div>
		<section>
			<form action="p_insertOK.do" method="post">
				<table>
					<tr>
					<td>P_NAME</td>
						<td><Input type="text" name=p_name value="car"/></td>
					</tr>
					<tr>
						<td>P_COUNT</td>
						<td><Input type="text" name=p_count value="10"/></td>
					</tr>
					<tr>
						<td>P_LEVEL</td>
						<td>
							<select name=p_level>
							<%for(int i =0;i<10;i++){ %>
							<option><%=i%></option>
							<%} %>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><Input type="submit" value="입력"/></td>
					</tr>	

	
				</table>
			</form>

		</section>
	</div>




</body>
</html>