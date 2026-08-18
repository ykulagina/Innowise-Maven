 <%@ page contentType="text/html;charset=utf-8" %>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
<title>Task 05. Book Result</title>
</head>
<body>
<h1>Book Search Result</h1>
<h3>Update Book</h3>
<c:choose>
	<c:when test="${book == null}">
		<p>${result}</p>
	</c:when>
	<c:otherwise>
		<form action="servlet-book-manager" method="POST">
		<table style="margin: 10px" border="3" name="bookTable">
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
		</table>
		<input style="margin: 10px" type="submit" value="Update">
		</form>
	</c:otherwise>
</c:choose>
</body>
</html>