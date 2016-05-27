<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/tags.jsp"%>
<div style="width:100%;">
	<c:set var="users" value="${adminConsole.users}"/>
	<h2>Users</h2>
	<table border="1" width="60%">
		<thead>
			<tr>
				<th>Username</th>
				<th>Password</th>
				<th>Admin</th>
				<th>Active</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td><a href="userHome.do?id=<c:out value='${user.id}'/>"><span><c:out value="${user.username}"/></span></a></td>
					<td><span><c:out value="${user.password}"/></span></td>
					<td><span><c:out value="${user.isAdmin}"/></span></td>
					<td><span><c:out value="${user.isActive}"/></span></td>
					<td><a href="editUser.do?id=<c:out value='${user.id}'/>">Edit</a></td>
					<td>
						<c:if test="${user.id != uid}">
							<a href="deleteUser.do?id=<c:out value='${user.id}'/>">Delete</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>