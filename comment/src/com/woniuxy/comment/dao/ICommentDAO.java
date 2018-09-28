package com.woniuxy.comment.dao;

import com.woniuxy.comment.bean.CommentBean;

public interface ICommentDAO {
	/**
	 * 插入评论 内容的接口，为业务层提供数据
	 * @param cb
	 * @return
	 */
	public int insertComment(CommentBean cb);
	
}
