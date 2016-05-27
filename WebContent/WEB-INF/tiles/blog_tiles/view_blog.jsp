<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/tags.jsp"%>
<div class="home" style="width:100%;">
	<div style="width:80%">
		<h1><a href="blog.do?id=<c:out value='${blog.id}'/>"><c:out value="${blog.title}"/></a></h1>
		<p>Created: <fmt:formatDate value="${dateCreated}" pattern="yyyy/MM/dd hh:mm:ss"/></p>
		<c:if test="${not empty dateLastUpdated}">
			<p>Updated: <fmt:formatDate value="${dateLastUpdated}" pattern="yyyy/MM/dd hh:mm:ss"/></p>
		</c:if>
		<hr/>
		<p><c:out value="${blog.blog}"/></p>
	</div>
</div>