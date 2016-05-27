<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/tags.jsp"%>
<div class="registration">
	<div class="form">
		<form:form id="registration" method="post" enctype="application/x-www-form-urlencoded">
			<div class="messages">
				<div class="error">
					<ol id="error">
						<spring:hasBindErrors name="command">
							<c:forEach var="error" items="${errors.globalErrors}">
								<li><label class="error"><spring:message code="${error.code}" text="${error.defaultMessage}"/></label></li>
							</c:forEach>
						</spring:hasBindErrors>
					</ol>
				</div>
			</div>
			<p>
				<label>Username:</label>
				<form:input path="username"/>
			</p>
			<p>
				<label>Password:</label>
				<form:password path="password"/>
			</p>
			<p>
				<label>Confirm Password:</label>
				<form:password path="confirmPassword"/>
			</p>
			<p>
				<label>Email:</label>
				<form:input path="email"/>
			</p>
			<p>
				<label>Confirm Email:</label>
				<form:input path="confirmEmail"/>
			</p>
			<p>
				<label>&nbsp;</label>
				<input type="submit" value="Submit"/>
			</p>
		</form:form>
	</div>
</div>