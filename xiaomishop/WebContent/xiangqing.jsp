<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
		<meta charset="UTF-8">
		<title>${p.name}立即购买-小米商城</title>
		<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css">
	</head>
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="http://www.mi.com/" target="_blank">小米商城</a></li>
						<li>|</li>
						<li><a href="">MIUI</a></li>
						<li>|</li>
						<li><a href="">米聊</a></li>
						<li>|</li>
						<li><a href="">游戏</a></li>
						<li>|</li>
						<li><a href="">多看阅读</a></li>
						<li>|</li>
						<li><a href="">云服务</a></li>
						<li>|</li>
						<li><a href="">金融</a></li>
						<li>|</li>
						<li><a href="">小米商城移动版</a></li>
						<li>|</li>
						<li><a href="">问题反馈</a></li>
						<li>|</li>
						<li><a href="">Select Region</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="${ctx}/gouwuche.jsp">购物车</a></div>
					<div class="fr">
						<ul>
							<li>您好，${name}!</li>
							<li><a href="${ctx}/user/login" target="_blank">登录</a></li>
							<li>|</li>
							<li><a href="${ctx}/user/register" target="_blank" >注册</a></li>
							<li>|</li>
							<li><a href="${ctx}/order/find">消息通知</a></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->

<!-- start banner_x -->
		<div class="banner_x center">
			<a href="${ctx}/index.jsp" target="_self"><div class="logo fl"></div></a>
			<a href=""><div class="ad_top fl"></div></a>
			<div class="nav fl">
				<ul>
					<li><a href="${ctx}/product/page">手机商城</a></li>
					<li><a href="">红米</a></li>
					<li><a href="">平板·笔记本</a></li>
					<li><a href="">电视</a></li>
					<li><a href="">盒子·影音</a></li>
					<li><a href="">路由器</a></li>
					<li><a href="">智能硬件</a></li>
					<li><a href="">服务</a></li>
					<li><a href="">社区</a></li>
				</ul>
			</div>
			<div class="search fr">
				<form action="" method="post">
					<div class="text fl">
						<input type="text" class="shuru"  placeholder="小米6&nbsp;小米MIX现货">
					</div>
					<div class="submit fl">
						<input type="submit" class="sousuo" value="搜索"/>
					</div>
					<div class="clear"></div>
				</form>
				<div class="clear"></div>
			</div>
		</div>
<!-- end banner_x -->

	
	<!-- xiangqing -->
	<form action="${ctx}/cart/add?pid=${p.id}" method="get">
	<div class="xiangqing">
		<div class="neirong w">
			<div class="xiaomi6 fl">${p.name}</div>
			<nav class="fr">
				<li><a href="">概述</a></li>
				<li>|</li>
				<li><a href="">变焦双摄</a></li>
				<li>|</li>
				<li><a href="">设计</a></li>
				<li>|</li>
				<li><a href="">参数</a></li>
				<li>|</li>
				<li><a href="">F码通道</a></li>
				<li>|</li>
				<li><a href="">用户评价</a></li>
				<div class="clear"></div>
			</nav>
			<div class="clear"></div>
		</div>	
	</div>
	
	<div class="jieshao mt20 w">
		<div class="left fl"><img src="${ctx}/image/liebiao_xiaomi6.jpg"></div>
		<div class="right fr">
			<div class="h3 ml20 mt20">${p.name}</div>
			<div class="jianjie mr40 ml20 mt10">${p.description}   变焦双摄，4 轴防抖 / 骁龙835 旗舰处理器，6GB 大内存，最大可选128GB 闪存 / 5.15" 护眼屏 / 四曲面玻璃/陶瓷机身</div>
			<div class="jiage ml20 mt10">${p.price}元</div>
			<div class="ft20 ml20 mt20">选择版本</div>
			<div class="xzbb ml20 mt10">
				<div class="banben fl">
					<a>
						<span>全网通版 6GB+64GB </span>
						<span>2499元</span>
					</a>
				</div>
				<div class="banben fr">
					<a>
						<span>全网通版 6GB+128GB</span>
						<span>2899元</span>
					</a>
				</div>
				<div class="clear"></div>
			</div>
			<div class="ft20 ml20 mt20">选择颜色</div>
			<div class="xzbb ml20 mt10">
				<div class="banben">
					<a>
						<span class="yuandian"></span>
						<span class="yanse">亮黑色</span>
					</a>
				</div>	
			</div>
			<div class="xqxq mt20 ml20">
				<div class="top1 mt10">
					<div class="left1 fl">${p.name}全网通版 6GB内存 64GB 亮黑色</div>
					<div class="right1 fr">${p.price}元</div>
					<div class="clear"></div>
				</div>
				<div class="bot mt20 ft20 ftbc">总计：${p.price}元</div>
			</div>
				<div class="xiadan ml20 mt20">
					<a href = "${ctx}/cart/add?pid=${p.id}" class="jrgwc" type="button" name="jrgwc" style="padding-right: 10px;padding-top:5px;padding-left:10px;padding-bottom:5px;">加入购物车</a>
				</div>
		</div>
		<div class="clear"></div>
	</div>
	</form>
	<!-- footer -->
	<footer class="mt20 center">
			
			<div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
			<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>

		</footer>

	</body>
</html>