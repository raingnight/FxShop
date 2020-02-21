<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户注册</title>
</head>
<link type="text/css" rel="styleSheet"  href="css/log.css" />
<body>
<%@ include file="head.jsp" %>
<div id="wrapper">
	<div id="logon">
	<h1>WELCOME</h1>
	<form method="post" action="logon.do" id="logon">
		<input placeholder="请输入用户名 " type="text" name="uname" onclick="InputClick(this) "><span id="tips">${logon_failed}<span><br>
		<input placeholder="请输入密码" type="password" name="pwd"><br>
		<input placeholder="请输入邮箱" type="text" name="email"><br>
		<a href="login.jsp">已有账号？点我登录</a><br>
		<input type="submit" value="注册" id="btn">
	</form>
	</div>
</div>
<%@ include file="footer.jsp" %>
	<script src="js/log.js"></script>
</body>
</html>