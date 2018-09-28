package com.woniuxy.comment.serviceimpl;

import java.util.List;

import com.woniuxy.comment.bean.GoodsBean;
import com.woniuxy.comment.dao.IGoodsDAO;
import com.woniuxy.comment.daoimpl.GoodsDAOImpl;
import com.woniuxy.comment.service.IGoodsService;

public class GoodsServiceImpl implements IGoodsService {

	/**
	 * (i*6)-6 当前页数显示商品（六条）
	 */
	IGoodsDAO dao = new GoodsDAOImpl();

	@Override
	public List<GoodsBean> findAll(int currentPage) {
		// 默认当前页为1
		int page = 1;
		page = currentPage;
		// 将上传过来的当前页码，转换成每页商品开始的下标
		// 第一页下标从0开始（ 0~5）（6~11）（12~17）
		int index = (page - 1) * 6;
		List<GoodsBean> list = dao.findAll(index);
		return list;
	}

	@Override
	public int tolPage() {
		// 默认总页数为1页
		int tolPage = 1;
		// 查询到共有多少条数据
		int result = dao.findtolPag();
		// 计算一共可以分多少页
		if (result % 6 == 0) {
			tolPage = result / 6;
		} else {
			tolPage = (result / 6) + 1;
		}

		return tolPage;
	}

	/**
	 * 查询商品的详细信息
	 */
	@Override
	public GoodsBean findGoodsById(int gid) {
		GoodsBean bean = null;
		bean = dao.findById(gid);
		return bean;
	}

	/**
	 * 添加商品
	 */
	@Override
	public boolean addGoods(GoodsBean gb) {
		// 存储添加商品的结果
		boolean result = false;
		// 向数据库添加商品同时获取添加结果，一并将结果返回
		int row = dao.addGoods(gb);
		if (row > 0) {
			result = true;
		}
		return result;
	}

}
