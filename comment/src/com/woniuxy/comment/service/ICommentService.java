package com.woniuxy.comment.service;

import com.woniuxy.comment.bean.CommentBean;

public interface ICommentService {
	/**
	 * 添加评论的业务接口
	 * @param cb
	 */
	public boolean addComment(CommentBean cb); 
}
