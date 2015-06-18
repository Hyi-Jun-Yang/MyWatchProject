<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<ul id="menu">
	<li><a href="index.do">HOME</a></li>
	<li><a href="c_select.do">Content</a>
		<ul>

			<li><a href="file_upload.do">c_insert.do</a></li>
			<li><a href="c_select.do">c_select.do</a></li>
			<li><a href="re_select.do">re_select.do</a></li>
		</ul></li>
	<li><a href="m_select.do">Member</a>
		<ul>

			<li><a href="join.do">m_insert.do</a></li>
			<li><a href="m_select.do">m_select.do</a></li>
		</ul></li>
	<li>
		<a href="cu_insert.do">CUST</a>
		<ul>

			<li><a href="cu_insert.do">cu_insert.do</a></li>
			<li><a href="cu_select.do">cu_select.do</a></li>
		</ul>
	</li>
	<li>
		<a href="p_insert.do">PRODUCT</a>
		<ul>
			<li><a href="p_insert.do">p_insert.do</a></li>
			<li><a href="p_select.do">p_select.do</a></li>
		</ul>
	</li>
	<li>
		<a href="e_insert.do">EventList</a>
		<ul>
			<li><a href="e_insert.do">e_insert.do</a></li>
			<li><a href="e_select.do">e_select.do</a></li>
		</ul>
	</li>
	<li>
		<a href="en_insert.do">ENTRYINFO</a>
		<ul>
			<li><a href="en_insert.do">en_insert.do</a></li>
			<li><a href="en_select.do">en_select.do</a></li>
		</ul>
	</li>
		
		
		
	<c:if test="${user_id==null}">	
	<li><a href="login.do">LOGIN</a><li>
	</c:if>
	
	<c:if test="${user_id!=null}">
	<li><a href="logout.do">LOGOUT</a><li>
	
	</c:if>
	
</ul>
