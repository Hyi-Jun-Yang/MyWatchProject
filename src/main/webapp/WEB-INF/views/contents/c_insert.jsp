<%@page import="project.com.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String user_id=null;
if(session.getAttribute("user_id")!=null){
 	 user_id=(String)session.getAttribute("user_id");
  	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
<link href ="resources/css/watch.css" rel="stylesheet"/>
</head>
<body>
<div>
	<header>
	<h1>파일 업로드</h1>
	</header>
</div >
		<form action="c_insertOK.do" method="post" 
			  enctype="multipart/form-data" modelAttribute="uploadForm">
		<br>
		<table>	
			<tr id="view" align="left">
				<td>이름</td>
			 	<td>
			 	<input type="text" name="con_name" value="AAA"/>
				</td>
			</tr> 
			<tr id="view" align="left">
				<td>작성자</td>	
				<td>
			 	<input type="text" name="con_writer" value="<%=user_id%>"/>
				</td>
			</tr>		
			<tr id="view" align="left"> 
				<td>파일</td>
			 	<td align="center">
			 	<input type="file"  name="multipartFile"/>
				</td>
			</tr> 
			<tr id="view" align="left">
				<td>점수</td>
				<td>
			 	<input type="number" name="con_rank" value="0"/>
				</td>
			</tr>
			<tr id="view" align="left">
				<td>등급</td>
				<td>
				<select name="con_limit">
					<option value="0">All</option>
					<option value="12">12세 이상</option>
					<option value="15">15세 이상</option>
					<option value="18">18세 이상</option>		
				</select>	
			
				</td>
			</tr>
		 	<tr id="view">
		 		<td colspan="2">
		 		<input type="submit" value="입력"/>
		 		<input type="reset" value="취소"/>
		 		</td>
		 	</tr>
		
		</table>
		</form>


</body>
</html>