<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/
loose.dtd">
<html>
<head>
<title><spring:message code="titre.creation.elementprof" /></title>
</head>
<body>
	<form:form method="post" modelAttribute="creation"
		action="modifierModificationListeProf">
		<spring:message code="creation.elementprof.nom.nom" />
		<form:input path="nom" />
		<b><i><form:errors path="nom" cssclass="error" /></i></b>
		<br>
		<spring:message code="creation.elementprof.nom.prenom" />
		<form:input path="prenom" />
		<b><i><form:errors path="prenom" cssclass="error" /></i></b>
		<br>
		<spring:message code="creation.elementprof.nom.adresse" />
		<form:input path="adresse" />
		<b><i><form:errors path="adresse" cssclass="error" /></i></b>
		<br>
		<spring:message code="creation.elementprof.nom.date_naissance" />
		<form:input path="date_naissance" />
		<b><i><form:errors path="date_naissance" cssclass="error" /></i></b>
		<br>
		<spring:message code="creation.elementprof.nom.sexe" />
		<form:input path="sexe" />
		<b><i><form:errors path="sexe" cssclass="error" /></i></b>
		<br>
		<input type="submit" value="Envoyer" />
	</form:form>
	<table border="1">
		<thead>
			<tr>
				<th><spring:message code="colonne.identifiant" /></th>
				<th><spring:message code="colonne.nom" /></th>
				<th><spring:message code="colonne.prenom" /></th>
				<th><spring:message code="colonne.date_naissance" /></th>
				<th><spring:message code="colonne.adresse" /></th>
				<th><spring:message code="colonne.sexe" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listProfs}" var="prof">
				<tr>
					<td><c:out value="${prof.id}" /></td>
					<td><c:out value="${prof.nom}" /></td>
					<td><c:out value="${prof.date_naissance}" /></td>
					<td><c:out value="${prof.adresse}" /></td>
					<td><c:out value="${prof.sexe}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>