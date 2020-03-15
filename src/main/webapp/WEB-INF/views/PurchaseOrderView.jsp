<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>WELCOME TO PURCHASE ORDER VIEW PAGE</h3>
<a href="excel?id=${ob.pordId}">EXCEL EXPORT</a>
<a href="pdf?id=${ob.pordId}">PDF EXPORT</a>
<table border="1">
<tr><th>pordId</th>
<td>${ob.pordId}</td>
</tr>

<tr><th>pordCode</th>
<td>${ob.pordCode}</td>
</tr>
<tr><th>refNum</th>
<td>${ob.refNum}</td>
</tr>
<tr><th>quaCheck</th>
<td>${ob.quaCheck}</td>
</tr>
<tr><th>defStatus</th>
<td>${ob.defStatus}</td>
</tr>
<tr><th>pordDesc</th>
<td>${ob.pordDesc}</td>
</tr>


</table>



</body>
</html>