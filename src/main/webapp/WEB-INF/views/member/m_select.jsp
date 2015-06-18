<%@page import="project.com.member.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Memeber Select Page</title>
<link href ="resources/css/contents.css" rel="stylesheet"/>
</head>
<body>
<div>
	<h1>Memeber Select Page</h1>
</div>
<div>
	<section>
		<form action="m_searchList.do" method="post">
		<table>
			<tr>
				<th>M_ID</th>
				<th>M_NAME</th>
				<th>M_PW</th>
				<th>M_EMAIL</th>
				<th>M_BIRTHDAY</th>
				<th>M_Profile</th>
				<th>M_JOINDATE</th>
			</tr>
			
			<%List<MemberVO> mlist =(List)request.getAttribute("mlist"); 
				for(MemberVO vo : mlist){ %>
			<tr>
			 <td><a href="m_search.do?m_id=<%=vo.getM_id()%>"><%=vo.getM_id()%></a></td>
			 <td><%=vo.getM_name()%></td>
			 <td><%=vo.getM_pw()%></td>
			 <td><%=vo.getM_email()%></td>
			 <td><%=vo.getM_birthday()%></td>
			 <td><%=vo.getM_profile() %></td>
			 <td><%=vo.getM_joindate()%></td>
			</tr>
			 <%} %>
			<tr>
			  <td colspan="7">
			  	<select name="key">
			  		<option value="m_id">아이디</option>
			  		<option value="m_name">이름</option>	
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