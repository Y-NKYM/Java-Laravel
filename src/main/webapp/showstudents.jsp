<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- StudentDTOとStudentBeanクラスのインポート -->
<%@ page import="bean.*" %>
<jsp:useBean id="sdto" scope="request" class="bean.StudentDTO" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒名簿</title>
</head>
<body>
	<h2>生徒の情報は以下の通りです</h2>
	<table>
		<tbody>
			<tr>
				<th width="50">番号</th>
				<th width="50">名前</th>
				<th width="50">点数</th>
			</tr>
			<% for(int i = 0; i<sdto.size(); i++){
				StudentBean sb = sdto.get(i);
			%>
			<tr>
				<td align="center"><%= sb.getNo() %></td>
				<td align="center"><%= sb.getName() %></td>
				<td align="center"><%= sb.getScore() %></td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>