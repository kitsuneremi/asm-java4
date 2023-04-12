<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="nav.jsp" />
	<c:url var="uri" value="/admin/user"></c:url>
	<form method="post">
		<div>
			<div style="display: flex">
				<div style="display: inline-block;">
					<label for="username">username</label> <input type="text"
						name="username" id="username" value="${id}" />
				</div>
				<div style="display: block">
					<label for="password">password</label> <input type="password"
						name="password" id="password" value="${pass}"/>
				</div>
			</div>
			<div style="display: flex">
				<div style="display: block">
					<label for="fullname">fullname</label> <input type="text"
						name="fullname" id="fullname" value="${fullname}"/>
				</div>
				<div style="display: block">
					<label for="email">email</label> <input type="text" name="email"
						id="email" value="${email}"/>
				</div>
			</div>
			<div>
				<button type="submit" formaction="${uri}/update">update</button>
				<button type="submit" formaction="${uri}/delete">delete</button>
			</div>
		</div>
	</form>
	<div>
		<table>
			<tr>
				<th>username</th>
				<th>pass</th>
				<th>fullname</th>
				<th>email</th>
				<th>role</th>
				<th></th>
			</tr>
			<c:forEach var="item" items="${listUser}">
				<tr>
					<td>${item.id}</td>
					<td>${item.password}</td>
					<td>${item.fullname}</td>
					<td>${item.email}</td>
					<td>${item.admin}</td>
					<td><a href="${uri}/edit/${item.id}">edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>