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
	<%@ include file="UserMenu.jsp"%>
	<div class="container">

		<div class="card-header bg-primary text-center text-white">

			<H4>WELCOME TO SHIPPING DATA PAGE</H4>
		</div>
		<a href="excel">Excell Exports</a> 
		<a href="pdf">PDF Exports</a>

		<c:choose>
			<c:when test="${!empty list}">
				<div class="card-body">
					<table border="1">
						<tr>
							<th>ID</th>
							<th>SHIPPING CODE</th>
							<th>SHIP REF NUM</th>
							<th>COURIER REF  NUM</th>
							<th>CONTACT DETLS</th>
							<th>SALE ORDER CODE</th>
							<th>NOTE</th>
							<th>BILL TO ADDRS</th>
							<th>SHIP TO ADDRS</th>
							<th colspan=3>OPERATION</th>



						</tr>
						<!-- for(Shipping ob:list){} -->
						<c:forEach items="${list}" var="ob">


							<tr>
								<td>${ob.shippId}</td>
								<td>${ob.shippCode}</td>
								<td>${ob.refNum}</td>
								<td>${ob.courierRefNum}</td>
								<td>${ob.contDtls}</td>
								<td>${ob.saleOrderCode}</td>
								<td>${ob.note}</td>
								<td>${ob.billToAdrs}</td>
								<td>${ob.shipToAdrss}</td>

								<td><a href="delete?sid=${ob.shippId}">DELETE</a></td>
								<td><a href="edit?sid=${ob.shippId}">EDIT</a></td>
								<td><a href="view?sid=${ob.shippId}">VIEW</a></td>
							</tr>
						</c:forEach>

					</table>
				</div>
			</c:when>
			<c:otherwise>
				<div class="card-footer text-white text-uppercase">
					<H4>no data found</H4>
				</div>
			</c:otherwise>
		</c:choose>

</div>
${message}
</body>
</html>