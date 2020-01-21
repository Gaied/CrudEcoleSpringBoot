<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/
loose.dtd">
<html>
<head>
<title><spring:message code="titre.creation.elementprofs" /></title>
</head>
<body>
	<form:form method="post" modelAttribute="modification"
		action="modifierModificationListeProf">
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
				<c:forEach items="${modification.listProfs}" var="prof"
					varStatus="status">
					<tr>
						<td><c:out value="${prof.id}" /> <input type="hidden"
							name="listProfs[${status.index}].id" value="${prof.id}" /></td>
						<td><c:out value="${prof.nom}" /> <input type="hidden"
							name="listProfs[${status.index}].nom" value="${prof.nom}" /></td>
						<td><c:out value="${prof.prenom}" /> <input type="hidden"
							name="listProfs[${status.index}].nom" value="${prof.prenom}" /></td>
						<td><c:out value="${prof.adresse}" /> <input type="hidden"
							name="listProfs[${status.index}].nom" value="${prof.adresse}" /></td>
						<td><c:out value="${prof.date_naissance}" /> <input type="hidden"
							name="listProfs[${status.index}].nom" value="${prof.date_naissance}" /></td>
							<td><c:out value="${prof.sexe}" /> <input type="hidden"
							name="listProfs[${status.index}].nom" value="${prof.sexe}" /></td>
						<td><input type="text" name="listProfs[${status.index}].nom"
							value="${prof.nom}" /><br /> <b><i><form:errors
										path="listProfs[${status.index}].nom[${status.index}].nom" /></i></b></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="submit" value="Send" />
	</form:form>
</body>
</html>