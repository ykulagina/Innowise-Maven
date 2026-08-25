 <%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
<title>Task 06</title>
</head>
<body>
<h1 style="text-align: center">Task 06</h1>
<%-- <div style="display: flex; flex-direction: row; justify-content: space-around;"> --%>
<div style="background: #F6CFFF; padding: 15px; margin: 5px;">
<h2>Part 1. Find Teachers Working (Day & Auditorium)</h2>
<form action="working-teachers" method="GET">
	<%-- <div style="display: flex; flex-direction: column;"> --%>
	<label for="day">Day:</label>
	<input type="text" id="day" name="day" placeholder="E.g. Monday" required>
	<label for="room">Auditorium:</label>
	<input type="text" id="room" name="room" placeholder="E.g. 203" required>
	<input type="submit" value="Search">
	<%-- </div> --%>
</form>
</div>
<div style="background: #E9D4FF; padding: 15px; margin: 5px;">
<h2>Part 2. Find Teachers Not Working (Day)</h2>
<form action="not-working-teachers" method="GET">
	<label for="day2">Day:</label>
	<input type="text" id="day2" name="day2" placeholder="E.g. Monday" required>
	<input type="submit" value="Search">
</form>
</div>
<div style="background: #C6D2FF; padding: 15px; margin: 5px;">
<h2>Part 3. Find Days with a Particular Number of Lectures</h2>
<form action="days-lectures" method="GET">
	<%-- <div style="display: flex; flex-direction: column;"> --%>
	<label for="lectures">Number of Lectures:</label>
	<input type="number" id="lectures" name="lectures" placeholder="Type in here" required>
	<input type="submit" value="Search">
	<%-- </div> --%>
</form>
</div>
<div style="background: #8EC5FF; padding: 15px; margin: 5px;">
<h2>Part 4. Find Days with a Particular Number of Auditoria Occupied</h2>
<form action="days-auditoria" method="GET">
	<%-- <div style="display: flex; flex-direction: column;"> --%>
	<label for="auditoria">Number of Auditoria:</label>
	<input type="number" id="auditoria" name="auditoria" placeholder="Type in here" required>
	<input type="submit" value="Search">
	<%-- </div> --%>
</form>
<%-- </div> --%>
</div>
</body>
</html>