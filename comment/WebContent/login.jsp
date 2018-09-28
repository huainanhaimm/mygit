<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
<style>
.errorMessage {
	list-style: none;
	margin: 0px;
	padding: 0px;
	font-size: 12px;
	color: red;
}
</style>

</head>
<body>
	<div>
		<form method="post" action="/comment/login/login">
			<label>用户账号：</label><input type="text" name="uname" /><br /> 
			<label>用户密码：</label><input type="password" name="pass" /><br />

			<button type="submit">登录</button>
			<!-- 错误提醒标签  -->
			<s:fielderror fieldName="nameError"></s:fielderror>
			<s:fielderror fieldName="pwdError"></s:fielderror>
			<s:fielderror fieldName="loginError"></s:fielderror>
		</form>


	</div>

</body>
</html>