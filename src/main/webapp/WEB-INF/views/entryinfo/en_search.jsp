
<%@page import="project.com.entryinfo.EntryInfoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Entry Info Search</title>
<link href="resources/contents.css" rel="stylesheet">
</head>
<body>
	<div>
		<header> <h1>Entry Info Search</h1>
		</header>
	</div>
	<div>
		<section>
			<form action="en_updateOK.do" method="post">
				<%EntryInfoVO svo = (EntryInfoVO)request.getAttribute("svo"); %>
				<table>
					<tr>
						<td>E_NUM</td>
						<td><input type="hidden" name="e_num" value="<%=svo.getE_num()%>"><%=svo.getE_num()%></td>
					</tr>
					<tr>
						<td>E_DATE</td>
						<td><%=svo.getE_date()%></td>
					</tr>
					<tr>
						<td>E_OFFICE</td>
						<td><%=svo.getE_office()%></td>
					</tr>
					<tr>
						<td>E_ID</td>
						<td><%=svo.getE_id()%></td>
					</tr>
					<tr>
						<td>C_NAME</td>
						<td><%=svo.getC_name()%></td>
					</tr>
					<tr>
						<td>C_TEL</td>
						<td><%=svo.getC_tel()%></td>
					</tr>
					<tr>
						<td>IS_WIN</td>
						<td><%=svo.getIs_win()%></td>
					</tr>
					<tr>
						<td>WIN_RANK</td>
						<td><%=svo.getWin_rank()%></td>
					</tr>
					<tr>
						<td>WIN_DATE</td>
						<td><%=svo.getWin_date()%></td>
					</tr>
					<tr>
						<td>P_NUM</td>
						<td><%=svo.getP_num()%></td>
					</tr>
					<tr>
						<td>TAKE_RESULT</td>
						<td>
						<Input type="checkbox" name="take_result"/></td>
					</tr>
					
					<tr>
						<td>TAKE_OFFICE</td>
						<td>
						<select name="take_office">
							<option value=""></option>
							<option value="seocho">서초</option>
							<option value="yangjae">양재</option>
							<option value="gangnam">강남</option>
						</select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><Input type="submit" value="수정"/></td>
					</tr>
				
				</table>
			</form>
		</section>
	</div>
	
	
	
	
</body>
</html>