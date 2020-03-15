<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO SALEORDER VIEW PAGE</h3>
<a href="excel?id=${ob.sordId}">EXCEL EXPORT</a>
<a href="pdf?id=${ob.sordId}">PDF EXPORT</a>
<table border="1">
<tr><th>shipId</th>
<td>${ob.sordId}</td>
</tr>

<tr><th>orderCode</th>
<td>${ob.orderCode}</td>
</tr>
<tr><th>refNUm</th>
<td>${ob.refNUm}</td>
</tr>
<tr><th>stockMode</th>
<td>${ob.stockMode}</td>
</tr>
<tr><th>stkSource</th>
<td>${ob.stkSource}</td>
</tr>
<tr><th>defStatus</th>
<td>${ob.defStatus}</td>
</tr>
<tr><th>soDesc</th>
<td>${ob.soDesc}</td>
</tr>


</table>
</body>
</html>