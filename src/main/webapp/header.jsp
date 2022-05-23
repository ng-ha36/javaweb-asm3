<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<div class="top row">
      <div class="left col-4">
        <h1>PRJ321</h1>
        <p>Welcome to my Website</p>
      </div>
      <div class="right col-8 align-self-center">
        <form class="form-inline my-2 my-lg-0" action="search" method="post">
          <input class="form-control mr-sm-2" type="text" name="txt" value="${txtS}" placeholder="What are you looking for? ">
          <button class="btn btn-success my-2 my-sm-0" type="submit" >Search</button>
        </form>
      </div>
    </div>
    <div class="bottom row">
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navb">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navb">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <a class="nav-link" href="home">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="javascript:void(0)">Production</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="javascript:void(0)">About Us</a>
            </li>
          </ul>
          
	      <h3 class="right-item"><a href="login.jsp">Login</a></h3>
	      <h3 class="right-item"><a href="register.jsp">Register</a></h3>
		  
          
        </div>
      </nav>

    </div>