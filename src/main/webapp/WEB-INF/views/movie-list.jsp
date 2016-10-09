<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%--
	On this page we list all the movies.
	
	Model:
	- List<Movie> movies
	- String category  if the page is filtered to a specific category, this will
	                   be the name of that category. Otherwise it will not be
	                   defined.
 --%>
<html>
<head>
	<%@ include file="parts/head.jsp" %>
</head>
<body>
<div class="nav">
	<a href="<c:url value="/"/>">Home</a>
	<a href="<c:url value="/movieinfo"/>"> Additional Movie Info</a>
	<c:if test="${ not empty category }">
		<a href="<c:url value="/movies"/>">See all movies</a>
	</c:if>
</div>
<h1>
	<c:choose>
		<c:when test="${ empty category }">
			All the Movies
		</c:when>
		<c:otherwise>
			Movies in category <c:out value="${ category }"/>
		</c:otherwise>
	</c:choose>
</h1>

<table>
	<tr>
		<th>Title</th><th>Category</th>
	</tr>
	<c:forEach var="movie" items="${movies}" >
		<tr>
			<td><a href="<c:url value="/movies/${movie.id}"/>"><c:out value="${ movie.title }"/></a></td>
			<td><c:out value="${ movie.category }"/> <a href="<c:url value="/movies?category=${movie.category}"/>">(filter)</a></td>
		</tr>
	</c:forEach>
</table>
<div class="action-bar">
	<a class="add-btn" href="<c:url value="/movies/create"/>">Add a movie</a>
</div>

</body>
</html>
