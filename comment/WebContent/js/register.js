//注册成功，实现页面跳转到登录界面
function jump(){
var result = $("#registerResult").html();
	if(result=="注册成功"){
		window.location.href="/comment/login.jsp";
	}
}
//当jsp加载完毕后判断注册情况
jump();