<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.xiaomishop.entity.Product"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品</title>
</head>
<body>
	<form action="${ctx}/admin/change1" method="get">
		<%Product p = (Product)request.getAttribute("product"); %>
		<input type="hidden" name="id" value="<%=p.getId() %>">
		<div class="col-md-12">
		    <div class="form-group">
		        <label class="col-sm-3 label_nameedit ">商品名称：</label>
		        <div class="col-sm-9">
		            <input class="form-control" type="text" value="<%=p.getName() %>" name="name">
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="col-sm-3 label_nameedit ">商品类别id：</label>
		        <div class="col-sm-9">
		            <input class="form-control" type="text" value="<%=p.getProducttypeid() %>" name ="producttypeid">
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="col-sm-3 label_nameedit ">描述：</label>
		        <div class="col-sm-9">
		            <input class="form-control" type="text" value="<%=p.getDescription() %>" name="description">
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="col-sm-3 label_nameedit ">单价：</label>
		        <div class="col-sm-9">
		            <input class="form-control" type="text" value="<%=p.getPrice() %>" name="price"> 
		        </div>
		    </div>
		    <input type="submit" value="修改" style="margin-top:30px;">
		</div>
	</form>
</body>
</html>