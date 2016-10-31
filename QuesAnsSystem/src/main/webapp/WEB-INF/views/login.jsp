<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="stylesheet" href="resources/style.css" />
<link href='http://fonts.googleapis.com/css?family=Oleo+Script'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="resources/jquery.min.js"></script>

</head>
<body>
	<div class="lg-container">
		<h1>Admin Area</h1>

		<form:form id="lg-form" method="post" action="admin"	modelAttribute="loginBean">


			<div>
				<form:label path="userName" for="username">user-name</form:label>
				<form:input name="userName" id="userName" placeholder="UserName" path="userName" />
			</div>

			<div>
				<form:label path="password" for="password">password</form:label>
				<form:password name="password" id="password" placeholder="Password" path="password" />
			</div>

			
			
			<div>
				<button type="submit" id="login">Login</button>
			</div>

			</form:form>
			<div id="message" style="Color:red;">${message}</div>
	</div>
</body>
</html>