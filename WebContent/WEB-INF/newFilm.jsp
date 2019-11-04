<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="resources/css/jsp-styles.css" rel="stylesheet" type="text/css">

<nav class="navbar">
<a href="index.html"><img src="resources/css/logo.png" width="85" height="58" class="d-inline-block align-top" alt=""></a>
	<span class="navbar-toggle" id="js-navbar-toggle"> <i
		class="fas fa-bars"></i>
	</span> <a href="index.html" class="logo"></a>
	<ul class="main-nav" id="js-menu">
		<li><a href="index.html" class="nav-links">Home</a></li>
		<li><a href="filmByID.html" class="nav-links">Film By ID</a></li>
		<li><a href="addFilmForm.do" class="nav-links">Add Film</a></li>
		<li><a href="searchFilm.html" class="nav-links">Search Film</a></li>
	</ul>
</nav>

<meta charset="UTF-8">
<title>New Film Added</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty newfilm}">
      ${newfilm}
    </c:when>
		<c:otherwise>
			<p>Error. No film created.</p>
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<form action="deleteFilm.do" method="POST">
	Please enter film ID to confirm deletion:
	<input type="number" min="0" required="required" name="id">
	<input type="submit" value="Delete Film" />
	</form>
	<br>
	<form action="editFilmForm.do" method="GET">
	Please enter film ID to edit fields:
	<input type="text" min="0" required="required" name="id">
	<input type="submit" value="Edit Film" />
	</form>
	
</body>
</html>