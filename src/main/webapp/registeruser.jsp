<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*" %>
<jsp:useBean id="lb" scope="request" class="bean.LoginBean" />
<jsp:useBean id="email_msg" scope="request" class="java.lang.String" />
<jsp:useBean id="pass_msg" scope="request" class="java.lang.String" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<h1>Register Page</h1>
	<form action="/PracticeMVC/registeruser" method="post">
		
		<label for="email">Email</label><span> <%= email_msg %></span>
		<% if (request.getParameter("email") != null){ %>
			<input type="text" name="email" id="email" value="<%= request.getParameter("email") %>">
		<% } else {%>
			<input type="text" name="email" id="email">
		<% } %>
		<label for="password">Password</label><span> <%= pass_msg %></span>
		<input type="password" name="password" id="password">
		<button>Submit</button>
	</form>
</body>
</html>