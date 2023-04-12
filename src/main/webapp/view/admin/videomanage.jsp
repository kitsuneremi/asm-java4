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
	<c:url var="uri" value="/admin/video"></c:url>
	<form method="post">
		<div style="display: flex">
			<div>
				<label for="poster">poster</label> <input type="text" id="poster"
					name="poster" value="${poster}" />
			</div>
			<div style="display: block;">
				<div>
					<label for="youtubeId">youtube id</label> <input type="text"
						id="youtubeId" name="id" value="${id}" />
				</div>
				<div>
					<label for="title">video title</label> <input type="text"
						id="title" name="title" value="${title}" />
				</div>
				<div>
					<label for="view">view</label> <input type="text" id="view"
						name="view" value="${view}" />
				</div>
				<div>
					<input type="radio" name="status" value="1" id="inactive" /> <label
						for="inactive">inactive</label> <input type="radio" name="status"
						value="0" id="active" checked="${active}" /> <label for="active">active</label>
				</div>
			</div>
		</div>
		<div>
			<label for="des">des</label> <input type="text" name="des" id="des"
				value="${des}" />
		</div>
		<div>
			<button type="submit" formaction="${uri}/create">create</button>
			<button formaction="${uri}/update">update</button>
			<button formaction="${uri}/delete">delete</button>
			<button>reset</button>
		</div>
	</form>

	<table>
		<tr>
			<th>ytb id</th>
			<th>title</th>
			<th>view</th>
			<th>status</th>
			<th></th>
		</tr>
		<c:forEach var="item" items="${listVideo}">
			<tr>
				<td>${item.id}</td>
				<td>${item.title}</td>
				<td>${item.views}</td>
				<td>${item.active}</td>
				<td><a href="${uri}/edit/${item.id}">edit</a></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>