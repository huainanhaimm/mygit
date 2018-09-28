package com.woniuxy.comment.service;

import java.util.List;

import com.woniuxy.comment.bean.GoodsBean;

public interface IGoodsService {
	
	/**
	 * 按照当前页数查找商品信息的业务接口（一次查询六条数据）
	 * @return 返回一个list列表
	 */
	public List<GoodsBean> findAll(int currentPage);
	
	/**
	 * 计算商品一共可以分多少页（一页六条，不足的单独成一页）
	 * @return 总页数
	 */
	public int tolPage();
	
	
	/**
	 * 通过商品id查询商品详情的业务接口
	 * @param gid
	 * @return
	 */
	public GoodsBean findGoodsById(int gid); 
	
	
	/**
	 * 添加商品的业务接口
	 * @param gb
	 */
	public boolean addGoods(GoodsBean gb);
}
