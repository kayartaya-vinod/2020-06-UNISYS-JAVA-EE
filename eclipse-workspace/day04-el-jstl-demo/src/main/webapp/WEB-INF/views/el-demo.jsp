<%@page import="com.unisys.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Basics, by Vinod</title>
</head>
<body>
	<h1>JSP Basics</h1>
	<hr>

<div>10 + 20 is ${10+20}</div>

<div>
	<p>Name is ${param.name==null? "Unknown": param.name } and city is
		${param.city==null ? "Unknown": param.city}</p>
	<form action="el-demo">
		<div>
			Name: 
			<input type="text" placeholder="Eg, John Doe" 
				size="40" name="name" value="${param.name }">
		</div>
		<div>
			City: 
			<input type="text" placeholder="Eg, Dallas" 
				size="40" name="city" value="${param.city }">
		</div>
		<button>Submit</button>
	</form>
</div>

<h3>Customer details</h3>
<div>Name: <%=((Customer)request.getAttribute("customer")).getName() %></div>
<div>Name: ${customer.name}</div> <!-- ((Customer)request.getAttribute("customer")).getName() -->
<div>Email address: ${customer.email}</div>
<div>Phone number: ${customer.phone}</div>
<div>City: ${customer.city}</div>

<h3>Request.count = ${requestScope.count}</h3>
<h3>Session.count = ${sessionScope.count}</h3>
<h3>Application.count = ${applicationScope.count}</h3>

<hr>
<h3>There are ${ customerList.size() } customers</h3>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul>
	<c:forEach items="${customerList}" var="c1">
	<li>${c1.name}</li>
	</c:forEach>
</ul>





















</body>
</html>