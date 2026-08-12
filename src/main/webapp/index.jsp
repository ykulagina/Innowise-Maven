 <%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
<title>JSP Timing</title>
</head>
<body>
<h1>Test Servlets One & Two</h1>
<form action="servlet-one" method="POST">
<input type="submit" value="Submit Form">
</form>
<h2>Time counter after running the app and button clicking</h2>
<jsp:useBean id="calendar" class="java.util.GregorianCalendar"/>
<form name="Simple" action="servlet-two" method="POST">
<input type="hidden" name="time" value="${calendar.timeInMillis}"/>
<input type="submit" name="button" value="Calculate time"/>
</form>
</body>
</html>