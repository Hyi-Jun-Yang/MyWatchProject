<%@page import="project.com.product.ProductVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product Select View</title>
<link href="resources/contents.css" rel="stylesheet" />
</head>
<body>
	<div>
		<header>
			<h1>product Select</h1>
		</header>
	</div>
	<div>
		<section>
			<form action="p_searchList.do" method="post">
				<table>
					<tr>
						<th>P_NUM</th>
						<th>P_NAME</th>
						<th>P_COUNT</th>
						<th>P_LEVEL</th>
						<th>삭제</th>
					</tr>
					<%
						List<ProductVO> list;
						if(request.getAttribute("list")!=null){
						list = (List) request.getAttribute("list");
						for (ProductVO vo : list) {
					%>
					<tr>
						<td><a href="p_search.do?p_num=<%=vo.getP_num()%>"><%=vo.getP_num()%></a></td>
						<td><%=vo.getP_name()%></td>
						<td><%=vo.getP_count()%></td>
						<td><%=vo.getP_level()%></td>
						<td><a href="p_deleteOK.do?p_num=<%=vo.getP_num()%>">삭제</a></td>
						<%
							}
						%>
					<%
						}
					%>
					
					</tr>

					<tr>
						<td colspan="5">
							<select name="searchKey">
								<option value="p_num">상품번호</option>
								<option value="p_name">상품명</option>
							</select>
						<input type="text" name="searchWord" value="" /> 
						<input type="submit" value="검색" /></td>
					</tr>


				</table>
			</form>

		</section>
	</div>




</body>
</html>