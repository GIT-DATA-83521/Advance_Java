<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="Rb" class="com.sunbeam.beans.RegistrationBean" scope="request" />
	<jsp:setProperty name="Rb" property="id" param="id" />
	<jsp:setProperty name="Rb" property="firstName" param="first_name" />
	<jsp:setProperty name="Rb" property="lastName" param="last_name" />
	<jsp:setProperty name="Rb" property="email" param="email" />
	<jsp:setProperty name="Rb" property="password" param="passwd" />
	<jsp:setProperty name="Rb" property="status" param="status" />
	<jsp:setProperty name="Rb" property="role" param="role" />
	<% 
		String birthParam = request.getParameter("birth");
	if(birthParam!=null){
		try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = format.parse(birthParam);
            java.sql.Date birthDate = new java.sql.Date(parsed.getTime());
            Rb.setBirth(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
           
        }
    }

    Rb.authenticate();
    int n = Rb.getN();
%>

<% if (n != 0) { %>
    Register Successfully
<% } else { %>
    Register Failed.
<% } %>

</body>
</html>	
	