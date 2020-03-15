<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="UserMenu.jsp"%>
	<div class="container">
		

			<div
				class="card-header bg-primary text-center text-white text-uppercase">
				<h6>welcome to register page</h6>
			</div>
			<div class="card-body">

				<form:form action="save" method="POST" modelAttribute="shipmentType">
					<div class="row">
						<div class="col-4">
							<label for="shipMode">SHIPMENT MODE </label>
						</div>

						<div class="col-4">

							<form:select path="shipMode" class="form-controller">

								<form:option value=">--select--">--select--</form:option>
								<form:option value="Air">Air</form:option>
								<form:option value="Truck">Truck</form:option>
								<form:option value="Ship">Ship</form:option>
								<form:option value="Train"> Train</form:option>
							</form:select>

						</div>

						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="shipCode">SHIPMENT CODE</label>
						</div>
						<div class="col-4">
							<form:input path="shipCode" class="form-controller" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="enbShip">ENABLE SHIPMENT</label>
						</div>
						
						<div class="col-4">
							<form:select path="enbShip">
								<form:option value="--select--">--select--</form:option>
								<form:option value="Yes">Yes</form:option>
								<form:option value="No">No</form:option>
							</form:select>

						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>


					</div>

					<div class="row">
						<div class="col-4">
							<label for="shipGrade">SHIPMENT GRADE</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="shipGrade" value="A" />
							A
							<form:radiobutton path="shipGrade" value="B" />
							B
							<form:radiobutton path="shipGrade" value="C" />
							C

						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="shipDesc">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:textarea path="shipDesc" class="form-controller" />
						</div>
						<div class="col-4">
							<!--      error message -->
						</div>

					</div>
					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="CREATE" class="btn btn-success" /> <input
								type="reset" value="CLEAR" class="btn btn-danger" />
						</div>
						<div class="col-4">
							<!--                    error message -->
						</div>
					</div>
				</form:form>
			</div>
			<c:if test="${!empty message }">
				<div class="card-footer bg-info text-white text-center">

					<b>${message}</b>

				</div>
			</c:if>

		</div>
		<!-- card end point -->
		<div>
			<!--     container end poi -->
</body>
</html>