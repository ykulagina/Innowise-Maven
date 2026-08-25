 <%@ page contentType="text/html;charset=utf-8" %>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
<title>Task 06. Working Teachers</title>
</head>
<body>
<h1>Teachers Working on ${day}</h1>
<c:choose>
	<c:when test="${teachers == null}">
		<p>${result}</p>
	</c:when>
	<c:otherwise>
		<%-- <table style="margin: 10px" border="3" name="bookTable">
			<thead>
				<td align="center"><b>ID</b></td>
				<td align="center"><b>Name</b></td>
				<td align="center"><b>Author</b></td>
				<td align="center"><b>Publication Year</b></td>
			</thead>
			<tr>
				<td><input type="number" id="bookId" name="bookId" value="${book.id}" readonly></td>
				<td><input type="text" id="bookName" name="bookName" value="${book.name}"></td>
				<td><input type="text" id="bookAuthor" name="bookAuthor" value="${book.author}"></td>
				<td><input type="number" id="bookYear" name="bookYear" value="${book.year}"></td>
			</tr>
		</table> --%>
		<c:forEach var="item" items="${teachers}">
		<li><c:out value="${item}"/></li>
		</c:forEach>
	</c:otherwise>
</c:choose>
</body>
</html>