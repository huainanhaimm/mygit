package com.woniuxy.comment.daoimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.woniuxy.comment.bean.GoodsBean;
import com.woniuxy.comment.dao.IGoodsDAO;
import com.woniuxy.comment.util.MybatisUtil;

public class GoodsDAOImpl implements IGoodsDAO {
	// ��ȡ��������
	SqlSessionFactory fa = MybatisUtil.getSqlSessionFactory();

	/**
	 * ��ѯ������Ʒ
	 * 
	 * @return list����ѯ������б�
	 */
	@Override
	public List<GoodsBean> findAll(int index) {
		List<GoodsBean> list = null;
		SqlSession session = null;
		try {
			session = fa.openSession();
			// ��ȡdao��ʵ����
			IGoodsDAO dao = session.getMapper(IGoodsDAO.class);
			// ִ��sql
			list = dao.findAll(index);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	/**
	 * ������Ʒid
	 */
	@Override
	public GoodsBean findById(int gid) {
		GoodsBean bean = null;	
		SqlSession session = null;
		try {
			session = fa.openSession();
			// ��ȡdao��ʵ����
			IGoodsDAO dao = session.getMapper(IGoodsDAO.class);
			// ִ��sql
			bean = dao.findById(gid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return bean;
	}

	//�����ݿ����Ʒ�������Ʒ��Ϣ
	@Override
	public int addGoods(GoodsBean gb) {
		SqlSession session = null;
		int result = 0;
		try {
			session = fa.openSession(true);
			// ��ȡdao��ʵ����
			IGoodsDAO dao = session.getMapper(IGoodsDAO.class);
			// ִ��sql
			result = dao.addGoods(gb);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int findtolPag() {
		SqlSession session = null;
		int result = 0;
		try {
			session = fa.openSession(true);
			// ��ȡdao��ʵ����
			IGoodsDAO dao = session.getMapper(IGoodsDAO.class);
			// ִ��sql
			result = dao.findtolPag();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

}
