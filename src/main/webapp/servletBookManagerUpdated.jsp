 <%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
<title>Task 05. Book Result</title>
</head>
<body>
<h1>Book Update Result</h1>
<h3>Success! You've updated:</h3>
<table style="margin: 10px" border="3" name="bookTable">
	<thead>
		<td align="center"><b>ID</b></td>
		<td align="center"><b>Name</b></td>
		<td align="center"><b>Author</b></td>
		<td align="center"><b>Publication Year</b></td>
	</thead>
	<tr>
		<td><input type="number" id="bookId" name="bookId" value="${bookId}" readonly></td>
		<td><input type="text" id="bookName" name="bookName" value="${bookName}" readonly></td>
		<td><input type="text" id="bookAuthor" name="bookAuthor" value="${bookAuthor}" readonly></td>
		<td><input type="number" id="bookYear" name="bookYear" value="${bookYear}" readonly></td>
	</tr>
</table>
</body>
</html>