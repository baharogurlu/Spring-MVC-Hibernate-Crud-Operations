<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>


	<div align="center">
		<h1>Person List</h1>
		<h3>
			<a href="newPerson"><button>New Person</button></a>
		</h3>
		<table border="1">

			<th>Name</th>
			<th>Surname</th>
			<th>Birthday</th>
			<th>Communication</th>
			<th>Description</th>
			<th>Action</th>


			<c:forEach var="person" items="${listPerson}">
				<tr>

					<td>${person.name}</td>
					<td>${person.surname}</td>
					<td>${person.birthday}</td>
					<td>${person.communication}</td>
					<td>${person.description}</td>
					<td>
						<button onclick="deletee(${person.id})">Delete</button>
						<a href="editPerson?id=${person.id}"><button>Edit</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script>
function deletee(id) {
    if (confirm("Emin misiniz?") == true) {
        location.href="deletePerson?id="+id;
    }
}
</script>
</body>
</html>
