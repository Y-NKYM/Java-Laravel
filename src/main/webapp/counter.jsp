<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" scope="session" class="bean.CounterBean" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Count</title>
</head>
<body>
	<h2><jsp:getProperty name="cnt" property="count" />回目のアクセスです。</h2>
	<%@ include file="include.jsp" %>
</body>
</html>