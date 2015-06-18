
<%@page import="project.com.entryinfo.EventEntry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 String c_name = request.getParameter("c_name");
 String c_tel = request.getParameter("c_tel");
 String e_office = request.getParameter("e_office");
 
//e_id = 1,is_win=0, win_rank=2,  p_num = 3
 EventEntry ent = new EventEntry();
 int[] eResult = ent.getEntryResult(); 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Entry Info Insert</title>
<link href="resources/contents.css" rel="stylesheet">
</head>
<body>
	<div>
		<header> <h1>Entry Info Insert</h1>
		</header>
	</div>
	<div>
		<section>
			<form action="en_insertOK.do" method="post">
				<table>
					
					<tr>
						<td>E_OFFICE</td>
						<td><Input type="text" name="e_office" value="<%=e_office%>"/></td>
					</tr>
					<tr>
						<td>E_ID</td>
						<td><Input type="text" name="e_id" value="<%=eResult[0]%>"/></td>
					</tr>
					<tr>
						<td>C_NAME</td>
						<td><Input type="text" name="c_name" value="<%=c_name%>"/></td>
					</tr>
					<tr>
						<td>C_TEL</td>
						<td><Input type="text" name="c_tel" value="<%=c_tel%>"/></td>
					</tr>
					<tr>
						<td>IS_WIN</td>
						<td>
							<label>
								<Input type="number" name="is_win" value="<%=eResult[1]%>"/>
							</label>
						</td>
					</tr>
					
					<tr>
						<td>WIN_RANK</td>
						<td>
							<label>
								<Input type="number" name="win_rank" value="<%=eResult[2]%>"/>
							</label>
						</td>
					</tr>
					<tr>
						<td>P_NUM</td>
						<td>
							<label>
								<Input type="number" name="p_num" value="<%=eResult[3]%>"/>
							</label>
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