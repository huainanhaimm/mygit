<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- 引入struts标签库 -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品详情</title>
<link type="text/css" rel="stylesheet"
	href="/comment/css/goodsDatails.css">
<script type="text/javascript" src="/comment/js/jquery.1.9.1.js"></script>
</head>
<body>
	<div class="main">
		<div class="GoodsDatails">             
		<div  class="img"><img id="photo" src="\file\tomcat\webapps\comment\upload\79bbcdc9-2bc9-4ef5-b959-8ee28679f16c_大精灵.jpg" width="100%" height="100%"></div>
			<div class="describe">
				<div class="messge">
					<span>名称：</span> <span id="gname"></span>
				</div>
				<div class="messge">
					<span>类别：</span> <span id="kname"></span>
				</div>
				<div class="messge">
					<span>单价：</span> <span id="price"></span>
				</div>
			</div>
		</div>

		<div class="comment">
			<div class="comment-main">
				<table cellspacing="0">
					<tr>
						<th class="td1">评论人</th>
						<th class="td2">评论时间</th>
						<th class="td3">评论内容</th>
					</tr>
					<tr>
						<td id="c0" class="td1"></td>
						<td id="time0" class="td2"></td>
						<td id="content0" class="td3"></td>
					</tr>
					<tr>
						<td id="c1" class="td1"></td>
						<td id="time1" class="td2"></td>
						<td id="content1" class="td3"></td>
					</tr>
					<tr>
						<td id="c2" class="td1"></td>
						<td id="time2" class="td2"></td>
						<td id="content2" class="td3"></td>
					</tr>
					<tr>
						<td id="c3" class="td1"></td>
						<td id="time3" class="td2"></td>
						<td id="content3" class="td3"></td>
					<tr>
						<td id="c4" class="td1"></td>
						<td id="time4" class="td2"></td>
						<td id="content4" class="td3"></td>
					</tr>
				</table>
			</div>
			<div class="comment-button">
				<div onclick="start();">首页</div>
				<div onclick="last();">上一页</div>
				<div id="current">第1页</div>
				<div id="tolPage">共1页</div>
				<div onclick="next();">下一页</div>
				<div onclick="end();">末页</div>
			</div>
		</div>
		<div class="AddComment">
			<div class="AddComment-title">评论内容：</div>
			<div class="AddComment-main">
				<textarea id="content" name="text"></textarea>
			</div>
		</div>
		<div class="button">
			<div class="button-comment">
				<button onclick=" addComment();">评论</button>
			</div>
			<div class="button-return">
				<button>返回主页</button>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/comment/js/goodsDatails.js"></script>
</body>
</html>