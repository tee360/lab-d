<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%--
	On this page we have a form to create a user.
	
	Model:
	- User user ~ a user with no properties set at all
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
	Add a user
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
	<button type="submit">Create</button>
</form>

</body>
</html>
