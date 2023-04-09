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
	<h2>bai 3.1</h2>
	<c:forEach var="item" items="${one}">
		<table>
			<tr>
				<th>title</th>
				<th>fav count</th>
				<th>latest date</th>
				<th>oldest date</th>
				<th></th>
			</tr>
			<tr>
				<td>${item.title}</td>
				<td>${item.count}</td>
				<td>${item.minDate}</td>
				<td>${item.maxDate}</td>
			</tr>
		</table>
	</c:forEach>
	<h2>bai 3.2</h2>
	<select>
		<c:forEach var="item" items="${two}">
			<option value=${item.id}>${item.title}</option>
		</c:forEach>
	</select>
		<c:forEach var="item" items="${listUser}">
		<table>
			<tr>
				<th>username</th>
				<th>full name</th>
				<th>email</th>
				<th>fav date</th>
				<th></th>
			</tr>
			<tr>
				<td>${item.id}</td>
				<td>${item.fullname}</td>
				<td>${item.email}</td>
				<td>${item.favDate}</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>