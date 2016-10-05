<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%--
	On this page we list all the categories.
	
	Model:
	- Set<String> categories
 --%>
<html>
<head>
	<%@ include file="parts/head.jsp" %>
</head>
<body>
<div class="nav">
	<a href="<c:url value="/"/>">Home</a>
</div>
<h1>
	All Categories
</h1>

<ul>
	<c:forEach var="category" items="${categories}" >
		<li><a href="<c:url value="/movies?category=${category}"/>">${ category }</a></li>
	</c:forEach>
</ul>

</body>
</html>
