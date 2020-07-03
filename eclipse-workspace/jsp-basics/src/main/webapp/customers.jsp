<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="./error.jsp" session="false"%>

<%!Connection conn;

	public void jspInit() {
		try {
			Class.forName("org.h2.Driver"); // not required; but for good practice;
			String url = "jdbc:h2:tcp://localhost/~/jspdemo";
			String user = "vinod";
			String password = "Welcome#123";
			this.conn = DriverManager.getConnection(url, user, password);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public void jspDestroy() {
		try {
			this.conn.close();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Basics, by Vinod</title>
</head>
<body>
	<h1>List of all customers</h1>
	<hr>
	<table border="1" width="500px">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email id</th>
				<th>Phone number</th>
				<th>City</th>
			</tr>
		</thead>
		<tbody>
			<%
				String sql = "select * from customers";

			try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString("id")%></td>
				<td><%=rs.getString("name")%></td>
				<td><%=rs.getString("email")%></td>
				<td><%=rs.getString("phone")%></td>
				<td><%=rs.getString("city")%></td>
			</tr>
			<%
				}
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
			%>
		</tbody>
	</table>

</body>
</html>