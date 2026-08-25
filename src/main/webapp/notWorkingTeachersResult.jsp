 <%@ page contentType="text/html;charset=utf-8" %>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
<title>Task 06. Not Working Teachers</title>
</head>
<body>
<h1>Teachers NOT Working on ${day}</h1>
<c:choose>
	<c:when test="${not_working_teachers == null}">
		<p>${result}</p>
	</c:when>
	<c:otherwise>
		<c:forEach var="item" items="${not_working_teachers}">
		<li><c:out value="${item}"/></li>
		</c:forEach>
	</c:otherwise>
</c:choose>
</body>
</html>