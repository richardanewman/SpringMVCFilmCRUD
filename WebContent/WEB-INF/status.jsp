<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/css/jsp-styles.css" rel="stylesheet"
	type="text/css">
<title>Film Status</title>
</head>
<body>
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
						<td><strong>Film Category: </strong>${film.category}</td>
					</tr>

				</table>
				<hr>
			</c:forEach>
		</c:when>
	</c:choose>
		
		<form action="deleteFilm.do" method="POST">
			<strong>Please enter film ID to confirm
				deletion:&nbsp;&nbsp;</strong> <input type="text" name="id"> <input
				type="submit" value="Delete Film" />
		</form>


		<form action="editFilmForm.do" method="GET">
			<strong>Please enter film ID to edit fields:</strong><input
				type="text" name="id"> <input type="submit"
				value="Edit Film" />
		</form>


</body>
</html>