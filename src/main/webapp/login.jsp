
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
</head>
<link type="text/css" rel="styleSheet"  href="css/log.css" />
<body>
<%@ include file="head.jsp" %>
<div id="wrapper">
	<div id="logon">
	<h1>WELCOME</h1>
	<form method="post" action="login.do">
		<input placeholder="请输入账号" type="text" name="uname"><span>${login_failed}</span><br>
		<input placeholder="请输入密码" type="password" name="pwd"><br>
		<a href="logon.jsp">没有账号？点我注册</a><br>
		<input type="submit" value="登录" id="btn">
	</form>
	</div>
</div>
<%@ include file="footer.jsp" %>
	<script src="js/log.js"></script>
</body>
</html>