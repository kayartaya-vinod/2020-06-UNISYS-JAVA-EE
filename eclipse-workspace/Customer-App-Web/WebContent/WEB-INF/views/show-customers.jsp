<%@ include file="./header.jspf"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>List of all customers</h3>

<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>City</th>
			<th>Email address</th>
			<th>Phone number</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${requestScope.customers}" var="c">
		<tr>
			<td>${c.id}</td>
			<td>${c.name}</td>
			<td>${c.city}</td>
			<td>${c.email}</td>
			<td>${c.phone}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<%@ include file="./footer.jspf"%>