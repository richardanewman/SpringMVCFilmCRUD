<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/css/jsp-styles.css" rel="stylesheet" type="text/css">
<title>Film Status</title>
</head>
<body>
${result}

	<c:choose>
		<c:when test="${! empty films}">
		<c:forEach values="films" var="film">
      ${films}
		</c:forEach>
    </c:when>
    </c:choose>

</body>
</html>