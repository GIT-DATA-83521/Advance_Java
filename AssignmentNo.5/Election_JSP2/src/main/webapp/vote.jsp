<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote</title>
</head>
<body>
	<h3>${initParam.appTitle}</h3>
	<jsp:useBean id="vb" class="com.sunbeam.Bean.VoteBean"/>
	<jsp:setProperty name="vb" property="id" param="candidate" />
	${ vb.incrementVote() }
	<c:choose>
		<c:when test="${vb.count == 1}">
		Hello Voter! <br/>
		Vote done Successfully! <br/><br/>
			<a href="logout.jsp">Logout</a>
		</c:when>
		<c:otherwise>
			Vote failed. <br/><br/>
			<a href="login.jsp">Show Result</a>
		</c:otherwise>
	</c:choose>
</body>
</html>