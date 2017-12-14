<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>管理界面</title>
		<link rel="stylesheet" type="text/css" href="${ctx}/css/login.css">
	</head>
	<body>
		<!-- login -->
		<div class="top center">
			<div class="logo center">
				<a href="${ctx}/index.jsp" target="_self"><img src="${ctx}/image/mistore_logo.png" alt=""></a>
			</div>
		</div>
		<div><a href="${ctx}/admin/all" style="font-size:25px;color:white;padding-left:210px;">商品管理</a></div>
		<div><a href="${ctx}/admin/allorder" style="font-size:25px;color:white;padding-left:210px;">订单管理</a></div>
		<footer>
			<div class="copyright" >简体 | 繁体 | English | 常见问题</div>
			<div class="copyright">小米公司版权所有-京ICP备10046444-<img src="${ctx}/image/ghs.png" alt="">京公网安备11010802020134号-京ICP证110507号</div>
		</footer>
	</body>
</html>