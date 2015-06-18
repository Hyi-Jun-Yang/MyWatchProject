
<%@page import="project.com.contents.ContentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contents Search</title>
<link href ="resources/css/contents.css" rel="stylesheet"/>
</head>
<body>
<div>
	<h1>Contents Search Page</h1>
</div>

		<%ContentVO cvo =(ContentVO )request.getAttribute("cvo");%>
		<form action="c_update.do" method="post" 
			  enctype="multipart/form-data" modelAttribute="uploadForm">
		<table>	
			<tr>
				<td>CON_ID</td>
				<td>
				<input type="hidden" name="con_id" value="<%=cvo.getCon_id()%>"/>
				<%=cvo.getCon_id()%>
			 	</td>
			</tr> 
			<tr>
				<td>CON_NAME</td>
			 	<td>
			 	<input type="text" name="con_name" value="<%=cvo.getCon_name()%>"/>
				</td>
			</tr> 
			<tr>
				<td>CON_WRITER</td>	
				<td>
			 	<input type="text" name="con_writer" value="<%=cvo.getCon_writer()%>"/>
				</td>
			</tr>		
			<tr> 
				<td>CON_LINK</td>
			 	<td>
			 	 FileName : <%=cvo.getCon_link()%>
			 	<br>
				<input type="file" name="multipartFile" value="<%=cvo.getCon_link()%>"/>
			 	</td>
			</tr> 
			<tr>
				<td>CON_RANK</td>
				<td>
			 	<input type="number" name="con_rank" value="<%=cvo.getCon_rank()%>"/>
				</td>
			</tr>
			<tr>
				<td>CON_LIMIT</td>
				<td>
			 	<input type="number" name="con_limit" value="<%=cvo.getCon_limit()%>"/>
				</td>
			</tr>
			
			
		 	<tr>
		 		<td colspan="2">
		 		<input type="submit" value="수정"/>
		 		<a href="c_delete.do?con_id=<%=cvo.getCon_id()%>">
		 		<input type="button" value="삭제"/></a>
		 		<input type="reset" value="취소"/>
		 		</td>
		 	</tr>
		
		</table>
		</form>



</body>
</html>