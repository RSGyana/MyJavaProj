<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UserMenu.jsp"%>
<div class="container">
    <div class="card-header bg-primary text-center text-white text-uppercase">

	<H4>WELCOME TO SHIPMENT TYPE DATA PAGE</H4>
	</div>
	
	<c:choose>
		<c:when test="${!empty list}">
<a href="excel">Excell Exports</a>
<a href="pdf">PDF Exports</a>
<div class="card-body">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>MODE</th>
					<th>CODE</th>
					<th>ENABLE</th>
					<th>GRADE</th>
					<th>DESCRIPTION</th>
					<th colspan=3>OPERATION</th>

				</tr>
				<!-- for(ShipmentType ob:list){} -->
				<c:forEach items="${list}" var="ob">


					<tr>
						<td>${ob.shipId}</td>
						<td>${ob.shipMode}</td>
						<td>${ob.shipCode}</td>
						<td>${ob.enbShip}</td>
						<td>${ob.shipGrade}</td>
						<td>${ob.shipDesc}</td>
                        <td><a href="delete?sid=${ob.shipId}">DELETE</a></td>
                        
                         <td><a href="view?sid=${ob.shipId}">VIEW</a></td>
                         <td><a href="edit?sid=${ob.shipId}">EDIT</a></td>
                         
                        
                        
					</tr>
				</c:forEach>
				
			</table>
			</div>   <!-- //card body end -->
     <div class="card-footer bg-info text-white text-center">
		</c:when>
		<c:otherwise>
			<H4>no data found</H4>
		</c:otherwise>
	</c:choose>
	</div>    <!-- //card footer end -->
	</div>  <!-- //contaner end--></body>
</html>