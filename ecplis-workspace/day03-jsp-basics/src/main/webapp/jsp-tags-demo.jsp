<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="custom-tags-by-vinod" prefix="vinod" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Basics, by Vinod</title>
</head>
<body>
<h1>JSP Basics</h1>
<hr>

<vinod:include type="ol" file="names.txt" />



<vinod:include type="ul" file="names.txt" />

</body>
</html>