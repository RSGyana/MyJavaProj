<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UserMenu.jsp"%>

             <div class="container">
             
             <div class="card-header bg-primary text-center text-white text-uppercase">
				<h6>welcome to edit page</h6>
			</div>
       <div    class="card-body">
	<form:form action="update" method="POST" modelAttribute="shipmentType">
		<pre>
		ShipmentId:
		<form:input path="shipId" readonly="true"/>
SHIPMENT MODE:
     <form:select path="shipMode">
     <form:option value="--select--">--select--</form:option>
     <form:option value="Air">Air</form:option>
     <form:option value="Truck">Truck</form:option>
     <form:option value="Ship">Ship</form:option>
     <form:option value="Train"> Train</form:option>
     </form:select>
 SHIPMENT CODE:
     <form:input path="shipCode"/>
  ENABLE SHIPMENT:
       <form:select path="enbShip">
       <form:option value="--select--">--select--</form:option>
       <form:option value="Yes">Yes</form:option>
       <form:option value="No">No</form:option>
       </form:select>
   SHIPMENT GRADE:
      <form:radiobutton path="shipGrade" value="A" />A
      <form:radiobutton path="shipGrade" value="B" />B
      <form:radiobutton path="shipGrade" value="C" />C
   DESCRIPTION:
      <form:textarea path="shipDesc"/>
      
      <input type="submit" value="UPDATE SHIPMENT">
       
</pre>
	</form:form>
	</div> <!-- card body end-->		
	           <c:if test="${!empty message }">
				<div class="card-footer bg-info text-white text-center">

					<b>${message}</b>

				</div>
			</c:if>
	
	</div>
</body>
</html>