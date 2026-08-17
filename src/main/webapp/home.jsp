 <%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
<title>Task 05</title>
</head>
<body>
<h1>Search For a Word</h1>
<form action="servlet-find-word" method="GET">
	<label for="searchWord">Search for:</label>
	<input type="text" id="searchWord" name="searchWord" placeholder="Type in here...">
	<input type="submit" value="Search">
</form>
<h1>Find a Book</h1>
<form action="servlet-book-manager" method="GET">
	<label for="bookId">Enter Book ID:</label>
	<input type="number" id="bookId" name="bookId" placeholder="Type in here...">
	<input type="submit" value="Search">
</form>
<%-- <label for="resultResponse">Result:</label>
<input type="text" id="resultResponse" name="resultResponse"> --%>
</body>
</html>