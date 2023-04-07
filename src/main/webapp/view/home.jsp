
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
	<c:url var="detail" value="/detail"></c:url>
	<div
		style="display: flex; justify-content: space-between; padding: 0 5%">
		<c:forEach var="item" items="${listVideo}">
			<div style="width: 30%">
				<div style="padding: 5%; border: 1px solid black">
					<form action="">
						<div style="border: 1px solid black">
							<a href="${detail}/${item.id}"> <img src="${item.poster}" />
							</a>
						</div>
					</form>
				</div>
				<div>
					<h3>${item.title}</h3>
				</div>
				<div>
					<button>like</button>
					<button>share</button>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>