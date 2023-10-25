<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Web開発練習</title>
</head>
<body>
	<h2>idが<%= request.getParameter("no") %>の生徒は<%= request.getAttribute("name") %>です。</h2>
</body>
</html>