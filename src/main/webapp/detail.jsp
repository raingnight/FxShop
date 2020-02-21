<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="js/detail.js"></script>
<link type="text/css" rel="styleSheet"  href="css/detail.css" />
	<div id="goods_detail">
		<div>
			<img src="img/icon.jpg" alt="" id="main_pic">
		</div>
	
		<div>
			<span>${product.p_name}</span><br/>
			<span>${product.description}</span><br />
			<span>${product.price}</span><br />
			<span>${product.num}</span><br /><span id="fina">${addinfo}</span>
			<a href="cart.do">加入购物车</a>
			<a href="buy.do">立即购买</a>
		</div>	
	</div>
</body>
</html>