<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO USER VIEW PAGE</h3>

<a href="excel?id=${ob.userId}">EXCEL EXPORT</a>
<a href="pdf?id=${ob.userId}">PDF EXPORT</a>

<table border="1">
<tr>
<th>userId</th>
<td>${ob.userId}</td>
</tr>

<tr>
<th>userType</th>
<td>${ob.userType}</td>
</tr>

<tr>
<th>userCode</th>
<td>${ob.userCode}</td>
</tr>

<tr>
<th>userFor</th>
<td>${ob.userFor}</td>
</tr>

<tr>
<th>userEmail</th>
<td>${ob.userEmail}</td>
</tr>

<tr>
<th>userContact</th>
<td>${ob.userContact}</td>
</tr>

<tr>
<th>userIdType</th>
<td>${ob.userIdType}</td>
</tr>

<tr>
<th>userOtherId</th>
<td>${ob.userOtherId}</td>
</tr>

<tr>
<th>userIdNum</th>
<td>${ob.userIdNum}</td>
</tr>
</table>

</body>
</html>