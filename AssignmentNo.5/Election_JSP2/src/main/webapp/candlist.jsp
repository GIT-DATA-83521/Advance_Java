<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.sunbeam.Bean.AnnouncementBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidates</title>
</head>
<body>
    <h3><c:out value="${initParam.appTitle}"/></h3>
    Hello <c:out value="${lb.user.firstName}"/> <c:out value="${lb.user.lastName}"/>
   
    <h3>Announcements</h3>
    <p>${an.message}</p>
    
    <jsp:useBean id="clb" class="com.sunbeam.Bean.CandidateListBean" scope="session"/>
    <jsp:useBean id="an" class="com.sunbeam.Bean.AnnouncementBean" scope="application"/>
    <h3>Candidates</h3>
    ${clb.fetchCandidates()}
    <form method="post" action="vote.jsp">
        <c:forEach var="c" items="${clb.candidateList}">
            <input type="radio" name="candidate" value="${c.id}"/> ${c.name } - ${c.party} <br/> <br/>
        </c:forEach>
        <br/> <input type="submit" value="Vote" />
    </form>
</body>
</html>
