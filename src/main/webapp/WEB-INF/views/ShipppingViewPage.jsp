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
					<td>${ob.shippId}</td>

				</tr>
				<tr>
					<th>SHIP CODE</th>
					<td>${ob.shippCode}</td>
				</tr>


				<tr>
					<th>REF NUM</th>
					<td>${ob.refNum}</td>
				</tr>
				<tr>
					<th>COURIER REF NUM</th>
					<td>${ob.courierRefNum}</td>
				</tr>
				<tr>
					<th>CONTACT DTLS</th>
					<td>${ob.contDtls}</td>
				</tr>
				<tr>
					<th>SALE ORDER CODE</th>
					<td>${ob.saleOrderCode}</td>

				</tr>
				
				<tr>
					<th>NOTE</th>
					<td>${ob.note}</td>

				</tr>
				<tr>
					<th>BILL TO ADRS<th>
					<td>${ob.billToAdrs}</td>

				</tr>
				
				<tr>
					<th>SHIP TO ADRS</th>
					<td>${ob.shipToAdrs}</td>

				</tr>

			</table>
</div>


</body>
</html>