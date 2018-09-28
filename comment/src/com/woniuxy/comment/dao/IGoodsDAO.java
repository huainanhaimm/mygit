package com.woniuxy.comment.dao;

import java.util.List;

import com.woniuxy.comment.bean.GoodsBean;

public interface IGoodsDAO {
	/**
	 * 按照当前页数查询（6条）商品数据
	 * @return
	 */
	public List<GoodsBean> findAll(int index);
	
	/**
	 * 使用聚合函数 按照id查询共多少条商品信息（为业务层提供计算总页数的数据）
	 * @return
	 */
	public int findtolPag();
	
	public GoodsBean findById(int gid);

	public int addGoods(GoodsBean gb);


	
	
	

}
