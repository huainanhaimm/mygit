package com.bookmanage.service;

import java.util.List;

import com.bookmanage.bean.BookBean;



public interface IShowBookService {
		
	/**
	 * 处理分页展示图书的业务，根据当前页查询当夜应展示的所有图书(6条)
	 * @param current 当前页数
	 * @return  查询到的图书数据
	 */
	public List<BookBean> paging(int current);
	
	/**
	 * 统计数据库中的图书共多少页（六条数据一页）
	 * @return 总页数
	 */
	public Long tolPage();
	
}
