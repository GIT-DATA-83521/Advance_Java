<%@page import="com.sunbeam.pojo.Candidate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate list</title>
</head>
<body>
<jsp:useBean id="cl" class="com.sunbeam.beans.CandidateListBean" scope="request" />
	<h3>Online Voting</h3>
	<form method="post" action="">
		<%
			List<Candidate> list =cl.getCanList();
		for(Candidate c:list){
		%>
		<input type="radio" name="candidate" value="<%= c.getId() %>"/>
		<%= c.getName() %>
		(<%= c.getParty() %>)<br/>
		<%
		}
		%>
		<input type="submit" />
	</form>
</body>
</html>