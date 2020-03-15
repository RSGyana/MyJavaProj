<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card-header bg-primary text-center text-uppercase">
			<H4>welcome to uom edit page</H4>
		</div>

<div class="card-body"></div>
		<form:form action="update" method="post" modelAttribute="uom">
			
UOMID:<form:input path="uomId" readonly="true" />

UOMTYPE:
  <form:select path="uomType">
				<form:option value="--select--">--select--</form:option>
				<form:option value="PACKING">PACKING</form:option>
				<form:option value="NO PACKING">NO PACKING</form:option>
				<form:option value="NA">NA</form:option>
			</form:select>
 
 UOM MODEL:
  <form:input path="uomModel" />
  DESCRIPTION:
  <form:textarea path="desc" />
			<input type="submit" value="UPDATE UOM">


	</form:form>
		</div>
	</div>
</body>

</html>