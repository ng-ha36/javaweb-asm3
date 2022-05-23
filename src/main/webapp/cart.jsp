<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="model.Cart"%>
<%@page import="model.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/home.css">
<link rel="stylesheet" href="css/cart.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<%@ include file="header.jsp" %>
<table class="table table-bordered mt-3">
  <thead>
    <tr>
      <th scope="col"><b>Products in cart:</b></th>
      <th scope="col"><b>Price</b></th>
      <th scope="col"><b>Quantity</b></th>
      <th scope="col"><b>Amount</b></th>
    </tr>
  </thead>
  <tbody>
  
  <% 
    // lay cart tu session
    Cart c = (Cart)session.getAttribute("cart");
    List<Product> products = c.getItems();
    double total = 0.0;
    for( Product p : products) {
    	total += p.getNumber() * p.getPrice();
   %>
	    <tr>
	      <th scope="row"><%= p.getName()%></th>
	      <td><%= p.getPrice()%>$</td>
	      <td><%= p.getNumber()%></td>
	      <td><%= p.getNumber() * p.getPrice()%>$</td>
	    </tr>
	<% 
	 }
    %>
    <tr>
      <td colspan="4">Total: <b> <%=String.format("%.2f", total)%>$</b></td>
    </tr>
  </tbody>
</table>
<form action="PayController" method="get">
	<div class="table2">
	  <div class="row">
	    <div class="col">
	      Customer name: 
	    </div>
	    <div class="col">
	      <input type="text" name="name">
	    </div>
	  </div>
	  <div class="row">
	    <div class="col">
	     Customer address:
	    </div>
	    <div class="col">
	      <input type="text" name="address">
	    </div>
	  </div>
	    <div class="row">
	    <div class="col">
	      Customer code(if any):
	    </div>
	    <div class="col">
	      <input type="text" name="discount">
	    </div>
	  </div>
	  </div>
	<div class="col-3 mb-3">
		<button type="submit" class="btn btn-primary">Submit</button>
	</div>
</form>
<%@ include file="footer.jsp" %>
</body>
</html>