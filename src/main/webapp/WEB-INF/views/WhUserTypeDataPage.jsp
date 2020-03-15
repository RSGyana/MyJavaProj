<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<H4>WELCOME TO  USER  DATA PAGE</H4>
	<c:choose>
		<c:when test="${!empty list}">
		
<a href="excel">Excell Exports</a>
<a href="pdf">PDF Exports</a>

			<table border="1">
				<tr>
					<th>ID</th>
					<th>USER TYPE</th>
					<th>USER CODE</th>
					<th>USER FOR </th>
					<th>USER EMAIL</th>
					<th>USER CONTACT</th>
					<th>USER ID TYPE</th>
					<th>USER IF OTHER ID</th>
					<th colspan="2">OPERATION</th>
					<!--  <th>DELETE</th>-->

				</tr>
				<!-- for(ShipmentType ob:list){} -->
				<c:forEach items="${list}" var="ob">


					<tr>
						<td>${ob.userId}</td>
						<td>${ob.userType}</td>
						<td>${ob.userCode}</td>
						<td>${ob.userFor}</td>
						<td>${ob.userEmail}</td>
						<td>${ob.userContact}</td>
						<td>${ob.userIdType}</td>
						<td>${ob.userOtherId}</td>
						<td>${ob.userIdNum}</td>
				
                        <td><a href="delete?sid=${ob.userId}">DELETE</a></td>
                        <td><a href="edit?sid=${ob.userId}">EDIT</a></td>
                        <td><a href="view?sid=${ob.userId}">VIEW</a></td>
					</tr>
				</c:forEach>
				
			</table>

		</c:when>
		<c:otherwise>
			<H4>no data found</H4>
		</c:otherwise>
	</c:choose>
${message}


</body>
</html>