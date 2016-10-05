<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%--
	On this page we have a form to edit a single user and a button to delete it.
	
	Model:
	- User user
 --%>
<html>
<head>
	<%@ include file="parts/head.jsp" %>
</head>
<body>
<div class="nav">
	<a href="<c:url value="/"/>">Home</a>
	<a href="<c:url value="/users"/>">Back to Users List</a>
</div>
<h1>
	User: ${ user.firstName } ${ user.lastName }
</h1>

<form method="post">
	<div>
		<label>First Name</label>
		<input type="text" name="firstName" value="${user.firstName}"/>
	</div>
	<div>
		<label>Last Name</label>
		<input type="text" name="lastName" value="${user.lastName}"/>
	</div>
	<div>
		<label>Email</label>
		<input type="text" name="email" value="${user.email}"/>
	</div>
	<div>
		<label>Password</label>
		<input type="password" name="password" value="${user.password}"/>
	</div>
	<button type="submit">Save Changes</button>
</form>

<form method="post" action="<c:url value="/users/${user.id}/delete"/>">
	<button type="submit">Delete this User</button>
</form>

</body>
</html>
