<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="custom-tags-by-vinod" prefix="vnd" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Basics, by Vinod</title>
</head>
<body>
<h1>JSP Basics</h1>
<hr>

<%-- 
<vnd:table cssClass="table table-bordered table-striped">
id,name,email,city
1,Vinod Kumar,vinod@vinod.co,Bangalore
2,Shyam sundaar,shyam@example.com,Bangalore
</vnd:table>


<vnd:table cssClass="table table-bordered table-striped">
<%@ include file="data.csv" %>
</vnd:table>

--%>

<vnd:include type="ol" file="names.txt" />



<vnd:include type="ul" file="names.txt" />

</body>
</html>