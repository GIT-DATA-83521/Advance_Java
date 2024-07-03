<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    
	<jsp:useBean id="res" class="com.sunbeam.Bean.CandidateListBean" />
	${res.fetchCandidates() }
	<a href="announcement.jsp">announce</a> <br/><br/>
	<table border="1">
		<thead>
			<th>Id</th>
			<th>Name</th>
			<th>Party</th>
			<th>Votes</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach var="c" items="${res.candidateList }">
				<tr>
					<td>${c.id}</td>
					<td>${c.name}</td>
					<td>${c.party}</td>
					<td>${c.votes}</td>
					<td><a href="editcand.jsp?id=${c.id}"> <img
							src="images/edit.jpg" alt="Edit" width="24" height="24" />
					</a> <a href="delcand.jsp?id=${c.id}"> <img src="images/delete.png"
							alt="Delete" width="24" height="24" />
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/><br/>
	<a href="logout.jsp]">Sign Out</a>
</body>
</html>