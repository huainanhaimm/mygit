<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- 引入struts标签库 -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>

<style>
	.errorMessage{
		list-style:none;
		margin:0px;
		padding:0px;
		font-size:12px;
		color:red;
	}
	
	.registerResult font{
		color: red;
	}
	
</style>
	<!-- 引入jquery文件 -->
	<script type="text/javascript" src="/comment/js/jquery.1.9.1.js"></script>
</head>
<body>

	<!-- 输出错误信息的标签 -->
	<%-- <s:fielderror></s:fielderror> --%>
	<div>
		<form action="/comment/register/register" method="post">
			<label>用 &nbsp;户&nbsp;名：</label><input type="text" name="uname" /><br /><br />
			<label>密&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label><input type="password" name="pass" /> <br /> <br /> 				
			<label>确认密码：</label><input type="password" name="passCheck" />
			<button type="submit" >注册</button>
			<br /> 
			<!-- 输出错误信息的标签 -->
			<s:fielderror fieldName="passError"></s:fielderror>
			<s:fielderror fieldName="unameError"></s:fielderror>
			<s:fielderror fieldName="passCheckError"></s:fielderror>
			<!--  后台注册结果提示 -->
			<div class="registerResult">
				<font id="registerResult"><s:property value="#request.result" /></font>		
			</div>
			
			
			<!-- 取出后台返回的注册数据 -->
			
		</form>
		<br/><br/><br/>
		<div>用户名规范：支持长度为在10以内的字符串</div>
		<div>用户密码规范：支持长度在6以内的的字符串</div>
	</div>
	
	<script type="text/javascript" src="/comment/js/register.js"></script>
</body>
</html>