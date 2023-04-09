<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
				<td>${item.favcount}</td>
				<td>${item.sdate}</td>
				<td>${item.edate}</td>
			</tr>
		</table>
	</c:forEach>
	
	
</body>
</html>