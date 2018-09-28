package com.bookmanage.service;

import com.bookmanage.bean.BookBean;

public interface IManageBookService {
	/**
	 * 处理图书录入功能
	 * @param bb 要添加的图书对象
	 * @return 返回bolean表示录入结果
	 */
	public boolean addBook(BookBean bb);
	/**
	 * 根据图书id删除对应图书
	 * @param bid 图书id
	 * @return 返回boolean 表示删除结果
	 */
	public boolean del(int bid);
	
	/**
	 * 处理修改图书信息（价格，出版社，描述信息）
	 * @param bid 图书id
	 * @return boolean 修改结果
	 */
	public boolean fix(int bid);

}
