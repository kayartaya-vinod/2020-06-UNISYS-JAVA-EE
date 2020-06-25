<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!-- connection pool -->
<sql:setDataSource var="ds" driver="org.h2.Driver"
	url="jdbc:h2:tcp://localhost/~/jspdemo" user="vinod"
	password="Welcome#123" />

<sql:query dataSource="${ds}" var="customers">select * from customers</sql:query>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Basics, by Vinod</title>

<link rel="stylesheet" type="text/css"
	href="https://bootswatch.com/4/sketchy/bootstrap.min.css">

</head>
<body>

	<div class="container">
		<h1 class="alert alert-primary">JSP Basics</h1>
		<h3>List of all customers</h3>

		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email address</th>
					<th>Phone number</th>
					<th>City</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customers.rows }" var="c">
				<tr>
					<td>${c.id}</td>
					<td>${c.name}</td>
					<td>${c.email}</td>
					<td>${c.phone}</td>
					<td>${c.city}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</div>

</body>
</html>