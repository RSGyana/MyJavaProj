<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


<body>
	<%@ include file="UserMenu.jsp"%>

	<div class="container">
		<div
			class="card-header bg-primary text-center text-white text-uppercase">
			<h3>WELCOME TO SHIPPING REGISTER PAGE</h3>
		</div>
		<div class="card-body">
			<form:form action="save" method="post" modelAttribute="shippping">
				<div class="row">
					<div class="col-4">
						<label for="shippCode"> SHIPPING CODE: </label>
					</div>
					<div class="col-4">
						<form:input path="shippCode" class="form-control" />
					</div>
					<div class="col-4">
						<!-- error message -->
					</div>
				</div>

				<div class="row">
					<div class="col-4">
						<label for="refNum"> SHIPPING REF NUM: </label>
					</div>
					<div class="col-4">
						<form:input path="refNum" class="form-control" />
					</div>
					<div class="col-4">
						<!-- error message -->
					</div>
				</div>

				<div class="row">
					<div class="col-4">
						<label for="courierRefNum"> COURIERREFNUM: 
					</div>
					<div class="col-4">
						<form:input path="courierRefNum" class="form-control" />
					</div>
					<div class="col-4">
						<!-- error message -->
					</div>
				</div>

				<div class="row">
					<div class="col-4">
						<label for="contDtls"> CONTACT DETAILS: </label>
					</div>
					<div class="col-4">
						<form:input path="contDtls" class="form-control" />
					</div>
					<div class="col-4">
						<!-- error message -->
					</div>
				</div>

				<div class="row">
					<div class="col-4">
						<label for="saleOrderCode"> SALE ORDER CODE: </label>
					</div>
					<div class="col-4">
						<form:input path="saleOrderCode" class="form-control" />
					</div>
					<div class="col-4">
						<!-- error message -->
					</div>
				</div>


				
			<div class="row">
					<div class="col-4">
						<label for="note"> DESCRIPTION: </label>
					</div>
					<div class="col-4">
						<form:input path="note" class="form-control" />
					</div>
					<div class="col-4">
						<!-- error message -->
					</div>
				</div>
				
							<div class="row">
					<div class="col-4">
						<label for="billToAdrs"> BILL TO ADRS: 
					</div>
					<div class="col-4">
						<form:input path="billToAdrs" class="form-control" />
					</div>
					<div class="col-4">
						<!-- error message -->
					</div>
				</div>
				
				<div class="row">
					<div class="col-4">
					<label for="shipToAdrs"> SHIP TO ADRS: 
					
					</div>
					<div class="col-4">
						<form:input path="shipToAdrs" class="form-control" />
					</div>
					<div class="col-4">
						<!-- error message -->
					</div>
				</div>
				

				

				<div class="row">
					<div class="col-4"></div>
					<div class="col-4">
						<input type="submit" value="CREATE PART" class="btn btn-success" />
						<input type="reset" value="CLEAR" class="btn btn-danger" />

					</div>
					<div class="col-4">
						<!-- error message -->
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<c:if test="${!empty message }">
		<div class="card-footer bg-info text-white text-center">

			<b>${message}</b>

		</div>
	</c:if>

	</div>
	<!-- container end -->

</body>

</html>