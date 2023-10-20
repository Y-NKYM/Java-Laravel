<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSP記述もコメントアウト可能 <%@ page contentType="text/html; charset=UTF-8" %> --%>
<!DOCTYPE html>
<%-- 宣言タグ：関数の宣言 --%>
<%! 
	String fortune(){
		String f;
		double fn = Math.random();  //0.0～1.0の乱数
		if(fn >= 0.7){
			f = "大吉";
		} else if(fn >= 0.4) {
			f = "中吉";
		} else if(fn >= 0.1) {
			f = "小吉";
		} else {
			f = "凶";
		}
		return f;
	}
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>占いJSP</title>
	</head>
	<body>
		<h1>今日の運勢は…</h1>
		
		<%-- Javaコード記述用タグ --%>
		<% for(int i = 0; i<2; i++){ %>
		
			<%-- 出力タグ --%>
			<p><%= fortune() %></p>
			
		<% } %>
		
	</body>
</html>