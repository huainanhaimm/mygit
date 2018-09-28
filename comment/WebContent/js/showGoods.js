//上传当前页数
function upCurrent(spage) {
	// var page = $("#current").html();
	// var spage = page.substring(1, page.indexOf("页"));
	$.ajax({
		url : "/comment/showGoods/showGoods",
		type : "post",
		data : {
			// 将当前页数上传至后台
			current : spage,
		},
		dateType : "json",
		success : function(data) {
			var temp = data.list;
			if (temp.length == 6) {
				// 数据 等于六条时
				for (var i = 0; i < temp.length; i++) {
					var content = temp[i];
					$("#l" + i + "" + 1 + "").html(content.gname);
					$("#l" + i + "" + 2 + "").html(content.price);
					$("#l" + i + "" + 3 + "").html(content.kb.kname);
					$("#l" + i + "" + 4 + "").html(content.num);
					//隐藏商品的gid
					$("#l" + i + "").val(content.gid);
				};
			} else {
				// 数据不足六条时,填充有数据的 行
				for (var i = 0; i < temp.length; i++) {
					var content = temp[i];
					$("#l" + i + "" + 1 + "").html(content.gname);
					$("#l" + i + "" + 2 + "").html(content.price);
					$("#l" + i + "" + 3 + "").html(content.kb.kname);
					$("#l" + i + "" + 4 + "").html(content.num);
					//隐藏商品的gid
					$("#l" + i + "").val(content.gid);
				};
				// 填充没有数据的行（空白填充）
				for (var j = temp.length; j < 6; j++) {
					$("#l" + j + "" + 1 + "").html("");
					$("#l" + j + "" + 2 + "").html("");
					$("#l" + j + "" + 3 + "").html("");
					$("#l" + j + "" + 4 + "").html("");
				};
				
			};
			$("#tolPage").html("共" + data.tolPage + "页");
//			alert($("#" + i + "").val(temp[0].gid););
		}

	})

}
// 默认加载第一页
upCurrent(1);

function start() {
	upCurrent(1);
	$("#current").html("第1页");
}

function end() {
	// 获取 总页数
	var page = $("#tolPage").html();
	var tolPage = page.substring(1, page.indexOf("页"));
	tolPage = parseInt(tolPage);
	$("#current").html("第" + tolPage + "页");
	upCurrent(tolPage);
}

// 下一页
function next() {
	// 获取 总页数
	var page = $("#tolPage").html();
	var tolPage = page.substring(1, page.indexOf("页"));
	// 获取当前页数
	var page = $("#current").html();
	var spage = page.substring(1, page.indexOf("页"));
	spage = parseInt(spage);
	if (spage < tolPage) {
		upCurrent(spage + 1);
		$("#current").html("第" + (spage + 1) + "页");
	} else {
		alert("已经是最后一页了");
	}
}

// 上一页
function last() {
	// 获取 总页数
	var page = $("#tolPage").html();
	var tolPage = page.substring(1, page.indexOf("页"));
	// 获取当前页数
	var page = $("#current").html();
	var spage = page.substring(1, page.indexOf("页"));
	spage = parseInt(spage);

	if (spage > 1) {
		upCurrent(spage - 1);
		$("#current").html("第" + (spage - 1) + "页");
	} else {
		alert("已经是第一页了");
	}
}



//发送查看商品详情请求（ajsx上传商品gid）

function goodsDatails(tr){

	window.location.href="/comment/jsp/GoodsDatails.jsp?gid="+getId(tr)+"";

}


//获取商品id
function getId(tr){
	//获取鼠标点击的商品对应的class属性值（因为class属性值和input的id绑定了）
	var id =$(tr).attr("class");
	//获取商品gid
	var gid =$("#"+id+"").val();
	return gid;
}




