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
<title>Add New Film</title>
</head>
<div class="filmForm">
<h1>Add A New Film</h1>
<form:form action="createFilm.do" method="POST" modelAttribute="film">
		<form:label path="title">Title:</form:label><br>
		<form:input class="input" path="title" required="required" placeholder="Enter Title"/>
		<form:errors path="title" />
		<br />
		<form:label path="description" >Description:</form:label><br>
		<form:input class="input" path="description" required="required" placeholder="Enter Description"/>
		<form:errors path="description" />
		<br />

		<form:label path="releaseYear">Release Year:</form:label><br>
		<form:input class="input" path="releaseYear" min="0" max="2029" type="number" required="required" placeholder="Year" />
		<form:errors path="releaseYear" />
		<br />
		<form:label path="languageId">Language: </form:label><br>
		<form:select path="languageId"> 
			<form:option value="1" >English</form:option>
			<form:option value="2">Italian</form:option>
			<form:option value="3">Japanese</form:option>
			<form:option value="4">Mandarin</form:option>
			<form:option value="5">French</form:option>
			<form:option value="6">German</form:option>
		</form:select>
		<br>
		<form:label path="rentalDuration">Rental Duration:</form:label><br>
		<form:input class="input" path="rentalDuration" min="0" type="number" required="required" placeholder="Enter Days"/>
		<form:errors path="rentalDuration" />
		<br>
		<form:label path="length">Length:</form:label><br>
		<form:input class="input" path="length" min="0" type="number" required="required" placeholder="Enter Length In Minutes"/>
		<form:errors path="length" />
		<br>
		<form:label path="replacementCost">Replacement Cost:</form:label><br>
		<form:input class="input" path="replacementCost" type="number" min="0" step="0.01" required="required" placeholder="Enter Cost"/>
		<br>
	
		<form:label path="rating">Rating:</form:label><br>
		<form:input class="input" path="rating" required="required" placeholder="Enter Rating"/>
		<form:errors path="rating" />
		<br>
		<form:label path="specialFeatures">Special Features: </form:label><br>
		<form:select path="specialFeatures"> 
			<form:option value="Trailers">Trailers</form:option>
			<form:option value="Commentaries">Commentaries</form:option>
			<form:option value="Deleted Scenes">Deleted Scenes</form:option>
			<form:option value="Behind the Scenes">Behind the Scenes</form:option>
			<form:option value="None">None</form:option>
		</form:select>
		<br />
	    <input class="submit" type="submit" value="Submit" />
	</form:form>
	</div>
</body>
</html>