<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加商品</title>
<link href="/comment/css/AddGoods.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/comment/js/jquery.1.9.1.js"></script>

<style>
.errorMessage {
	list-style: none;
	padding: 0px;
	font-size: 16px;
	color: red;
}
</style>

</head>
<body>
	<!-- 表单提交数据：字符流      enctype="multipart/form-data":表示客户端提交数据，以字节流方式传输-->
	<form method="post" action="/comment/showGoods/addGoods"
		enctype="multipart/form-data">
		<input type="file" name="imgName" id="file" /> 
		<br/><br/> 
		<label>商品名称：</label><input type="text" name="gname" id="gname" /> 
			<br/> <br/> 
		<label>商品价格：<input type="text" name="price" id="price" style="width:140px; "/>&nbsp; 元</label>
		<br/> <br/> 
		<label>商品种类：</label><select name="kind" style="width:165px; height:23px;">
			<option value="1">海报</option>
			<option value="2">书籍</option>
			<option value="3">电器</option>
			<option value="4">其他</option>
		</select>
		<br/>
		<!-- 错误提醒标签  -->
		<s:fielderror fieldName="fileError"></s:fielderror>
		<!-- 添加结果提示 -->
		<div><s:property value="#request.result" /></div>
		<button type="submit">提交</button>
	</form>


	<script type="text/javascript" src="/comment/js/AddGoods.js"></script>
</body>
</html>