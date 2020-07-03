<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Basics, by Vinod</title>
</head>
<body>
	<h1>Multiplication Table using JSP</h1>
	<hr>

	<h3>Enter following details:</h3>
	<!-- in the absence of the attribute action or if action="", then action refers to the same file -->
	<form>
		<div>
			<label for="n">Enter number: </label> <input type="number" id="n"
				name="num" value="23">
		</div>
		<div>
			<label for="l">Enter limit: </label> <input type="number" id="l"
				name="limit" value="10">
		</div>

		<button>Submit</button>
	</form>


	<%
		String input = request.getParameter("num");
	if (input != null) {
		int num = Integer.parseInt(input);
		int limit = Integer.parseInt(request.getParameter("limit"));

		for (int i = 1; i <= limit; i++) {
			%>
			<%=num %> X <%=i %> = <%=num*i %> <br>
			<%
		}
	}
	%>

</body>
</html>