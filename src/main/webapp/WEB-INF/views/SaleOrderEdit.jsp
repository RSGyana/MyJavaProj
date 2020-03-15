<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO SALE ORDER EDIT PAGE</h3>
	<form:form action="update" method="POST" modelAttribute="saleOrder">
<pre>
SALEORDERID:<form:input path="sordId" readonly="true"/>
ORDERCODE:
<form:input path="orderCode"/>
REFERENCE NUMBER:
<form:input path="refNUm"/>
STOCK MODE:
<form:radiobutton path="stockMode" value="GRADE"/>GRADE
<form:radiobutton path="stockMode" value="MARGIN"/>MARGIN

STOCK SOURCE:
<form:select path="stkSource">
     <form:option value=">--select--">--select--</form:option>
     <form:option value="OPEN">OPEN</form:option>
     <form:option value="AVAIL">AVAIL</form:option>
     <form:option value="REFUND">REFUND</form:option>

</form:select>
DEFAULT STATUS:
<form:input path="defStatus"/>
DESCRIPTION:<form:textarea path="soDesc"/>
<input type="submit" value="SALEORDER UPDATE">

</pre>
</form:form>

${message}
</body>
</html>