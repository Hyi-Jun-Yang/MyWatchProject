<%@page import="project.com.cust.CustVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cust Select View</title>
<link href="resources/contents.css" rel="stylesheet" />
</head>
<body>
	<div>
		<header>
			<h1>Cust Select</h1>
		</header>
	</div>
	<div>
		<section>
			<form action="c_searchList.do" method="post">
				<table>
					<tr>
						<th>C_NUM</th>
						<th>C_NAME</th>
						<th>C_TEL</th>
						<th>JOIN_DATE</th>
						<th>삭제</th>
					</tr>
					<%
						List<CustVO> list = (List) request.getAttribute("list");
						for (CustVO vo : list) {
					%>
					<tr>
						<td><%=vo.getC_num()%></td>
						<td><%=vo.getC_name()%></td>
						<td><a href="cu_search.do?c_tel=<%=vo.getC_tel()%>"><%=vo.getC_tel()%></a></td>
						<td><%=vo.getJoin_date()%></td>
						<td><a href="cu_deleteOK.do?c_tel=<%=vo.getC_tel()%>">삭제</a></td>
						<%
							}
						%>

					</tr>

					<tr>
						<td colspan="5"><select name="searchKey">
								<option value="c_name">이름</option>
								<option value="c_tel">폰번</option>
						</select> <input type="text" name="searchWord" value="" /> <input
							type="submit" value="검색" /></td>
					</tr>


				</table>
			</form>

		</section>
	</div>




</body>
</html>