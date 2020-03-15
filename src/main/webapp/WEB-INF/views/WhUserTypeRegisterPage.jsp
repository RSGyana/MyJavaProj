<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<H4>WELCOME TO USER REGISTER PAGE</H4>
	<form:form action="save" method="POST" modelAttribute="user">
		<pre>

	ORDER TYPE:
	<form:radiobutton path="userType" value="VENDOR"/>VENDOR
	<form:radiobutton path="userType" value="CUSTOMER"/>CUSTOMER
	
	<br/> 
	USER CODE:
	<form:input path="userCode"/>
	<br>
	USER FOR:
	<form:radiobutton path="userFor" value="SALE"/>SALE
	<form:radiobutton path="userFor" value="PURCHASE"/>PURCHASE
	
	
	USER EMAAIL:
	<form:input path="userEmail"/>
	
	USER CONTACT:
	<form:input path="userContact"/>
	
	 USER ID TYPE:

	<form:select path="userIdType">
		<form:option value="--select--">--select--</form:option>
		<form:option value="PAN CARD">PAN CARD</form:option>
		<form:option value="AADHAR CARD">AADHAR CARD</form:option>
		<form:option value="VOTER CARD">VOTER CARD</form:option>
		<form:option value="OTHER">OTHER</form:option>
	</form:select>
	<br/>
	<br/> IF OTHER ID:
	<form:input path="userOtherId"/>
	<br/>
	ID NUMBER:
	<form:input path="userIdNum"/>
 
	<input type="submit"  value="CREATE USER">
</pre>
</form:form>
${message}

</body>
</html>