<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/css/jsp-styles.css" rel="stylesheet" type="text/css">
<title>Edit Film | Almost IMDB</title>
</head>
<body>
<form:form action="editFilm.do" method="POST" modelAttribute="film">
		<form:label path="id" default="${film.id}" >ID: ${film.id } </form:label>
		
		<br />
		<form:label path="title">Title: </form:label>
		<form:input path="title" default="${film.title }" placeholder="${film.title }"/>
		<form:errors path="title" />
		<br />
		<form:label path="description">Description:</form:label>
		<form:input path="description" default="${film.description }" placeholder="${film.description }"/>
		<form:errors path="description" />
		<br />
		<form:label path="releaseYear">Release Year:</form:label>
		<form:input path="releaseYear" default="${film.releaseYear }" placeholder="${film.releaseYear }"/>
		<form:errors path="releaseYear" />
		<br />
		<form:label path="languageId">Language Currently Set To ${film.languageId }:</form:label>
		<form:select path="languageId"> 
			<form:option value="1" default="${film.languageId }" placeholder="${film.languageId }">English</form:option>
			<form:option value="2">Italian</form:option>
			<form:option value="3">Japanese</form:option>
			<form:option value="4">Mandarin</form:option>
			<form:option value="5">French</form:option>
			<form:option value="6">German</form:option>
		</form:select>
		<form:label path="rentalDuration">Rental Duration:</form:label>
		<form:input path="rentalDuration" default="${film.rentalDuration }" placeholder="${film.rentalDuration }"/>
		<form:errors path="rentalDuration" />
		<br />
		<form:label path="length">Length:</form:label>
		<form:input path="length" default="${film.length }" placeholder="${film.length }"/>
		<form:errors path="length" />
		<br />
		<form:label path="replacementCost">Replacement Cost:</form:label>
		<form:input path="replacementCost" default="${film.replacementCost }" placeholder="${film.replacementCost }"/>
		<form:errors path="replacementCost" />
		<br />
		<form:label path="rating">Rating:</form:label>
		<form:input path="rating" default="${film.rating }" placeholder="${film.rating }"/>
		<form:errors path="rating" />
		<br />
		<form:label path="specialFeatures">Special Features:</form:label>
		<form:select path="specialFeatures">
			<form:option value="Trailers" default="${film.specialFeatures }" placeholder="${film.specialFeatures }">Trailers</form:option >
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