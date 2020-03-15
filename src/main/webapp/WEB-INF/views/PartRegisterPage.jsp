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
			<h3>WELCOME TO PART REGISTER PAGE</h3>
		</div>
		<div class="card-body">
			<form:form action="save" method="post" modelAttribute="part">
				<div class="row">
					<div class="col-4">
						<lebel for="partCode"> CODE: 
					</div>
					<div class="col-4">
						<form:input path="partCode" class="form-controll" />
					</div>
					<div class="col-4">
						<!-- error message -->
					</div>
				</div>

				<div class="row">
					<div class="col-4">
						<lebel for="width"> WIDTH: 
					</div>
					<div class="col-4">
						<form:input path="width" class="form-controll" />
					</div>
					<div class="col-4">
						<!-- error message -->
					</div>
				</div>

				<div class="row">
					<div class="col-4">
						<lebel for="length"> LENGTH: 
					</div>
					<div class="col-4">
						<form:input path="length" class="form-controll" />
					</div>
					<div class="col-4">
						<!-- error message -->
					</div>
				</div>

				<div class="row">
					<div class="col-4">
						<lebel for="height"> HEIGHT: 
					</div>
					<div class="col-4">
						<form:input path="height" class="form-controll" />
					</div>
					<div class="col-4">
						<!-- error message -->
					</div>
				</div>

				<div class="row">
					<div class="col-4">
						<lebel for="baseCost"> BASE COST: 
					</div>
					<div class="col-4">
						<form:input path="baseCost" class="form-controll" />
					</div>
					<div class="col-4">
						<!-- error message -->
					</div>
				</div>

				<div class="row">
					<div class="col-4">
						<lebel for="baseCurrency"> BASE CURRENCY: 
					</div>
					<div class="col-4">
						<form:select path="baseCurrency" class="form-controll">
							<form:option value="--SELECT--">--SELECT--</form:option>
							<form:option value="INR">INR</form:option>
							<form:option value="USD">USD</form:option>
							<form:option value="AUS">AUS</form:option>
							<form:option value="EUR">EUR</form:option>
						</form:select>
					</div>
					<div class="col-4">
						<!-- error message -->
					</div>
				</div>
				
				<!-- 				module integration-->
				<div class="row">
					<div class="col-4">
						<label for="uomOb.uomId"> UOM</label>

					</div>
					<div class="col-4">
						<form:select path="uomOb.uomId" class="form-control">
							<form:option value="select">select</form:option>
							<form:options items="${uomMap}"></form:options>
						</form:select>
					</div>
					<div class="col-4">
					</div>
				</div>
					<!-- 				module integration-->
				<div class="row">
					<div class="col-4">
						<label for="omOb.orderId"> ORDERMETHOD</label>

					</div>
					<div class="col-4">
						<form:select path="omOb.orderId" class="form-control">
							<form:option value="">-select Sale-</form:option>
							<form:options items="${omSaleMap}"></form:options>
						</form:select>
					</div>
					<div class="col-4">
					</div>
				</div>
				<div class="row">
					<div class="col-4">

					</div>
					<div class="col-4">
						<form:select path="omOb.orderId" class="form-control">
							<form:option value="">-select Purchase-</form:option>
							<form:options items="${omPurchaseMap}"></form:options>
						</form:select>
					</div>
					<div class="col-4">
					</div>
				</div>
				
				
				
							<div class="row">
					<div class="col-4">
						<lebel for="PartDesc"> DESCRIPTION: 
					</div>
					<div class="col-4">
						<form:input path="PartDesc" class="form-control" />
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