<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${ctx}/admin/add" method="get">
		<div class="col-md-12">
		    <div class="form-group">
		        <label class="col-sm-3 label_nameedit ">商品名称：</label>
		        <div class="col-sm-9">
		            <input class="form-control" type="text" name="name"  placeholder="请输入商品名">
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="col-sm-3 label_nameedit ">商品类别id：</label>
		        <div class="col-sm-9">
		            <input class="form-control" type="text" name ="producttypeid"  placeholder="请输入商品类别id" >
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="col-sm-3 label_nameedit ">描述：</label>
		        <div class="col-sm-9">
		            <input class="form-control" type="text" name="description"  placeholder="请输入产品描述">
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="col-sm-3 label_nameedit ">单价：</label>
		        <div class="col-sm-9">
		            <input class="form-control" type="text" name="price"  placeholder="请输入单价"> 
		        </div>
		    </div>
		    <input type="submit" value="增加商品" style="margin-top:30px;">
		</div>
	</form>
</body>
</html>