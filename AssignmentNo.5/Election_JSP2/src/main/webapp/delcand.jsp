<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>${initParam.appTitle}</h3>
	
	<h3>Announcements</h3>
    <p>${an.message}</p>
    
	<jsp:useBean id="db" class="com.sunbeam.Bean.DeleteCandBean"/>
	<jsp:setProperty name="db" property="*" />
	${ db.deleteCandidate() }
	<c:choose>
		<c:when test="${db.count == 1}">
			<c:redirect url="result.jsp"/>
		</c:when>
		<c:otherwise>
			Candidate delete failed. <br/><br/>
			<a href="result.jsp">Show Result</a>
		</c:otherwise>
	</c:choose>

</body>
</html>