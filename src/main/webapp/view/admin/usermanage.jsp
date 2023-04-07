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
	<c:url var="uri" value="/admin/user"></c:url>
	<form method="post">
		<div>
			<div style="display: flex">
				<div style="display: inline-block;">
					<label for="username">username</label> <input type="text"
						name="username" id="username" />
				</div>
				<div style="display: block">
					<label for="password">password</label> <input type="password"
						name="password" id="password" />
				</div>
			</div>
			<div style="display: flex">
				<div style="display: block">
					<label for="fullname">fullname</label> <input type="text"
						name="fullname" id="fullname" />
				</div>
				<div style="display: block">
					<label for="email">email</label> <input type="text" name="email"
						id="email" />
				</div>
			</div>
			<div>
				<button type="submit" formaction="${uri}/update">update</button>
				<button type="submit" formaction="${uri}/delete">delete</button>
			</div>
		</div>
	</form>
	<div>
		<c:forEach var="item" items="${listUser}">
			<table>
				<tr>
					<th>username</th>
					<th>pass</th>
					<th>fullname</th>
					<th>email</th>
					<th>role</th>
					<th></th>
				</tr>
				<tr>
					<td>${item.id}</td>
					<td>${item.password}</td>
					<td>${item.fullname}</td>
					<td>${item.email}</td>
					<td>${item.role}</td>
					<td><a href="/${item.id}">edit</a></td>
				</tr>
			</table>
		</c:forEach>
	</div>
</body>
</html>