<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div align="center">
        <h1>New Person</h1>
        <form:form action="savePerson" method="post" modelAttribute="person">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Surname:</td>
                <td><form:input path="surname" /></td>
            </tr>
            <tr>
                <td>Birthday:</td>
                <td><form:input path="birthday" /></td>
            </tr>
            <tr>
                <td>Communication:</td>
                <td><form:radiobutton path="communication" value="eposta" label="eposta" />
				<form:radiobutton path="communication" value="SMS" label="SMS" /></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><form:textarea path="description" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>