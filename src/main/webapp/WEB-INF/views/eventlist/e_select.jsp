
<%@page import="project.com.eventlist.EventListVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EventList Select</title>
<link href="resources/contents.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div>
		<header>
			<h1>Event List Select</h1>	
		</header>
	</div>
	<div>
		<section>
			<form action="e_searchList.do" method="post">
				<table>
					<tr>
					<th>E_ID</th>
					<th>E_TITLE</th>
					<th>E_REGDATE</th>
					<th>WIN_COUNT</th>
					<th>E_CONTENT</th>
					<th>E_START</th>
					<th>E_END</th>
					<th>E_DEL</th>
					<%List<EventListVO> list = (List)request.getAttribute("list"); %>
					</tr>
						<%for(EventListVO x : list){ %>
						<tr>
						<td><a href="e_search.do?e_id=<%=x.getE_id()%>"><%=x.getE_id()%></a></td>
						<td><%=x.getE_title()%></td>
						<td><%=x.getE_regdate()%></td>
						<td><%=x.getWin_count()%></td>
						<td><%=x.getE_content()%></td>
						<td><%=x.getE_start()%></td>
						<td><%=x.getE_end()%></td>
						<td><a href="e_deleteOK.do?e_id=<%=x.getE_id()%>">delete</a></td>
						</tr>
						<%} %>
					<tr>
					  <td colspan="8">
						<select name="searchKey">
							<option value="e_id">이벤트번호</option>
							<option value="e_title">이벤트명</option>
						</select>
					 <Input type="text" name="searchWord" value=""/>
					 <Input type="submit" value="찾기"/>
					 </td>
					 	
					</tr>	
					
					
				</table>
			</form>
		</section>
	</div>
</body>
</html>