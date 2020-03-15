<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="UserMenu.jsp" %>
<div class="container">
<div class="card-header bg-primary text-center text-white">	
<h3>WELCOME TO VIEW PAGE</h3>
</div>

<a href="excel?id=${ob.orderId}">EXCEL EXPORT</a>
<a href="pdf?id=${ob.orderId}">PDF EXPORT</a>
<div class="card-body">
<table border="1">
<tr>
<th>orderId</th>
<td>${ob.orderId}</td>
</tr>


<tr>
<th>orderMode</th>
<td>${ob.orderMode}</td>
</tr>

<tr>
<th>orderCode</th>
<td>${ob.orderCode}</td>
</tr>

<tr>
<th>orderMethod</th>
<td>${ob.orderMethod}</td>
</tr>

<tr>
<th>orderAccept</th>
<td>${ob.orderAccept}</td>
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