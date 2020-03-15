<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div
			class="card-header bg-primary text-center text-white text-uppercase">
			<h3>WELCOME TO DATA PAGE</h3>
		</div>
<div class=card-body>
		<c:choose>
			<c:when test="${!empty list}">

				<a href="excel">Excell Exports</a>
				<a href="pdf">PDF Exports</a>
				
					<table border="1">

						<tr>
							<th>ID</th>
							<th>CODE</th>
							<th>WIDTH</th>
							<th>LENGTH</th>
							<th>HEIGHT</th>
							<th>BASE COST</th>
							<th>BASE CURRENCY</th>
							<th>MODEL</th>
							<th>ORDERMETHOD</th>
							<th>DESCRIPTON</th>
							<th colspan=3>OPERATION</th>

						</tr>



						<!-- for(Part ob:list){} -->
						<c:forEach items="${list}" var="ob">


							<tr>
								<td>${ob.partId}</td>
								<td>${ob.partCode}</td>
								<td>${ob.width}</td>
								<td>${ob.length}</td>
								<td>${ob.height}</td>
								<td>${ob.baseCost}</td>
								<td>${ob.baseCurrency}</td>
							
								<td>${ob.uomOb.uomModel}</td>
								<td>${ob.omOb.orderCode}</td>
								<td>${ob.partDesc}</td>

								<td><a href="delete?sid=${ob.partId}">DELETE</a>
								 <a href="edit?sid=${ob.partId}">EDIT</a> 
								 <a href="view?sid=${ob.partId}">VIEW</a></td>
							</tr>
						</c:forEach>

					</table>
				
	
	
	</c:when>
	<c:otherwise>
		<H4>no data found</H4>
	</c:otherwise>
	</c:choose>
	</div>

	
</div>
${message}
</body>
</html>