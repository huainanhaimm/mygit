//接收页面传参
function getGid() {
	var str = window.location.search;
	var gid = str.substr((str.indexOf("=") + 1));
	return gid;
}

getGid();

function goodsDatails() {

	$.ajax({
		url : "/comment/showGoods/goodsDatails",
		type : "post",
		data : {
			gid : getGid(),
		},
		dateType : "json",
		success : function(data) {
			// 商品信息
			var gname = data.gname;
			// var kname = data.kb.kname;
			alert(data.gb.photo);
			// alert(data.uname);
			// alert(data.gb.cblist);
			// alert(data.gb.photo);
			// 商品图片
			// $("#photo").attr("src","F:tomcat/webapps/comment/img/蕾姆.jpg");
			// $("#photo").attr("src"," ");
			// alert($("#photo").attr("src"));
			// 商品名称
			$("#gname").html(data.gb.gname);
			// 商品种类
			$("#kname").html(data.gb.kb.kname);
			// 商品单价
			$("#price").html(data.gb.price + "元");
			// 评论人
			for (var i = 0; i < data.uname.length; i++) {
				$("#c" + i + "").html(data.uname[i]);
			}

			for (var i = 0; i < data.gb.cblist.length; i++) {
				// 评论时间
				$("#time" + i + "").html(data.gb.cblist[i].com_time);
				// 评论内容
				$("#content" + i + "").html(data.gb.cblist[i].content);
			}
		}

	});
}
// 加载页面
goodsDatails();

// 上传 评论数据（uid、评论内容、评论商品gid）
function addComment() {
	$.ajax({
		url : "/comment/comment/addComment",
		type : "post",
		data : {
			// 评论人在后台session中取
			content : $("#content").val(),
			gid : getGid()
		},
		dataType : "json",
		success : function(data) {
			alert(data);
		}
	})

}
