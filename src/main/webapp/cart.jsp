<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${cart}" var="item" >
        <span>商品编号：${item.key.getP_id()}</span>
        <span>商品数量：${item.value}</span><br>
 </c:forEach>
</body>
</html>