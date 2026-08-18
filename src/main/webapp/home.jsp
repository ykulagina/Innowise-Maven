 <%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
<title>Task 05</title>
</head>
<body>
<h1>Part 1. Search For a Word</h1>
<form action="servlet-find-word" method="GET">
	<label for="searchWord">Search for:</label>
	<input type="text" id="searchWord" name="searchWord" placeholder="Type in here..." required>
	<input type="submit" value="Search">
</form>
<h1>Part 2. Find a Book</h1>
<form action="servlet-book-manager" method="GET">
	<label for="bookId">Enter Book ID:</label>
	<input type="number" id="bookId" name="bookId" placeholder="Type in here...">
	<input type="submit" value="Search">
</form>
<h1>Part 3. Get Some Text Lines</h1>
<form action="servlet-font-manager" method="GET">
	<label for="fontSize">Enter font size:</label>
	<input type="number" id="fontSize" name="fontSize" placeholder="Type in here...">
	<label for="numberOfLines">Enter number of lines:</label>
	<input type="number" id="numberOfLines" name="numberOfLines" placeholder="Type in here...">
	<input type="submit" value="Show Text">
</form>
</body>
</html>