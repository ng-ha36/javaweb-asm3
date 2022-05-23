<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/home.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="header.jsp" %>
	<div class="container mb-100">
	    <div class="col-9">
	      <div class="row">
	        <c:forEach items="${listP}" var="o">
	        <div class="col-12 col-md-6 col-lg-4">
	          <div class="card mt-4">
	            <img class="card-img-top" src="${o.src}" alt="Card image cap">
	            <div class="card-body">
	              <h4 class="card-title show-txt">${o.type}</h4>
	              <h6 class="card-title show-txt"><a href='<c:url value="/detail?id=${o.id}" ></c:url>'>${o.name}</a></h6>
	              <p class="card-title show-txt">$${o.price}</p>
	            </div>
	          </div>
	        </div>
	        </c:forEach>
	      </div>
	    </div>
    </div>
<%@ include file="footer.jsp" %>
</body>
</html>