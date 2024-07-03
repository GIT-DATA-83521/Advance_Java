<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h2>Register</h2>
   <form action="RegisterBean.jsp" method="post">
        First Name: <input type="text" name="first_name" required><br>
        Last Name: <input type="text" name="last_name" required><br>
        Email: <input type="email" name="email" required><br>
        Password: <input type="password" name="passwd" required><br>
        Date of Birth: <input type="date" name="birth" required><br>
        Status: <input type="number" name="status" required><br>
        Role: <input type="text" name="role" required><br>
        ID: <input type="number" name="id" required><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>