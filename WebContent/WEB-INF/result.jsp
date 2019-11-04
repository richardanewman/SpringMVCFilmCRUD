<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/jsp-styles.css" rel="stylesheet" type="text/css">
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
     <%--  <strong>Rental Rate:</strong> ${film.rentalRate}
      <br> --%>
      <strong>Film Length:</strong> ${film.length}
      <br>
      <strong>Replacement Cost:</strong> ${film.replacementCost}
      <br>
      <strong>Film Rating:</strong> ${film.rating}
      <br>
      <strong>Special Features:</strong> ${film.specialFeatures}
      <br>
      <strong>Category:</strong> ${film.category}
      <br>
    </c:when>
		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${! empty result}">
		<br>
      	${result}
    	</c:when>
	</c:choose>

	<br>

	<form action="deleteFilm.do" method="POST">
		<strong>Please enter film ID to confirm deletion:</strong> <input type="text" name="id">
		<input type="submit" value="Delete Film" />
	</form>
	<br>
	<form action="editFilmForm.do" method="GET">
		<strong>Please enter film ID to edit fields:</strong><input type="text" name="id">
		<input type="submit" value="Edit Film" />
	</form>

</body>
</html>