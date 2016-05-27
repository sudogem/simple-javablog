<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/tags.jsp"%>
<div class="home" style="width:100%;">
	<div>
		<c:choose>
			<c:when test="${isSelf}">
				<h2>My Blog</h2>
			</c:when>
			<c:otherwise>
				<h2><c:out value="${homePage.username}"/>'s Blog</h2>
			</c:otherwise>
		</c:choose>
	</div>
	<div>
		<table width="100%">
			<tr>
				<td width="70%">
					<c:set var="blogLatest" value="${homePage.blogLatest}"/>
					<c:choose>
						<c:when test="${not empty blogLatest}">
							<div>
								<h2><a href="blog.do?id=<c:out value='${blogLatest.id}'/>"><c:out value="${blogLatest.title}"/></a></h2>
								<p><c:out value="${blogLatest.blog}"/></p>
							</div>
						</c:when>
						<c:otherwise>
							<p>No blogs found.</p>
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:set var="blogPreviews" value="${homePage.blogPreviews}"/>
					<c:if test="${not empty blogPreviews}">
						<div>
							<ul>
								<c:forEach var="blogPreview" items="${blogPreviews}">
									<li><a href="blog.do?id=<c:out value='${blogPreview.blogId}'/>"><c:out value="${blogPreview.title}"/></a></li>
								</c:forEach>
							</ul>
						</div>
					</c:if>
				</td>
			</tr>
		</table>
	</div>
</div>