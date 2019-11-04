<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="resources/css/jsp-styles.css" rel="stylesheet"
	type="text/css">

<nav class="navbar">
	<a href="index.html"><img src="resources/css/logo.png" width="85"
		height="58" class="d-inline-block align-top" alt=""></a> <span
		class="navbar-toggle" id="js-navbar-toggle"> <i
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
<title>Search Results</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty film}">
			<strong>Title:</strong> ${film.title}
      <br>
			<strong>Year Released:</strong>${film.releaseYear}
      <br>
			<strong>Film Language:</strong> ${film.language}
      <br>
			<strong>Film Description:</strong> ${film.description}
      <br>
			<strong>Rental Duration:</strong> ${film.rentalDuration}
      <br>
			<strong>Film Length:</strong> ${film.length}
      <br>
			<strong>Replacement Cost:</strong> ${film.replacementCost}
      <br>
			<strong>Film Rating:</strong> ${film.rating}
      <br>
			<strong>Special Features:</strong> ${film.specialFeatures}
      <br>
    <c:if test="${not empty film.category }">
			<strong>Film Category:</strong> ${film.category}
    </c:if>
      
		</c:when>
		<c:otherwise>
		
			${noFilm}
		</c:otherwise>
	</c:choose>


	<c:choose>
		<c:when test="${! empty result}">
			<hr>
			<strong>${result}</strong>
		</c:when>
	</c:choose>

	<hr>

	<span style="float: left">
		<form action="deleteFilm.do" method="POST" align="left">
			<strong>Please enter film ID to confirm deletion:</strong> <input
				type="number" name="id"> <input type="submit"
				value="Delete Film" />
		</form>
	</span>

	<span style="float: right">
		<form action="editFilmForm.do" method="GET" align="right">
			<strong>Please enter film ID to edit fields:</strong><input
				type="number" name="id"> <input type="submit"
				value="Edit Film" />
		</form>
	</span>
</body>
</html>