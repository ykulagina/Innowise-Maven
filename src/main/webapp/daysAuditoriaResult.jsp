 <%@ page contentType="text/html;charset=utf-8" %>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
<title>Task 06. Days with Defined Number of Auditoria Occupppied</title>
</head>
<body>
<h1>Weekdays with ${numberOfAuditoria} Auditoria Occupppied</h1>
<c:choose>
	<c:when test="${days == null}">
		<p>${result}</p>
	</c:when>
	<c:otherwise>
		<c:forEach var="item" items="${days}">
		<li><c:out value="${item}"/></li>
		</c:forEach>
	</c:otherwise>
</c:choose>
</body>
</html>