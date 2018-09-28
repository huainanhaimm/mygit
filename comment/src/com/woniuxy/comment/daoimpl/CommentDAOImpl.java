package com.woniuxy.comment.daoimpl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.woniuxy.comment.bean.CommentBean;
import com.woniuxy.comment.dao.ICommentDAO;
import com.woniuxy.comment.util.MybatisUtil;

public class CommentDAOImpl implements ICommentDAO {
	// ��ȡ��������
	SqlSessionFactory fa = MybatisUtil.getSqlSessionFactory();

	/**
	 * ����ͻ��˴�������������
	 */
	@Override
	public int insertComment(CommentBean cb) {
		// ���ز������ݺ� ��
		int result = 0;
		SqlSession session = null;
		try {
			// ��ȡsession
			session = fa.openSession(true);
			// ��ȡӳ�����
			ICommentDAO idao = session.getMapper(ICommentDAO.class);
			// ִ��sql
			result = idao.insertComment(cb);
		} catch (Exception e) {

		} finally {
			session.close();
		}

		return result;
	}

}
