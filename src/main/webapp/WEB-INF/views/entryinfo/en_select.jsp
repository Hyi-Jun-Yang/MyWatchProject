<%@page import="project.com.entryinfo.EntryInfoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Entry Info select</title>
<link href="resources/contents.css" rel="stylesheet">
</head>

<body>
	<div>
		<header> <h1>Entry Info select</h1>
		</header>
	</div>
	
	<div>
		<section>
			<form action="en_searchList.do" method="post">
				<table>
				<%List<EntryInfoVO> list = (List)request.getAttribute("list"); %>
					<tr>
						<td colspan ="14">
							<select name="searchKey">
							<option value="e_num">응모번호</option>
							<option value="c_name">이름</option>
							<option value="c_tel">전화번호</option>
							</select>
							<Input type="text" name="searchWord" value=""/>
							<Input type="submit" value="찾기"/>
						</td>
					</tr>
					
					
					<tr>
					<th>E_NUM</th>
					<th>E_DATE</th>
					<th>E_OFFICE</th>
					<th>E_ID</th>
					<th>C_NAME</th>
					<th>C_TEL</th>
					<th>IS_WIN</th>
					<th>WIN_RANK</th>
					<th>WIN_DATE</th>
					<th>P_NUM</th>
					<th>TAKE_RESULT</th>
					<th>TAKE_DATE</th>
					<th>TAKE_OFFICE</th>
					<th>E_DEL</th>
					</tr>
					<%for(EntryInfoVO x : list ){ 
					String take_result = x.getTake_result()==0?"미수령":"수령";%>
					<tr>
						<td><a href="en_search.do?e_num=<%=x.getE_num()%>">
						<%=x.getE_num() %></a></td>
						<td><%=x.getE_date() %></td>
						<td><%=x.getE_office() %></td>
						<td><%=x.getE_id() %></td>
						<td><%=x.getC_name() %></td>
						<td><%=x.getC_tel() %></td>
						<td><%=x.getIs_win()%></td>
						<td><%=x.getWin_rank() %></td>
						<td><%=x.getWin_date() %></td>
						<td><%=x.getP_num() %></td>
						<td><%=take_result%></td>
						<td><%=x.getTake_date()%></td>
						<td><%=x.getTake_office()%></td>
						<td><a href="en_deleteOK.do?e_num=<%=x.getE_num()%>">delete</a></td>
					</tr>			
					<%}%>
					
					
				</table>
			</form>
		</section>	
	</div>
	
</body>
</html>