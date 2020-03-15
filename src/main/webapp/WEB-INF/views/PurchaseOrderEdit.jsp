<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO PURCHASE ORDER EDIT PAGE</h3>

<form:form action="save" method="POST" modelAttribute="purchaseOrder">
<pre>

PURCHASEORDER ID:
<form:input path="pordId" readonly="true"/>
ORDERCODE:
<form:input path="pordCode"/>
REF NUM:
<form:input path="refNum"/>
QUALITY CHECK:
<form:radiobutton path="quaCheck" value="REQUIRED"/>REQUIRED
<form:radiobutton path="quaCheck" value="NOTREQUIRED"/>NOTREQUIRED

DEFAULT STATUS:
<form:input path="defStatus"/>
DESCRIPTION:<form:textarea path="pordDesc"/>
<input type="submit" value="update ">

</pre>
</form:form>

${message}



</body>
</html>