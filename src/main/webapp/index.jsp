<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>商店</title>
	<link type="text/css" rel="styleSheet" href="css/list.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
    <div class="top-nav">
        <div class="container clearf">
            <div class="left">
                <a href="list.do" class="item">首页</a>
            </div>
            <div class="right">
                <a href="#" class="item">我的订单</a>
                <a href="#" class="item">收藏夹</a>
                <a href="logon.jsp" class="item">注册</a>
                <a href="login.jsp" class="item">登录</a>
            </div>
        </div>
    </div>
    <div class="header">
        <div class="container clearf">
            <div class="col-2 logo">Logo</div><!-- Logo图片 -->
            <div class="col-5 search-bar">
                <input type="text">
                <button>搜索</button>
            </div>
            <div class="col-3 cart">
                <a href="cart.do" class="item">我的购物车</a>
            </div>
        </div>
    </div>
    <div class="main-promote"> <!-- 主体部分 -->
        <div class="container clearf">
            <div class="col-2 cat">
            	<ul>
            		<a href="addPro.jsp" target="tuPian"><li class="item">代刷网课</li></a><!--图片改成具体的网页内容-->
            		<a href="img/002.jpg" target="tuPian"><li class="item">洗衣液</li></a>
            		<a href="img/001.jpg" target="tuPian"><li class="item">短信轰炸</li></a>
            		<a href="img/003.jpg" target="tuPian"><li class="item">会员代刷</li></a>
            		<a href="img/003.jpg" target="tuPian"><li class="item">低价影视会员</li></a>
            		<a href="img/003.jpg" target="tuPian"><li class="item">点券代充</li></a>
            		<a href="img/003.jpg" target="tuPian"><li class="item">item / item</li></a>
            		<a href="img/003.jpg" target="tuPian"><li class="item">item / item</li></a>
            	</ul>
            </div>
            <div class="col-6">
                <iframe src="img/icon.jpg" name="tuPian" frameborder="0" marginwidth="0" marginheight=" 0" width="100%" height="435px" scrolling="no"></iframe><!--图片改成具体的网页内容-->
            </div>
            <div class="col-2 info">
                <div class="auth clearf">
                    <div class="avatar"></div>
                    你好，欢迎下单.
                </div>
                <div class="anno">
                    <div class="title">公告</div>
                    <div class="content">
                    　　为确保国际民航班机的运输安全，决定从1981年11月1日起，在中华人民共和国境内各民用机场，对乘坐国际班机中的中、外籍旅客及其携带的行车物品，实行安全技术检查。
                    　　一、严禁将武器、凶器、弹药和易爆、易燃、剧毒、放射性物品以及其他危害飞行安全的危险品带上飞机或夹在行李、货物中托运。
                    　　
                    </div><!-- 这个乱粘贴的，自己改 -->
                </div>
           </div>
        </div>
    <h1 align="center">所有商品</h1>    
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
		<c:if test="${s.index%3==0}">
			<c:out value="" escapeXml="false"></c:out>
		</c:if>
	</c:forEach>
	</div>
        
    </div>

    <div class="footer">
        <div class="container clearf">
        <a href="" class="item">关于我们</a>
        <a href="" class="item">联系我们</a>
        <a href="" class="item">item</a>
        <a href="" class="item">item</a>
        <div class="">备案号之类的</div>
        </div>
    </div>
</body>
</html>