<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/jsp-styles.css" rel="stylesheet" type="text/css">
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