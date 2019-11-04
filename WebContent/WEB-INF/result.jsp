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
      <strong>Film Length:</strong> ${film.length}
      <br>
      <strong>Replacement Cost:</strong> ${film.replacementCost}
      <br>
      <strong>Film Rating:</strong> ${film.rating}
      <br>
      <strong>Special Features:</strong> ${film.specialFeatures}
      <br>
      <c:choose>
				<c:when test="${! empty film.category}">
					<strong>Category:</strong> ${film.category}
     			 </c:when>
			</c:choose>
      <br>
    </c:when>
		<c:otherwise>
			<p>${noFilm}</p>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${! empty result}">
		<hr>
      	<strong>${result}</strong>
    	</c:when>
	</c:choose>

	<hr>

	<span style="float:left">
		<form action="deleteFilm.do" method="POST" align="left">
			<strong>Please enter film ID to confirm
				deletion:</strong> <input type="number" name="id"> <input
				type="submit" value="Delete Film" />
		</form>
	</span>
	
	<span style="float:right">
		<form action="editFilmForm.do" method="GET" align="right">
			<strong>Please enter film ID to edit fields:</strong><input
				type="number" name="id"> <input type="submit"
				value="Edit Film" />
		</form>
	</span>
</body>
</html>