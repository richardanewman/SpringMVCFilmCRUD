<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/jsp-styles.css" rel="stylesheet" type="text/css">
<title>New Actor Added</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty newActor}">
      ${newActor}
    </c:when>
		<c:otherwise>
			<p>Error. No actor created.</p>
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<form action="deleteActor.do" method="POST">
	Please enter actor ID to confirm deletion:
	<input type="text" name="id">
	<input type="submit" value="Delete Actor" />
	</form>
	<br>
	<form action="editActorForm.do" method="GET">
	Please enter actor ID to edit fields:
	<input type="text" name="id">
	<input type="submit" value="Edit Actor" />
	</form>
	
</body>
</html>