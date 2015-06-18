<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String con_id = request.getParameter("con_id"); 
	String user_id=null;   
	if(session.getAttribute("user_id")!=null){
  	 user_id=(String)session.getAttribute("user_id");
   	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reply</title>
<link href ="css/contents.css" rel="stylesheet"/>
</head>
<body>
<div>
	<h1>Reply Page</h1>
</div>
		<form action="replyOK.do" method="post" 
			enctype="multipart/form-data" modelAttribute="uploadForm">
		<input type="hidden" name="con_id" value="<%=con_id %>"/>
		<table>	
			<tr>
				<td>이름</td>
			 	<td>
			 	<input type="text" name="con_name" value="AAA"/>
				</td>
			</tr> 
			<tr>
				<td>작성자</td>	
				<td>
			 	<input type="text" name="con_writer" value="<%=user_id%>"/>
				</td>
			</tr>
			<tr>
				<td>내용</td>	
				<td>
			 	<input type="text" name="replycontext" value=""/>
				</td>
			</tr>		
			
			<tr> 
				<td>프로필</td>
			 	<td align="center">
			 	<input type="file"  name="multipartFile"/>
				</td>
			</tr> 
		 	<tr>
		 		<td colspan="2">
		 		<input type="submit" value="입력"/>
		 		<input type="reset" value="취소"/>
		 		</td>
		 	</tr>
		 	
		 	
		
		</table>
		</form>



</body>
</html>