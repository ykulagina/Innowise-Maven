<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
<title>Task 05. Text Font Result</title>
</head>
<body>
<h1>Here are Your Lines</h1>
<h3>You've chosen font size: ${textFontSize}.</h3>
<h3>You've chosen ${numberOfLines} line(s) to display.</h3>
<ul>
	<c:forEach var="item" items="${textToDisplay}">
		<li style="font-size:${textFontSize}"><c:out value="${item}"/></li>
	</c:forEach>
</ul>
</body>
</html>