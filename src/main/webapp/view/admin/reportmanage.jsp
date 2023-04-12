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
	<h2>bai 3.1</h2>

	<table>
		<tr>
			<th>title</th>
			<th>fav count</th>
			<th>latest date</th>
			<th>oldest date</th>
			<th></th>
		</tr>
		<c:forEach var="item" items="${one}">
			<tr>
				<td>${item.title}</td>
				<td>${item.count}</td>
				<td>${item.minDate}</td>
				<td>${item.maxDate}</td>
			</tr>
		</c:forEach>
	</table>


	<h2>bai 3.2</h2>
	<c:url value="/admin/report" var="url"></c:url>
	<form method="get">
		<select onchange="location = this.options[this.selectedIndex].value;">
			<option value="<c:url value='/admin/report'/>">--select a
				video--</option>
			<c:forEach var="item" items="${two}">
				<option value="<c:url value='/admin/report/${item.id}'/>">${item.title}</option>
			</c:forEach>
		</select>
	</form>
	<table>
		<tr>
			<th>username</th>
			<th>full name</th>
			<th>email</th>
			<th>fav date</th>
			<th></th>
		</tr>
		<c:forEach var="item" items="${listUser}">
			<tr>
				<td>${item.id}</td>
				<td>${item.fullname}</td>
				<td>${item.email}</td>
				<td>${item.favDate}</td>
			</tr>
		</c:forEach>
	</table>

	<h2>bai 3.3</h2>
	<c:url value="/admin/report" var="url"></c:url>
	<select onchange="location = this.options[this.selectedIndex].value;">
		<option value="<c:url value='/admin/report'/>">--select a
			video--</option>
		<c:forEach var="item" items="${two}">
			<option value="<c:url value='/admin/report/${item.id}'/>">${item.title}</option>
		</c:forEach>
	</select>
	<table>
		<tr>
			<th>sender name</th>
			<th>sender mail</th>
			<th>receive email</th>
			<th>send date</th>
			<th></th>
		</tr>
		<c:forEach var="item" items="${listSender}">
			<tr>
				<td>${item.senderName}</td>
				<td>${item.senderMail}</td>
				<td>${item.receivemail}</td>
				<td>${item.sendDate}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>