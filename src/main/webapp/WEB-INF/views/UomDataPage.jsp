<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%@ include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card-header bg-primary text-center text-uppercase">
			<H4>welcome to uom data page</H4>
		</div>
		
<div class="card-body">
	<c:choose>
		<c:when test="${!empty list}">
		
<a href="excel">Excell Exports</a>
<a href="pdf">PDF Exports</a>

			<table border="1">
				<tr>
					<th>ID</th>
					<th>UOM TYPE</th>
					<th>UOM MODEL</th>
					<th>DESCRIPTION</th>
					<th colspan=3>OPERATION</th>

				</tr>
				<!-- for(User ob:list){} -->
				<c:forEach items="${list}" var="ob">


					<tr>
						<td>${ob.uomId}</td>
						<td>${ob.uomType}</td>
						<td>${ob.uomModel}</td>
						<td>${ob.desc}</td>
				
                        <td><a href="delete?sid=${ob.uomId}">DELETE</a></td>
                        <td><a href="edit?sid=${ob.uomId}">EDIT</a></td>
                        <td><a href="view?sid=${ob.uomId}">VIEW</a></td>
					</tr>
				</c:forEach>
				
			</table>

		</c:when>
		<c:otherwise>
			<H4>no data found</H4>
		</c:otherwise>
	</c:choose>
	</div>
	<div>
${message}
</div>
</div>
</body>
</html>