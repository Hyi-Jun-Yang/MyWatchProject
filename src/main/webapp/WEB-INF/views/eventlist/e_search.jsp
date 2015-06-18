<%@page import="project.com.eventlist.EventListVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EventList search</title>
<link href="resources/contents.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div>
		<header>
			<h1>Event List search</h1>	
		</header>
	</div>
	<div>
		<section>
			<form action="e_updateOK.do" method="post">
				<table>
					<%EventListVO svo = (EventListVO)request.getAttribute("svo"); %>
					<tr>
						<td><label>E_id</label></td>
						<td><Input type="number" name="e_id" value="<%=svo.getE_id() %>"/></td>
					</tr>
		
					<tr>
						<td>E_Title</td>
						<td><Input type="text" name="e_title" value="<%=svo.getE_title() %>"/></td>
					</tr>
					<tr>
						<td>E_Content</td>
						<td><Input type="text" name="e_content" value="<%=svo.getE_content()%>"/></td>
					</tr>
					<tr>
						<td>WIN_COUNT</td>
						<td>
						<select name="win_count">
						<%for(int i=0;i<10;i++) {%>
						<%if(i==svo.getWin_count()){ %>
							<option value="<%=svo.getWin_count()%>" selected><%=svo.getWin_count()%></option>
						<%} else {%>		
							<option value="<%=i%>"><%=i%></option>
							<%}%>	
						<%}%>		
						</select>
					</tr>
					<tr>
						<td>E_Start</td>
						<td><Input type="text" name="e_start" value="<%=svo.getE_start()%>"/></td>
					</tr>
					<tr>
						<td>E_End</td>
						<td><Input type="text" name="e_end" value="<%=svo.getE_end()%>"/></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="수정"/>
						</td>
					</tr>
				
				</table>
			</form>
		</section>
	</div>
</body>
</html>