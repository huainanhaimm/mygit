package com.woniuxy.comment.dao;

import com.woniuxy.comment.bean.CommentBean;

public interface ICommentDAO {
	/**
	 * �������� ���ݵĽӿڣ�Ϊҵ����ṩ����
	 * @param cb
	 * @return
	 */
	public int insertComment(CommentBean cb);
	
}
