<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>会员登录</title>
		<link rel="stylesheet" type="text/css" href="${ctx}/css/login.css">
	</head>
	<body style="background-color:white;">
		<!-- login -->
		<div class="top center">
			<div class="logo center">
				<a href="${ctx }/index.jsp" target="_self"><img src="${ctx}/image/mistore_logo.png" alt=""></a>
			</div>
		</div>
		<div style="font-size:20px;padding-bottom:60px;">
			<div style="width:1130px;margin:0 auto;">
				<h4 style="font-size:30px;">订单列表：</h4>
				<form action="${ctx }/admin/findorder" method="set">
					<input type="text" placeholder="请输入订单号" name="id" style="margin-left:165px;margin-bottom:5px;">
					<input type="submit" value="查询" style="">
				</form>
				<form action="${ctx }/admin/allorder" method="set">
					<input type="submit" value="订单列表" style="margin-left:165px;margin-bottom:5px;">
				</form>
				<a href="${ctx }/admin.jsp"style="margin-left:165px;margin-bottom:5px;">管理界面</a>
				
			</div>
			<table style="border:black 1px dashed;width:800px;" cellspacing="0">
				<tr>
					<th style="border:black 1px dashed;">订单号</th>
					<th style="border:black 1px dashed;">名称</th>
					<th style="border:black 1px dashed;">单价</th>
					<th style="border:black 1px dashed;">数量</th>
					<th style="border:black 1px dashed;">订货人</th>
					<th style="border:black 1px dashed;">是否发货</th>
					<th style="border:black 1px dashed;">收货地址</th>
					<th style="border:black 1px dashed;">操作</th>
				</tr>
				
				<c:forEach items="${list}" var="p">
					<tr>
						<td style="border:black 1px dashed;" align="center">${p.id }</td>
						<td style="border:black 1px dashed;" align="center">${p.name }</td>
						<td style="border:black 1px dashed;" align="center">${p.price }</td>
						<td style="border:black 1px dashed;" align="center">${p.count }</td>
						<td style="border:black 1px dashed;" align="center">${p.userid }</td>
						<td style="border:black 1px dashed;" align="center">${p.chec }</td>
						<td style="border:black 1px dashed;" align="center">${p.address }</td>
						<td style="border:black 1px dashed;" align="center"><a href="${ctx }/admin/deleteorder?id=${p.id}" text-decoration="none">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>