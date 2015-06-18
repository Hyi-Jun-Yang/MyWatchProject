
<%@page import="java.util.List"%>
<%@page import="project.com.contents.ContentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Watch</title>
<link href ="resources/css/watch.css" rel="stylesheet"/>
<link href="http://vjs.zencdn.net/4.12/video-js.css" rel="stylesheet">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="http://vjs.zencdn.net/4.12/video.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<style type="text/css">
.vjs-default-skin .vjs-control-bar {
	font-size: 100%
}
</style>
</head>

<body>
	<jsp:include page="../menu/header.jsp"></jsp:include>

	<div id="wcenter">
	<br>
		<form action="replyOK.do" method="get">
		<table>
				<tr id="view" align="left" class="col-sm-2">
					<td colspan="4"><video id="Video1" width="640" height="360"
							controls="controls" class="video-js vjs-default-skin"
							data-setup="{}">
							<source src="http://222.121.91.248:5000/${cvo.con_link}"
								type="video/mp4" />
						</video> <font color="black" size="5">제목:${cvo.con_name }</font><br>
						<font color="black" size="4">게시자:${cvo.con_writer}</font><br>
						<font color="black" size="4">조회수:${cvo.scount }</font><br> <font
						color="black" size="4">게시일:${cvo.con_regedate }</font><br> <input
						type="hidden" name="con_id" value="${cvo.con_id}" /></td>
				</tr>

				<tr align="left">
					<c:if test="${user_id!=null}">			
					<td><img src="resources/thumb_${mvo.m_profile}" height="52" width="48"></td>
					</c:if>
					
					<c:if test="${user_id==null}">			
					<td><img src="resources/thumb_noimage.png" height="52" width="48"></td>
					</c:if>
					<td>
						<textarea rows="3" cols="90" name="replycontext"></textarea> 
					</td>
					<td>	
						<input type="hidden" name="con_writer" value="${user_id}"></td> 
					<td>
						<input type="submit" value="입력"><br>
						<input type="reset" value="취소">
					</td>
				</tr>

				<c:forEach var="vo" items="${rlist}">
					<tr align="left" id="retr" >
						<td colspan="1" height="52" width="48"><img src="resources/thumb_${vo.replyprofile}" height="52"
							width="48"></td>
						<td colspan="3" width="100">게시자:${vo.con_writer}<br>
							<pre>${vo.replycontext}</pre> 
							게시일:${vo.con_regedate }<br></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>

	<div id="side_right">
	 <table>
		
			<c:if test="${user_id!=null}">
			<tr align="left">
				<td><h3>내 동영상</h3></td>
			</tr>
			<c:forEach var="vo" items="${mylist}">
				<tr id="view" align="left">
					<td>
						<a href="watch.do?con_id=${vo.con_id}&user_id=${user_id}"> <img
							width="196" height="110"
							src="http://222.121.91.248:5000/${vo.con_link}.png"></a></td>
					<td >
					 <a href="watch.do?con_id=${vo.con_id}&user_id=${user_id}">제목:${vo.con_name }</a><br>
					  게시자:${vo.con_writer} <br>
					  조회수:${vo.scount }<br> 
					  게시일:${vo.con_regedate }</td>
				</tr>
			</c:forEach>
			</c:if>			
			<c:if test="${user_id==null}">
				<tr align="left">
				<td><h3>최근 동영상</h3></td>
			</tr>
			<c:forEach var="vo" items="${clist}">
				<tr id="view" align="left">
					<td>
						<a href="watch.do?con_id=${vo.con_id}&user_id=${user_id}"> <img
							width="196" height="110"
							src="http://222.121.91.248:5000/${vo.con_link}.png"></a></td>
					<td>
					 <a href="watch.do?con_id=${vo.con_id}&user_id=${user_id}">제목:${vo.con_name }</a><br>
					  게시자:${vo.con_writer} <br>
					  조회수:${vo.scount }<br> 
					  게시일:${vo.con_regedate }</td>
					
				</tr>
			</c:forEach>
			
			</c:if>
			
			
		</table>
	</div>
</body>
</html>