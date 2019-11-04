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
<title>Film Status</title>
</head>
<body>
	<div class="filmForm">
		<strong>${result}</strong>
		<hr>
		<c:choose>
			<c:when test="${! empty films}">
				<c:forEach items="${films}" var="film">
					<table>
						<tr>
							<td><strong>Film Id: </strong> ${film.id}</td>
						</tr>
						<tr>
							<td><strong>Film Title: </strong> ${film.title }</td>
						</tr>
						<tr>
							<td><strong>Release Year: </strong> ${film.releaseYear}</td>
						</tr>
						<tr>
							<td><strong>Film Language: </strong>${film.language}</td>
						</tr>
						<tr>
							<td><strong>Film Description: </strong>${film.description}</td>
						</tr>
						<tr>
							<td><strong>Rental Duration: </strong>${film.rentalDuration}</td>
						</tr>
						<tr>
							<td><strong>Film Length: </strong>${film.length}</td>
						</tr>
						<tr>
							<td><strong>Replacement Cost: </strong>${film.replacementCost}</td>
						</tr>
						<tr>
							<td><strong>Film Rating: </strong>${film.rating}</td>
						</tr>
						<tr>
							<td><strong>Special Features: </strong>${film.specialFeatures}</td>
						</tr>
						<tr>
							<td><strong>Actors: </strong>${film.actors}</td>
						</tr>
						<tr>
							<td><strong>Film Category: </strong>${film.category}</td>
						</tr>

					</table>
					<hr>
				</c:forEach>
			</c:when>
		</c:choose>
			<form action="deleteFilm.do" method="POST">
				<strong>Please enter film ID to confirm deletion:</strong> <br>
				<input class="input" min="1001" type="number" name="id"> 
				<input class="submit" type="submit" value="Delete Film" />
			</form>
			<form action="editFilmForm.do" method="GET">
				<strong>Please enter film ID to edit fields:</strong><br>
				<input class="input" min="0" type="number" name="id"> 
				<input class="submit" type="submit" value="Edit Film" />
			</form>

	</div>
</body>
</html>