<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<link href="resources/css/jsp-styles.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Find Film by ID</title>
</head>
<body>
	<h1>Welcome to Almost IMDB JSP</h1>
	<h2>Find A Film by ID</h2>
			${actor}
	<p>Please use the fields below to find a actor in our database by ID
		number.</p>
		
	<form action="findActorById.do" method="GET">
		ID: 
		
		<input type="text" value="0" name="id" />
		 <input type="submit"  value="Get Actor by ID" />


	</form>

</body>
</html>