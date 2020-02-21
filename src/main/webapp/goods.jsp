<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<link type="text/css" rel="styleSheet" href="css/list.css">
<body>
	<div id="goods_list">
	<c:forEach items="${products}" var="p" varStatus="s">
		
		<div class="goods_box" >
		<a href="goods${p.p_id}.do">
			<img alt="" src="img/icon.jpg" class="goods_pic"><br>
			<!-- 
			<span>商品编号：${p.p_id}</span><br>
			<span>商品描述：${p.description}</span><br>
			<span>剩余数量：${p.num}</span><br>
			 -->
			<span>商品名：${p.p_name}</span><br>
			<span>单价：${p.price}</span><br>
		</a>
		</div>	
	</c:forEach>
	</div>
</body>
</html>