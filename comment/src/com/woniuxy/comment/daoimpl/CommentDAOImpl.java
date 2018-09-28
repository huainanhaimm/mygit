package com.woniuxy.comment.daoimpl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.woniuxy.comment.bean.CommentBean;
import com.woniuxy.comment.dao.ICommentDAO;
import com.woniuxy.comment.util.MybatisUtil;

public class CommentDAOImpl implements ICommentDAO {
	// 获取工厂对象
	SqlSessionFactory fa = MybatisUtil.getSqlSessionFactory();

	/**
	 * 插入客户端传来的评论数据
	 */
	@Override
	public int insertComment(CommentBean cb) {
		// 返回插入数据后 的
		int result = 0;
		SqlSession session = null;
		try {
			// 获取session
			session = fa.openSession(true);
			// 获取映射对象
			ICommentDAO idao = session.getMapper(ICommentDAO.class);
			// 执行sql
			result = idao.insertComment(cb);
		} catch (Exception e) {

		} finally {
			session.close();
		}

		return result;
	}

}
