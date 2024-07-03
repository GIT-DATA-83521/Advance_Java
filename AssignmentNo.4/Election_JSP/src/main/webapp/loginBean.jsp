<%@page import="com.sunbeam.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="request" />
	<jsp:setProperty name="lb" property="email" param="email" />
	<jsp:setProperty name="lb" property="password" param="passwd" />
	<% 
		lb.authenticate();
		User user= lb.getUser();
	%>
	<% if(user!=null ) { %>
	Welcome <%= user.getFirstName() %>
	<jsp:forward page="candlist.jsp"/>
	<%} else { %>
	Login failed
	<% } %>
</body>
</html>