<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/home.css">
<link rel="stylesheet" href="css/info.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>

	<c:out value="${product.getName()}"></c:out>
	<div class="container-fluid">
		<hr>
		<div class="product">
			<div class="lef">
				<img src="${product.getSrc()}" alt="product">
			</div>
			<div class="righ">

				<b>$${product.getPrice()}</b> <br />
				<c:forTokens items="${product.getDescription()}" delims=","
					var="myToken">
					<c:out value="${myToken}" />
					<br />
				</c:forTokens>
				<form action="AddToCartController" method="get">
					<input type="hidden" name="id" value="${product.getId()}"></input>
					<input type="hidden" name="action" value="add"></input>
					<div class="col-3">
						<button type="submit" class="btn btn-primary mt-2 mb-2">
							Add to cart</button>
					</div>
				</form>

			</div>
		</div>
	</div>
</body>
</html>