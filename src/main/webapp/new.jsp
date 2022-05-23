<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="total" value="0"></c:set>
	<c:forEach var="n" begin="1" end="20">
		<c:set var="total" value="${total + n }"></c:set>
	</c:forEach>
	<c:out value="${total }"></c:out>
</body>
</html>