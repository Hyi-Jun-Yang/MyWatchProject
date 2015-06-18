<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiels"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/contents.css" >
</head>
<body>
	<div id="header">
		<tiels:insertAttribute name="header"/>
	</div>
	
	<div id="content">
		<tiels:insertAttribute name="content"/>
	</div>
							
	<div id="footer">
		<tiels:insertAttribute name="footer"/>
	</div>
</body>
</html>