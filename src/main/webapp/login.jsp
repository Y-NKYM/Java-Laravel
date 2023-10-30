<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*" %>
<jsp:useBean id="lb" scope="request" class="bean.LoginBean" />
<jsp:useBean id="message" scope="request" class="java.lang.String" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<p style="color: red;"><%= message %></p>
	<h1>Login Page</h1>
	<form action="/PracticeMVC/login" method="post">
		<label for="email">Email</label>
		<input type="text" name="email" id="email" value="<%= request.getParameter("email") %>">
		<label for="password">Password</label>
		<input type="password" name="password" id="password">
		<button>Submit</button>
	</form>
</body>
</html>