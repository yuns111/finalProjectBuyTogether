<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%
	String cp = request.getContextPath();
%>

<html>
<head>
<link href="<%=cp%>/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

	<title>Home</title>
</head>


<body>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"
		type="text/javascript"></script>
	<script src="<%=cp%>/resources/bootstrap/js/bootstrap.min.js"></script>
	
<h1>
	Hello world!  
</h1>
<h2>Hi</h2>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
