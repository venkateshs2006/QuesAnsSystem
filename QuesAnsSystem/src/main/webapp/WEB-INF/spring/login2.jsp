<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<form:form id="loginForm" method="post" action="admin" modelAttribute="loginBean">

			<form:label path="userName">Enter your user-name</form:label>
			<form:input id="userName" name="userName" path="userName" /><br>
			<form:label path="password">Please enter your password</form:label>
			<form:password id="password" name="password" path="password" /><br>
			<input type="submit" value="Submit" />			
		</form:form>
		<b style="color:red;">${message}</b>
	</body>
</html>