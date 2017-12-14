<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="jdk.management.resource.internal.TotalResourceContext"%>
<%@page import="com.xiaomishop.entity.CartItem"%>
<%@page import="com.xiaomishop.entity.Cart"%>
<%@page import="java.util.Iterator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的购物车-小米商城</title>
		<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css">
		<script type="text/javascript" src="${ctx}/css/jquery-2.2.0.min.js"></script>
	</head>
	<body>
	<!-- start header -->
	<!--end header -->

<!-- start banner_x -->
		<div class="banner_x center">
		
			<a href="${ctx}/index.jsp" target="_self"><div class="logo fl"></div></a>
			
			<div class="wdgwc fl ml40">我的购物车</div>
			<div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
			<div class="dlzc fr">
				<ul>
					<li><a href="./login.html" target="_blank">登录</a></li>
					<li>|</li>
					<li><a href="./register.html" target="_blank">注册</a></li>	
				</ul>
				
			</div>
			<div class="clear"></div>
		</div>
		<div class="xiantiao"></div>
		
		<% 
			Cart c = (Cart)session.getAttribute("cart");
			if(c == null){%>
				<h4 class = "title">购物车是空的</h4>
				<p class="cart">您的购物车是空的，请点击<a href="${ctx}/index.jsp" style = "color:red">这里</a>继续购物</p>
			<%}else{
				int totalprice = 0;
				int num = 0;
				Iterator i =c.container.values().iterator();%>
		
		<div class="gwcxqbj" style="margin-bottom=50px">
			<div class="gwcxd center">
				<div class="top2 center">
					<div class="sub_top fl">
						<input type="checkbox" value="quanxuan" class="quanxuan" />全选
					</div>
					<div class="sub_top fl">商品名称</div>
					<div class="sub_top fl">单价</div>
					<div class="sub_top fl">数量</div>
					<div class="sub_top fl">小计</div>
					<div class="sub_top fr">操作</div>
					<div class="clear"></div>
				</div>
			<%while(i.hasNext()){
				CartItem ci =(CartItem)i.next();
				num++;%>
				<div class="content2 center">
					<div class="sub_content fl ">
						<input type="checkbox" value="quanxuan" class="quanxuan" />
					</div>
					<div class="sub_content fl"><img src="${ctx}/image/gwc_xiaomi6.jpg"></div>
					<div class="sub_content fl ft20"><%=ci.getProduct().getName() %>全网通6GB内存+64GB 亮黑色</div>
					<div class="sub_content fl "><%=ci.getProduct().getPrice()%>元</div>
					<div class="sub_content fl">
						<input class="shuliang" type="number" value="<%=ci.getCount()%>" step="1" min="1" >
					</div>
					<div class="sub_content fl"><%=ci.getProduct().getPrice()*ci.getCount()%>元</div>
					<div class="sub_content fl">
						<a href="${ctx}/cart/subtract?pid=<%=ci.getProduct().getId()%>" style="display:inline;font-size:35px;padding-right:10px;">-</a>
						<a href="${ctx}/cart/addpro?pid=<%=ci.getProduct().getId()%>" style="display:inline">+</a>
					</div>
					<div class="clear"></div>
				</div>
				<%totalprice += ci.getProduct().getPrice()*ci.getCount();
				}%>
			</div>
			<div class="jiesuandan mt20 center">
				<div class="tishi fl ml20">
					<ul>
						<li><a href="${ctx}/index.jsp">继续购物</a></li>
						<li>|</li>
						<li>共<span><%=num %></span>件商品</li>
						<div class="clear"></div>
					</ul>
				</div>
				<form action="${ctx}/order/add" method="set">
					<div class="jiesuan fr">
						<div class="jiesuanjiage fl">合计（不含运费）：<span><%=totalprice %>元</span></div>
						<div class="jsanniu fr"><input class="jsan" type="submit" name="jiesuan"  value="去结算"/></div>
						<div class="clear"></div>
					</div>
					<div class="clear"></div>
				</form>
			</div>
		</div>
		<% }%>
	<!-- footer -->
	<footer class="center" display="inline">
			<div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
			<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
	</footer>

	</body>
</html>