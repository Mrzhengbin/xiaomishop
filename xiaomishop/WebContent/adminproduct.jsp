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
		<div style="padding-left:200px;font-size:25px;padding-bottom:60px;">
			<a href="${ctx}/admin.jsp">管理界面</a>
			<a href="${ctx}/addproduct.jsp" >增加商品</a>
		</div>
		<div class="gwcxqbj" style="margin-bottom=50px;padding-left:200px;">
			<div class="gwcxd center">
				<div class="top2 center" style="font-size:20px;padding-left:100px;">
					<div class="sub_top fl">
					</div>
					<div class="sub_top fl" style="padding-left:40px;">名称</div>
					<div class="sub_top fl" style="padding-left:40px;">商品类别id</div>
					<div class="sub_top fl" style="padding-left:120px;">描述</div>
					<div class="sub_top fl" style="padding-left:170px;">单价</div>
					<div class="clear"></div>
				</div>
				
			<c:forEach items="${list}" var="p">
				<div class="content2 center" style="font-size:15px;">
					<div class="sub_content fl "><img src="${ctx}/image/gwc_xiaomi6.jpg"></div>
					<div class="sub_content fl " style="padding-left:60px;padding-top:30px">${p.name}</div>
					<div class="sub_content fl " style="padding-left:80px;padding-top:30px">${p.producttypeid}</div>
					<div class="sub_content fl ft20" style="padding-left:80px;padding-top:30px">${p.description}全网通6GB内存+64GB 亮黑色</div>
					<div class="sub_content fl " style="padding-left:60px;padding-top:30px">${p.price}</div>
					<div class="sub_content fl" style="padding-left:60px;padding-top:15px">
						<a href="${ctx}/admin/change?pid=${p.id}" style="display:inline;font-size:35px;padding-right:10px;">修改</a>
						<a href="${ctx}/admin/delete?pid=${p.id}"  style="display:inline;font-size:35px;padding-right:10px;">删除</a>
					</div>
					<div class="clear"></div>
				</div>
			</c:forEach>
				
			</div>
	</body>
</html>