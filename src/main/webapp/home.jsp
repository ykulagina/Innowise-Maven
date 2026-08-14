 <%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
<title>Task 05</title>
</head>
<body>
<h1>Search For a Word Servlet</h1>
<form action="servlet-find-word" method="POST">
	<label for="searchWord">Search for:</label>
	<input type="text" id="searchWord" name="searchWord" placeholder="Type in here...">
	<input type="submit" value="Search">
</form>
<%-- <label for="resultResponse">Result:</label>
<input type="text" id="resultResponse" name="resultResponse"> --%>
</body>
</html>