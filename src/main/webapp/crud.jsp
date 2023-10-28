<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*" %>
<jsp:useBean id="sdto" scope="request" class="bean.StudentDTO" />
<jsp:useBean id="message" scope="request" class="java.lang.String" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD</title>
</head>
<body>
	<h2><%= message %></h2>
	<table>
		<tr>
			<th width="50">番号</th>
			<th width="50">名前</th>
			<th width="50">点数</th>
		</tr>
		<% 
			for(int i=0; i < sdto.size(); i++){
			StudentBean sb = sdto.get(i);
		%>
		<tr>
			<td align="center"><%= sb.getNo() %></td>
			<td align="center"><%= sb.getName() %></td>
			<td align="center"><%= sb.getScore() %></td>
		</tr>
		<% } %>
	</table><br>
	<a href="/PracticeMVC/crud.html">戻る</a>
</body>
</html>