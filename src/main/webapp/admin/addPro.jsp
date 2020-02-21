<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">添加商品</h1>
<p style="color:red; font-size:20px;" align="center">请按要求输入信息</p>
<center>
	<form action="addpro.do" method="post">
		<input name="pro_name" placeholder="产品名" type="text"><br><br>
		<input name="pro_desc" placeholder="产品描述"  type="text"><br><br>
		<input name="price" placeholder="价格"  type="number" step="0.01"><br><span style="color:red; font-size:12px;">(*请保留两位小数，如1.00)</span><br>
		<input name="number" placeholder="产品数量"  type="number"><br><span style="color:red; font-size:12px;">(*请输入整数)</span><br>
		<input name="status" placeholder="产品状态" type="text"><br><br>
		<input type="submit" value="确定添加">
	</form>	
	${fina}
</center>
</body>
<style>
body{
background: #fff;
}
</style>
</html>