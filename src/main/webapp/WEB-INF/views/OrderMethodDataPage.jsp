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

			<H4>WELCOME TO ORDER DATA PAGE</H4>
		</div>
		<a href="excel">Excell Exports</a> <a href="pdf">PDF Exports</a>

		<c:choose>
			<c:when test="${!empty list}">
				<div class="card-body">
					<table border="1">
						<tr>
							<th>ID</th>
							<th>ORDER MODE</th>
							<th>ORDER CODE</th>
							<th>ORDER METHOD</th>
							<th>ORDER ACCEPT</th>
							<th>DESCIPTION</th>
							<th colspan=3>OPERATION</th>



						</tr>
						<!-- for(ShipmentType ob:list){} -->
						<c:forEach items="${list}" var="ob">


							<tr>
								<td>${ob.orderId}</td>
								<td>${ob.orderMode}</td>
								<td>${ob.orderCode}</td>
								<td>${ob.orderMethod}</td>
								<td>${ob.orderAccept}</td>
								<td>${ob.desc}</td>

								<td><a href="delete?sid=${ob.orderId}">DELETE</a></td>
								<td><a href="edit?sid=${ob.orderId}">EDIT</a></td>
								<td><a href="view?sid=${ob.orderId}">VIEW</a></td>
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