<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Online voting</h3>
<form method="post" action="loginBean.jsp">
	Email: <input type="text" name="email"/> <br/> <br/>
	Password: <input type="password" name="passwd"/> <br/> <br/>
	<input type="submit" value="Sign in"/>
	<a href="register.jsp">Sign Up</a>
</form>


</body>
</html>