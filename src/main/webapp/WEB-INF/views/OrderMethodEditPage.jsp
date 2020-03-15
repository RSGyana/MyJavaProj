<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="UserMenu.jsp" %>
<div class="container">
<div class="card-header bg-primary text-center text-white">
<H4>WELCOME TO ORDER METHOD EDIT PAGE</H4>
</div>
	<form:form action="update" method="POST" modelAttribute="orderMethod">
		<div class="card-body">    
		ORDER ID:<form:input path="orderId" readonly="true"/>
    
	ORDER MODE:
	<form:radiobutton path="orderMode" value="SALE" />SALE
	<form:radiobutton path="orderMode" value="PURCHASE" />PURCHASE
	
	ORDER CODE:
	<form:input path="orderCode" />
	<br> 
	ORDER METHOD:

	<form:select path="orderMethod">
	
		<form:option value="--select--">--select--</form:option>
		<form:option value="FIFO">FIFO</form:option>
		<form:option value="LIFO">LIFO</form:option>
		<form:option value="FIFO">FIFO</form:option>
		<form:option value="FEFO">FEFO</form:option>
	</form:select>

	ORDER ACCEPT:
	<form:checkbox path="orderAccept" value="MULTI-MODEL"/>MULTI-MODEL
    <form:checkbox path="orderAccept" value="ACCEPT-RETURN"/>ACCEPT-RETURN
	 DESCRIPTION:
	<form:textarea path="desc"/>
	<input type="submit"  value="UPDATE PRDER METHOD">
</div>

	</form:form>
	<div class="card-body">	${message}
	</div>
	
</div>
</body>
</html>