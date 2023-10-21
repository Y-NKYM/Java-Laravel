<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>情報を入力：</h1>
	<form action="/PracticeMVC/practice" method="post">
		<label for="name">名前：</label>
			<input type="text" name="name" id="name" size="10">
		<p>年齢：</p>
			<input type="radio" name="age" id="child" value="child">
			<label for="child">18歳以下：</label>
			<input type="radio" name="age" id="adult" value="adult">
			<label for="adult">18歳以上：</label>
		<p>開発経験：</p>
			<input type="checkbox" name="lang" id="Java" value="Java">
			<label for="Java">Java</label>
			<input type="checkbox" name="lang" id="Python" value="Python">
			<label for="Python">Python</label>
			<input type="checkbox" name="lang" id="Ruby" value="Ruby">
			<label for="Ruby">Ruby</label>
		<p>好きな色</p>
		<select name="color" size="1">
			<option value="青">青</option>
			<option value="赤">赤</option>
			<option value="黄">黄</option>
			<option value="黒">黒</option>
			<option value="白">白</option>
		</select>
		<button type="submit">送信</button>
	</form>
</body>
</html>