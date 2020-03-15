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
<h3>welcome to purchase order page</h3>


	<form:form action="save" method="POST" modelAttribute="purchaseOrder">
<pre>
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
<input type="submit" value="PLACE ORDER">

</pre>
</form:form>

${message}




</body>
</html>