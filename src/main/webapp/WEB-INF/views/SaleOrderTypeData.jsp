<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO SALE ORDER DATA PAGE</h3>
<a href="excel">Excell Exports</a>
<a href="pdf">PDF Exports</a>
<table border="1">


<tr>
					<th>ID</th>
					<th>ORDER CODE</th>
					<th>REF NUM</th>
					<th>STOCK MODE</th>
					<th>STOCK SOURCE</th>
					<th>DEFAULT STATUS</th>
					<th>DESCRIPTION</th>
					<th colspan=3>OPERATION</th>
					

				</tr>
				<!-- for(SaleOrder ob:list){} -->
				<c:forEach items="${list}" var="ob">


					<tr>
						<td>${ob.sordId}</td>
						<td>${ob.orderCode}</td>
						<td>${ob.refNUm}</td>
						<td>${ob.stockMode}</td>
						<td>${ob.stkSource}</td>
						<td>${ob.defStatus}</td>
						<td>${ob.soDesc}</td>
						<td><a href="delete?sid=${ob.sordId}">DELETE</a></td>
						<td><a href="edit?sid=${ob.sordId}">EDIT</a></td>
						<td><a href="view?sid=${ob.sordId}">VIEW</a></td>
						
						</tr>
				</c:forEach>
						


</table>
</body>
</html>