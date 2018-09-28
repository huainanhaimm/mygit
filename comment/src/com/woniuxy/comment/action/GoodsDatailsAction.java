package com.woniuxy.comment.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.woniuxy.comment.bean.CommentBean;
import com.woniuxy.comment.bean.GoodsBean;
import com.woniuxy.comment.service.IGoodsService;
import com.woniuxy.comment.service.ILoginService;
import com.woniuxy.comment.serviceimpl.GoodsServiceImpl;
import com.woniuxy.comment.serviceimpl.LoginServiceImpl;

public class GoodsDatailsAction {
	// 从前端获取商品gid
	private int gid;
	//获取当前页数
	private int current;

	

	public String execute() {
		// 获取值栈对象
		ActionContext context = ActionContext.getContext();
		// 从后端获取查询的商品详情结果
		IGoodsService igs = new GoodsServiceImpl();
		ILoginService ils = new LoginServiceImpl();

		// 接收查询结果
		GoodsBean gb = igs.findGoodsById(gid);
//		System.err.println(gb.getPhoto() + "图片");
		Map<String, Object> map = new HashMap<String, Object>();
		// 如果有评论信息时，获取评论人
		if (gb.getCblist() != null) {
			List<String> list = new ArrayList<String>();
			for (CommentBean cb : gb.getCblist()) {
				String uname = ils.getName(cb.getUid());
				list.add(uname);
			}
			map.put("uname", list);
		}
		map.put("gb", gb);
	
		// 将查询到的结果全部存到值栈中
		context.put("result", map);
		return "success";
	}

	// 获取评论详情结果
	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

}
