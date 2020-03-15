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
<%@ include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card-header bg-primary text-center text-uppercase">
			<H4>welcome to uom view page</H4>
		</div>
<a href="excel?id=${ob.uomId}">EXCEL EXPORT</a>
<a href="pdf?id=${ob.uomId}">PDF EXPORT</a>
<div class="card-body">
<table border="1">
<tr>
<th>uomId</th>
<td>${ob.uomId}</td>
</tr>

<tr>
<th>uomType</th>
<td>${ob.uomType}</td>
</tr>

<tr>
<th>uomModel</th>
<td>${ob.uomModel}</td>
</tr>

<tr>
<th>desc</th>
<td>${ob.desc}</td>
</tr>

</table>
</div>
</div>
</body>
</html>