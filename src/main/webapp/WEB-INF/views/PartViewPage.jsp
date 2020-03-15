<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<div class="card-header text-uppercase bg-primary text-center text-white">
	<h3>WELCOME TO VIEW PAGE</h3>
</div>
	
<div class="card-body">
			<a href="excel">Excell Exports</a>
			<a href="pdf">PDF Exports</a>

			<table border="1">

				<tr>
					<th>ID</th>
					<td>${ob.partId}</td>

				</tr>
				<tr>
					<th>CODE</th>
					<td>${ob.partCode}</td>
				</tr>

				<tr>
					<th>WIDTH</th>
					<td>${ob.width}</td>

				</tr>

				<tr>
					<th>LENGTH</th>
					<td>${ob.length}</td>
				</tr>
				<tr>
					<th>HEIGHT</th>
					<td>${ob.height}</td>
				</tr>
				<tr>
					<th>BASE COST</th>
					<td>${ob.baseCost}</td>
				</tr>
				<tr>
					<th>BASE CURRENCY</th>
					<td>${ob.baseCurrency}</td>

				</tr>
				
				<tr>
					<th>MODEL</th>
					<td>${ob.uomOb.uomModel}</td>

				</tr>
				<tr>
					<th>ORDERMETHOD<th>
					<td>${ob.omOb.orderCode}</td>

				</tr>
				
				<tr>
					<th>DESCRIPTION</th>
					<td>${ob.partDesc}</td>

				</tr>

			</table>
</div>


</body>
</html>