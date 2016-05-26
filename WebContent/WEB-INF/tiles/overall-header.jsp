<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/tags.jsp"%>
<div id="header">
	<h1>BLOG for DIJKSMAN INC.</h1>
</div>
<div id="login_status">
	<c:choose>
		<c:when test="${not empty uid}">
			<label><a href="profile.do"><c:out value="${u_hdl}"/></a></label>
			&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="logout.do">Logout</a>
		</c:when>
		<c:otherwise>
			<a href="login.do">Login</a>&nbsp;|&nbsp;
			<a href="register.do">Register</a>
		</c:otherwise>
	</c:choose>
</div>
<div>
	<span><a href="index.do">Home</a></span>&nbsp;&nbsp;|&nbsp;&nbsp;
	<c:if test="${not empty uid}">
		<span><a href="userConsole.do">User Console</a></span>&nbsp;&nbsp;|&nbsp;&nbsp;
		<c:if test="${is_ad}">
			<span><a href="admin.do">Admin</a></span>
		</c:if>
	</c:if>
</div>
