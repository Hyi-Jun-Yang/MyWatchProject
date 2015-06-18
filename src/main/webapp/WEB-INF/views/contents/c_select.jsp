<%@page import="project.com.contents.ContentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contents Select Page</title>
<link href ="resources/css/contents.css" rel="stylesheet"/>
</head>
<body>
<div>
	<h1>Contents Select Page</h1>
</div>
<div>
	<section>
    	<form action="c_searchList.do" method="post">
		<table>
			<tr>
				<th>CON_ID</th>
				<th>CON_NAME</th>
				<th>CON_WRITER</th>
				<th>CON_LINK</th>
				<th>CON_RANK</th>
				<th>CON_LIMIT</th>
				<th>CON_REGEDATE</th>
			</tr>
			
			<%List<ContentVO> clist =(List)request.getAttribute("clist"); 
				for(ContentVO vo : clist){ %>
			<tr>
			 <td><a href="c_search.do?con_id=<%=vo.getCon_id()%>"><%=vo.getCon_id()%></a></td>
			 <td><%=vo.getCon_name()%></td>
			 <td><%=vo.getCon_writer()%></td>
			 <td><%=vo.getCon_link()%></td>
			 <td><%=vo.getCon_rank()%></td>
			 <td><%=vo.getCon_limit()%></td>
			 <td><%=vo.getCon_regedate()%></td> 
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