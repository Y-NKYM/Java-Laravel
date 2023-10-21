<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>入力結果</h1>
	<p>名前：<%= request.getParameter("name") %></p><br>
	<p>年齢：<%= request.getAttribute("age") %></p><br>
	<p>開発言語：<%= request.getAttribute("langs") %></p><br>
	<p>色：<%= request.getParameter("color") %></p><br>
</body>
</html>