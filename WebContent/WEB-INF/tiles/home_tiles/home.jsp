<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/tags.jsp"%>
<div class="home" style="width:100%;">
	<div>
		<h1>Latest Blogs</h1>
		<ul>
			<c:forEach var="blog" items="${latestBlogs}">
				<li>
					<a href="blog.do?id=<c:out value='${blog.blogId}'/>"><c:out value="${blog.title}"/></a>&nbsp;by&nbsp;
					<span><a href="userHome.do?id=<c:out value='${blog.authorId}'/>"><c:out value="${blog.author}"/></a></span>&nbsp;
					<span style="font-size:small;"><fmt:formatDate value="${blog.dateCreated}" pattern="yyyy/MM/dd"/></span>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>