<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EventList Insert</title>
<link href="resources/contents.css" rel="stylesheet" type="text/css"/>
</head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">
</script>
<script></script>
<body>
	<div>
		<header>
			<h1>Event List Insert</h1>	
		</header>
	</div>
	<div>
		<section>
			<form action="e_insertOK.do" method="post">
				<table>
					<tr>
						<td>E_Title</td>
						<td><Input type="text" name="e_title" value="x-mas"/></td>
					</tr>
					<tr>
						<td>E_Content</td>
						<td><textarea type="text" name="e_content" cols="40" rows="5">BigEvent!!</textarea></td>
					</tr>
					<tr>
						<td>WIN_COUNT</td>
						<td>
						<select name="win_count">
						<%for(int i=0;i<10;i++) {%>
						<option value="<%=i%>"><%=i%></option>
						<%}%>	
						</select>
					</tr>
					<tr>
						<td>E_Start</td>
						<td><Input type="date" name="e_start" value=""/></td>
					</tr>
					<tr>
						<td>E_End</td>
						<td><Input type="date" name="e_end" value=""/></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="입력"/>
							<input type="reset" value="취소"/>
						</td>
					</tr>
				
				</table>
			</form>
		</section>
	</div>
</body>
</html>