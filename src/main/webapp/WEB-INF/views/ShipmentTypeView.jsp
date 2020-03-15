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
<%@include file="UserMenu.jsp"%>
<div class="container">
    <div class="card-header bg-primary text-center text-white text-uppercase">

<h3>WELCOME TO SHIPMENTTYPE VIEW PAGE</h3>
</div>

<a href="excel?id=${ob.shipId}">EXCEL EXPORT</a>
<a href="pdf?id=${ob.shipId}">PDF EXPORT</a>
<div card-body></div>

<table border="1">
<tr><th>shipId</th>
<td>${ob.shipId}</td>
</tr>

<tr><th>shipMode</th>
<td>${ob.shipMode}</td>
</tr>
<tr><th>shipCode</th>
<td>${ob.shipCode}</td>
</tr>
<tr><th>enbShip</th>
<td>${ob.enbShip}</td>
</tr>
<tr><th>shipGrade</th>
<td>${ob.shipGrade}</td>
</tr>
<tr><th>shipDesc</th>
<td>${ob.shipDesc}</td>
</tr>

</table>
</div>
</div>  <!--  conatiner end -->
</body>


</html>