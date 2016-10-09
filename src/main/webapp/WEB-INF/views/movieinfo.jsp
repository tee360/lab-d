<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%--
	On this page we show additional movie information.
	
	Model:
	- Movieinfo movieinfo
 --%>
<html>
<head>
<%@ include file="parts/head.jsp"%>
</head>
<body>
	<div class="nav">
		<a href="<c:url value="/"/>">Home</a>
	</div>
	<h1>Additional Movie Info</h1>

	<p>
		<label>Netflix Rating</label>
		<c:out value="${ movieinfo.rating }" />
	</p>
	<p>
		<label>Movie Poster: </label> <br>
		 <img src="${ movieinfo.image }" />
	</p>
	<p>
		<label>Movie Summary:</label><br>
		<c:out value="${movieinfo.summary }"></c:out>
		
	</p>

</body>
</html>