<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kalkulator</title>
</head>
<body>
	<h2>Kalkulator</h2>
	<form:form method="POST" action="/kalkulator" modelAttribute="bestilling">
		<table>
			<tr>
				<td><form:label path="produktNavn">Produkt</form:label></td>
				<td><form:select path="produktNavn" items="${produktValg}"
						multiple="false" size="1" class="form-control" /></td>
			</tr>
			<tr>
				<td><form:label path="antEnh">Antall enheter</form:label></td>
				<td><form:input path="antEnh" /></td>
			</tr>
			<tr>
				<td><form:label path="antKart">Antall kartonger</form:label></td>
				<td><form:input path="antKart" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
			<tr>
				<td>Pris :</td>
				<td>${pris}</td>
			</tr>
		</table>
	</form:form>
</body>
</html>