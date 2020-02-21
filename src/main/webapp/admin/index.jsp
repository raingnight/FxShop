<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>商店</title>
	<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>

    <div class="header">
        <div class="container clearf">
            <div class="col-2 logo">Logo</div><!-- Logo图片 -->
            <div class="col-5 search-bar">
                <p>后 台 管 理 系 统</p>
            </div>
            <div class="col-3 cart">
                <a href="#" class="item">退出登录</a>
            </div>
        </div>
    </div>
    <div class="main-promote"> <!-- 主体部分 -->
        <div class="container clearf">
            <div class="col-2 cat">
            	<ul>
            		<li class="item list">
                        <a>商品管理</a>
                        <ul id="add_items">
                            <li><a href="addPro.jsp" target="tuPian">添加商品</a></li>
                            <li><a href="#">修改商品信息</a></li>
                            <li><a href="#">删除商品</a></li>
                            <li><a href="#">商品信息修改</a></li>
                            <li><a href="#">客服邮箱</a></li>
                        </ul>
                    </li>
                    <li class="item list">
                        <a href="#">用户管理</a>
                        <ul id="add_items">
                            <li><a href="#">添加用户</a></li>
                            <li><a href="#">查询用户信息</a></li>
                            <li><a href="#">在线客服</a></li>
                            <li><a href="#">投诉中心</a></li>
                            <li><a href="#">客服邮箱</a></li>
                        </ul>
                    </li>
                    <li class="item list">
                        <a href="#">添加商品</a>
                        <ul id="add_items">
                            <li><a href="#">帮助中心</a></li>
                            <li><a href="#">售后服务</a></li>
                            <li><a href="#">在线客服</a></li>
                            <li><a href="#">投诉中心</a></li>
                            <li><a href="#">客服邮箱</a></li>
                        </ul>
                    </li>
                    <li class="item list">
                        <a href="#">添加商品</a>
                        <ul id="add_items">
                            <li><a href="#">帮助中心</a></li>
                            <li><a href="#">售后服务</a></li>
                            <li><a href="#">在线客服</a></li>
                            <li><a href="#">投诉中心</a></li>
                            <li><a href="#">客服邮箱</a></li>
                        </ul>
                    </li>
                    <li class="item list">
                        <a href="#">添加商品</a>
                        <ul id="add_items">
                            <li><a href="#">帮助中心</a></li>
                            <li><a href="#">售后服务</a></li>
                            <li><a href="#">在线客服</a></li>
                            <li><a href="#">投诉中心</a></li>
                            <li><a href="#">客服邮箱</a></li>
                        </ul>
                    </li>
                    <li class="item list">
                        <a href="#">友链管理</a>
                        <ul id="add_items">
                            <li><a href="#">帮助中心</a></li>
                            <li><a href="#">售后服务</a></li>
                            <li><a href="#">在线客服</a></li>
                            <li><a href="#">投诉中心</a></li>
                            <li><a href="#">客服邮箱</a></li>
                        </ul>
                    </li>
            	</ul>
            </div>
            <div class="col-6">
                <iframe src="img/003.jpg" name="tuPian" frameborder="0" marginwidth="0" marginheight=" 0" width="100%" height="360px" scrolling="yes"></iframe><!--name改成具体的网页内容-->
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
    </div>

    <div class="footer">
        <div class="container clearf">
        <a href="" class="item">关于我们</a>
        <a href="" class="item">联系我们</a>
        <a href="" class="item">友情链接</a>
        <a href="" class="item">item</a>
        <div class="">备案号之类的</div>
        </div>
    </div>
</body>
</html>