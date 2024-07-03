<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3><c:out value="${initParam.appTitle}"/></h3>
    Hello <c:out value="${lb.user.firstName}"/> <c:out value="${lb.user.lastName}"/>
    <hr/>
    <jsp:useBean id="an" class="com.sunbeam.Bean.AnnouncementBean" scope="application"/>
    <jsp:setProperty name="an" property="ann" param="ann"/>
    <form method="post" action="announcement.jsp">
        Announcement: <br/>
        <textarea name="ann" rows="7" cols="88"></textarea>
        <br/><br/>
        <input type="submit" value="Announce"/>
    </form>
</body>
</html>
