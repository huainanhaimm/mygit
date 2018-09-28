package com.woniuxy.comment.serviceimpl;

import com.woniuxy.comment.bean.CommentBean;
import com.woniuxy.comment.dao.ICommentDAO;
import com.woniuxy.comment.daoimpl.CommentDAOImpl;
import com.woniuxy.comment.service.ICommentService;

public class CommentServiceImpl implements ICommentService {
	//获取持久层对象
	private ICommentDAO idao = new CommentDAOImpl();
	
	/**
	 *实添加评论业务的实现类
	 *boolean:是否插入成功 
	 */
	@Override
	public boolean addComment(CommentBean cb) {
	//调用持久层接口实现类实现 评论的插入	
		//存储插入结果，默认插入失败
		boolean result = false;
		int row = idao.insertComment(cb);
		if(row > 0) {
			//插入成功
			result =true;
		}
		return result ;
	}

}
