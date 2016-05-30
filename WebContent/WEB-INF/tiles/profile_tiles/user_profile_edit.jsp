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
				<label>Username:</label>
				<c:out value="${userProfileForm.username}"/>
			</p>
			<p>
				<label>Old Password:</label>
				<form:password path="oldPassword"/>
			</p>
			<p>
				<label>New Password:</label>
				<form:password path="newPassword"/>
			</p>
			<p>
				<label>Confirm Password:</label>
				<form:password path="confirmPassword"/>
			</p>
			<p>
				<label>Old Email:</label>
				<form:input path="email"/>
			</p>
			<p>
				<label>New Email:</label>
				<form:input path="newEmail"/>
			</p>
			<p>
				<label>Confirm Email:</label>
				<form:input path="confirmEmail"/>
			</p>
			<p>
				<label>&nbsp;</label>
				<input type="submit" value="Save"/>
			</p>
		</form:form>
	</div>
</div>