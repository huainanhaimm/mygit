package com.bookmanage.service;

import com.bookmanage.bean.BookBean;

public interface IBorrowBook {
	/**
	 * 处理借书业务
	 * @param bid  书的id
 	 * @return  借书结果
	 */
	public boolean borrow(int bid); 
	
	/**
	 * 处理用户查询所借书情况的业务
	 * @param uid 用户id
	 * @return 返回借书的情况
	 */
	public BookBean query(int uid);

}
