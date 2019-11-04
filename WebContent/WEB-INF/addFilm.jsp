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
<title>Find Film by ID</title>
</head>
<form:form action="createFilm.do" method="POST" modelAttribute="film">
		<form:label path="title">Title:</form:label>
		<form:input path="title" />
		<form:errors path="title" />
		<br />
		<form:label path="description">Description:</form:label>
		<form:input path="description" />
		<form:errors path="description" />
		<br />
		<form:label path="releaseYear">Release Year:</form:label>
		<form:input path="releaseYear" />
		<form:errors path="releaseYear" />
		<br />
		<form:select path="languageId">Language: 
			<form:option value="1">English</form:option>
			<form:option value="2">Italian</form:option>
			<form:option value="3">Japanese</form:option>
			<form:option value="4">Mandarin</form:option>
			<form:option value="5">French</form:option>
			<form:option value="6">German</form:option>
		</form:select>
		<form:label path="rentalDuration">Rental Duration:</form:label>
		<form:input path="rentalDuration" />
		<form:errors path="rentalDuration" />
		<br />
		<form:label path="length">Length:</form:label>
		<form:input path="length" />
		<form:errors path="length" />
		<br />
		<form:label path="replacementCost">Replacement Cost:</form:label>
		<form:input path="replacementCost" />
		<form:errors path="replacementCost" />
		<br />
		<form:label path="rating">Rating:</form:label>
		<form:input path="rating" />
		<form:errors path="rating" />
		<br />
		<form:select path="specialFeatures">Special Features: 
			<form:option value="Trailers">Trailers</form:option>
			<form:option value="Commentaries">Commentaries</form:option>
			<form:option value="Deleted Scenes">Deleted Scenes</form:option>
			<form:option value="Behind the Scenes">Behind the Scenes</form:option>
			<form:option value="None">None</form:option>
		</form:select>
		<br />
	    <input type="submit" value="Submit" />
	</form:form>
</body>
</html>