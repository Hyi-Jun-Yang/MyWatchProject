<%@page import="project.com.contents.ContentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reply Select Page</title>
<link href ="resources/css/contents.css" rel="stylesheet"/>
</head>
<body>
<div>
	<h1>Reply Select Page</h1>
</div>
<div>
	<section>
    	<form action="c_searchList.do" method="post">
		<table>
			<tr>
				<th>CON_ID</th>
				<th>CON_NAME</th>
				<th>CON_WRITER</th>
				<th>REPLY</th>
				<th>REPLYLEVEL</th>
				<th>REPLYCONTEXT</th>
				<th>REPLYPROFILE</th>
				<th>REGEDATE</th>
				<th>DEL<th>
				
			</tr>
			
			<%List<ContentVO> rlist =(List)request.getAttribute("rlist"); 
				for(ContentVO vo : rlist){ %>
			<tr>
			 <td><a href="c_search.do?con_id=<%=vo.getCon_id()%>"><%=vo.getCon_id()%></a></td>
			 <td><%=vo.getCon_name()%></td>
			 <td><%=vo.getCon_writer()%></td>
			 <td><%=vo.getReply()%></td>
			 <td><%=vo.getReplylevel()%></td>
			 <td><%=vo.getReplycontext()%></td>
			 <td><%=vo.getReplyprofile()%></td>
			 <td><%=vo.getCon_regedate()%></td>
			 <td><a href="c_delete.do?con_id=<%=vo.getCon_id()%>&replylevel=<%=vo.getReplylevel()%>">
			 	 DEL</a></td>
			  
			</tr>
			 <%} %>
			<tr>
			  <td colspan="7">
			  	<select name="key">
			  		<option value="con_id">컨텐츠 번호</option>
			  		<option value="con_name">컨텐츠명</option>
			  		<option value="con_limit">연령등급</option>	
			  	</select>
			  	<input type="text" name="value" value="">
			  	<input type="submit" value="검색"/>
			  </td>
			</tr> 
		</table>
		</form>
	</section>
</div>

</body>
</html>