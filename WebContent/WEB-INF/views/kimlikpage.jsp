<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kimlik Form</title>
</head>

<body>
	<form:form commandName="kimlikbilgileri" method="post" action="kimlikpage">
		<table>
			<tr>
				<td><form:label path="name">
						<b>Ad :</b>
					</form:label></td>
				<td><form:input path="name" type="text" /></td>
			</tr>
			
			<tr>
				<td><form:label path="surname">
						<b>Soyad :</b>
					</form:label></td>
				<td><form:input path="surname" type="text" /></td>
			</tr>
			<tr>
				<td><form:label path="birthday">
						<b>Doğum Tarihi :</b>
					</form:label></td>
				<td><form:input path="birthday" type="text" /></td>
			</tr>
				<td><b>İletişim :</b></td>
			<tr>
				<td><form:radiobutton path="communication" value="eposta" label="eposta" />
				<form:radiobutton path="communication" value="SMS" label="SMS" /></td>
			</tr>

			<tr>
				<td><form:label path="description">
						<b>Açıklama :</b>
					</form:label></td>
				<td><form:textarea path="description" /></td>
			</tr>
			<tr>
				<td colspan=2><input type="submit" value="Submit"></td>
		</table>

	</form:form>
	
</body>
</html>