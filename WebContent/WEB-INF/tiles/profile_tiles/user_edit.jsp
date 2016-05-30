<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/tags.jsp"%>
<div class="userProfileEdit" style="width:100%;">
	<div class="form">
		<form:form commandName="userProfileForm" method="post" enctype="application/x-www-form-urlencoded">
			<div class="messages">
				<div class="error">
					<ol id="error">
						<spring:hasBindErrors name="userProfileForm">
							<c:forEach var="error" items="${errors.globalErrors}">
								<li><label class="error"><spring:message code="${error.code}" text="${error.defaultMessage}"/></label></li>
							</c:forEach>
						</spring:hasBindErrors>
					</ol>
				</div>
			</div>
			<p>
				<label>Admin:</label>
				<c:choose>
					<c:when test="${userProfileForm.id == uid}">
						<c:out value="${userProfileForm.isAdmin}"/>
					</c:when>
					<c:otherwise>
						<form:checkbox path="isAdmin"/>
					</c:otherwise>
				</c:choose>
			</p>
			<p>
				<label>Active:</label>
				<c:choose>
					<c:when test="${userProfileForm.id == uid}">
						<c:out value="${userProfileForm.isActive}"/>
					</c:when>
					<c:otherwise>
						<form:checkbox path="isActive"/>
					</c:otherwise>
				</c:choose>
			</p>
			<p>
				<label>Username:</label>
				<c:out value="${userProfileForm.username}"/>
			</p>
			<p>
				<label>Password:</label>
				<form:input path="oldPassword"/>
			</p>
			<p>
				<label>New Password:</label>
				<form:input path="newPassword"/>
			</p>
			<p>
				<label>Confirm New Password:</label>
				<form:input path="confirmPassword"/>
			</p>
			<p>
				<label>Email:</label>
				<c:out value="${userProfileForm.email}"/>
			</p>
			<p>
				<label>&nbsp;</label>
				<input type="submit" value="Save"/>
			</p>
		</form:form>
	</div>
</div>