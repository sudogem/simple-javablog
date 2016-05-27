<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/tags.jsp"%>
<div>
	<span><a href="newBlog.do">New Blog</a></span>
</div>
<div style="width:100%;">
	<table border="1" width="60%">
		<thead>
			<tr>
				<th width="70%">Title</th>
				<th>Date</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="blog" items="${blogPreviews}">
				<tr>
					<td><a href="blog.do?id=<c:out value='${blog.blogId}'/>"><span><c:out value="${blog.title}"/></span></a></td>
					<td><span><fmt:formatDate value="${blog.dateCreated}" pattern="yyyy/MM/dd hh:mm:ss"/></span></td>
					<td><a href="newBlog.do?blog_id=<c:out value='${blog.blogId}'/>">Edit</a></td>
					<td><a href="deleteBlog.do?blog_id=<c:out value='${blog.blogId}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>