package com.bookmanage.service;

import com.bookmanage.bean.BookBean;

public interface IDetailsBookService {
	
	/**
	 * 根据书名查找书id
	 * @param bname 书名
	 * @return 返回查询到的对应书的id
	 */
	public boolean findByName(String bname);
	
	/**
	 * 展示图书详细信息
	 * @param bid
	 * @return
	 */
	public  BookBean  showDetails(int bid);

}
