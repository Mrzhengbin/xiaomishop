<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户登陆</title>
		<link rel="stylesheet" type="text/css" href="./css/login.css">
	</head>
	<body>
		<div class="top center">
			<div class="logo center">
				<a href="./index.jsp" target="_self"><img src="../image/mistore_logo.png" alt=""></a>
			</div>
		</div>
		<div class="register">
		<p class="res_title">用户登录：提示信息</p>
		<div class="res_box">
			<div class="res_form">
				<p style="color: #1C1C1C;">登录失败，用户名或者密码错误！请重新<a style="color: #AE191B;" href="${ctx}/user/login">登录</a></p>
			</div>
		</div>
	</div>
	<footer>
			<div class="copyright">简体 | 繁体 | English | 常见问题</div>
			<div class="copyright">小米公司版权所有-京ICP备10046444-<img src="../image/ghs.png" alt="">京公网安备11010802020134号-京ICP证110507号</div>
		</footer>
	</body>
</html>