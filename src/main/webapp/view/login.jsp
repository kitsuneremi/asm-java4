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
	<c:url var="accurl" value="/account"></c:url>
	<div style="padding: 10% 40%">
		<form action="${accurl}/login" method="post">
		<div><h1>đăng nhập</h1></div>
		<input placeholder="user" name="username"/>
		<br /><br />
		<input type="password" name="password" placeholder="pass"/>
		<br /><br />
		<input type="checkbox" name="rem" id="rem"/>
		<label for="rem">remember me?</label>
		<br /><br />
		<input type="submit" value="đăng nhập"/>
	</form>
	</div>

</body>
</html>