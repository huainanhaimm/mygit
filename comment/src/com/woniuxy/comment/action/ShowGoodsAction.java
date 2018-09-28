package com.woniuxy.comment.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.ActionContext;
import com.woniuxy.comment.bean.GoodsBean;
import com.woniuxy.comment.service.IGoodsService;
import com.woniuxy.comment.serviceimpl.GoodsServiceImpl;

/**
 * 展示商品 列表
 * 
 * @author Administrator
 *
 */
public class ShowGoodsAction {
	// 获取服务层接口
	private IGoodsService igs = new GoodsServiceImpl();

	// 获取页面传参（上传的当前页数）
	private String current;

	// 保存响应回客户端的信息
//	private String result;

	public String execute() {
		// 将页面传参转换为int
		int current = 1;
		try {
			current = Integer.parseInt(this.current);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获取后台响应过来的值
		// 6条商品数据
		List<GoodsBean> list = igs.findAll(current);
		// 数据库中总页数
		int tolPage = igs.tolPage();
		// 获取值栈对象
		ActionContext content = ActionContext.getContext();

		// 将获取到的注册是否成功的信息存入值栈中request作用域中
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("tolPage", tolPage);
		content.put("result", map);

		// // 将后台向前台响应数据转换成json
		// ObjectMapper obj = new ObjectMapper();
		// try {
		// result = obj.writeValueAsString(list);
		// } catch (IOException e) {
		//
		// e.printStackTrace();
		// }
		return "success";
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

//	public String getResult() {
//		return result;
//	}
//
//	public void setResult(String result) {
//		this.result = result;
//	}

}
