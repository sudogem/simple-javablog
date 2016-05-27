<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/tags.jsp"%>
<div class="newBlog" style="width:100%;">
	<div class="form">
		<form:form commandName="newBlogForm" id="newBlog" method="post" enctype="application/x-www-form-urlencoded">
			<div class="messages">
				<div class="error">
					<ol id="error">
						<spring:hasBindErrors name="newBlogForm">
							<c:forEach var="error" items="${errors.globalErrors}">
								<li><label class="error"><spring:message code="${error.code}" text="${error.defaultMessage}"/></label></li>
							</c:forEach>
						</spring:hasBindErrors>
					</ol>
				</div>
			</div>
			<form:hidden path="id"/>
			<p>
				<label>Title:</label>
				<form:input path="title"/>
			</p>
			<p>
				<label>Blog:</label>
				<form:textarea path="blog" cols="120" rows="30"/>
			</p>
			<p>
				<label>&nbsp;</label>
				<input type="submit" value="Save"/>
			</p>
		</form:form>
	</div>
</div>