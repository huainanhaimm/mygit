package com.bookmanage.dao;

import java.util.List;

import com.bookmanage.bean.BookBean;

public interface IBookDao {
	/**
	 * 查询所有的图书信息
	 * @return List 返回所有查询结果
	 */
	public Long findAll();

	/**
	 * 查询六条图书信息
	 * @param index 每页开始的图书的下标
	 * @return List 查询到的六条图书信息
	 */
	public List<BookBean> findSixById(int index);

}
