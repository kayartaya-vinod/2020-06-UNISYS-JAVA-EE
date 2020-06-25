<%@ include file="header.jspf"%>

<h3>List of customers</h3>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table table-striped table-bordered">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email address</th>
			<th>Phone number</th>
			<th>City</th>
			<th>Delete?</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${customers }" var="c">
			<tr>
				<td>${c.id}</td>
				<td>${c.name}
					
					
				</td>
				<td>${c.email}</td>
				<td>${c.phone}</td>
				<td>${c.city}</td>
				<td>
					<a href="./delete-customer?id=${c.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="footer.jspf"%>