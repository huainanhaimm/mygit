<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>

<!-- 引入struts标签库 -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品列表</title>
<!--引入css样式  -->
<link href="/comment/css/showGoods.css" rel="stylesheet" type="text/css">
<!-- 引入jquery文件 -->
<script type="text/javascript" src="/comment/js/jquery.1.9.1.js"></script>

</head>
<body>
	<div class="outer">
		<!-- 顶部欢迎行 -->
		<div class="top">
			欢迎光临<font>杂货店</font>
		</div>

		<!-- 主题商品展示行  -->
		<div class="center">
			<table cellspacing="0">
				<tr>
					<th>商品名</th>
					<th>单价</th>
					<th>类别</th>
					<th>评论数量</th>
				</tr>
				<tr class="l0" onclick="goodsDatails(this);">
					<td id="l01" ></td>
					<td id="l02"></td>
					<td id="l03"></td>
					<td id="l04"></td>
				</tr>
				<tr class="l1" onclick="goodsDatails(this);">
					<td id="l11"></td>
					<td id="l12"></td>
					<td id="l13"></td>
					<td id="l14"></td>
				</tr>
				<tr class="l2" onclick="goodsDatails(this);" >
					<td id="l21"></td>
					<td id="l22"></td>
					<td id="l23"></td>
					<td id="l24"></td>
				</tr>
				<tr class="l3" onclick="goodsDatails(this);">
					<td id="l31"></td>
					<td id="l32"></td>
					<td id="l33"></td>
					<td id="l34"></td>
				</tr>
				<tr class="l4" onclick="goodsDatails(this);">
					<td id="l41"></td>
					<td id="l42"></td>
					<td id="l43"></td>
					<td id="l44"></td>
				</tr>
				<tr class="l5" onclick="goodsDatails(this);">
					<td id="l51"></td>
					<td id="l52"></td>
					<td id="l53"></td>
					<td id="l54"></td>					
				</tr>
			</table>
			
			
		<input id="l0" class="hidden0"  type="hidden"  value="" />
		<input id="l1" class="hidden1"  type="hidden" onclick="" value="" />
		<input id="l2" class="hidden2"  type="hidden" onclick="" value="" />
		<input id="l3" class="hidden3"  type="hidden" onclick="" value="" />
		<input id="l4" class="hidden4"  type="hidden" onclick="" value="" />
		<input id="l5" class="hidden5"  type="hidden" onclick="" value="" />
			
		</div>
		<!--查看按钮  -->
		<div class="buttom">
			<div onclick="start();">首页</div>
			<div onclick="last();">上一页</div>		
			<div id="current" >第1页</div>
			<div id="tolPage">共1页</div>
			<div onclick="next();">下一页</div>
			<div onclick="end();">末页</div>
		</div>

	</div>
	<script type="text/javascript" src="/comment/js/showGoods.js"></script>
</body>
</html>