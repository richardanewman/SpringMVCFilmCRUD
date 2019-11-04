<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/css/jsp-styles.css" rel="stylesheet" type="text/css">
<title>Register | Almost IMDB</title>
</head>
<body>
<form:form action="createFilm.do" method="POST" modelAttribute="actor">
		<form:label path="firstName">Title:</form:label>
		<form:input path="firstName" />
		<form:errors path="firstName" />
		<br />
		<form:label path="lastName">Description:</form:label>
		<form:input path="lastName" />
		<form:errors path="lastName" />
		<br />
	    <input type="submit" value="Submit" />
	</form:form>
</body>
</html>