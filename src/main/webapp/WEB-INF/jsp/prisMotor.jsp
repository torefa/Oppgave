<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Prismotor</title>
</head>
<body>
	<h2>Prismotor</h2>
	<c:if test="${not empty pingvinListe}">
		<table>
			<thead>
				<tr>

					<th>Pingvinører</th>
					<th>Hestesko</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="listItem" items="${pingvinListe}"
					varStatus="theCount">
					<tr>
						<td>${listItem}</td>
						<td>${hesteListe[theCount.index]}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>