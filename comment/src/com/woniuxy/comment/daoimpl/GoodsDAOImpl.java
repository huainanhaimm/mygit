package com.woniuxy.comment.daoimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.woniuxy.comment.bean.GoodsBean;
import com.woniuxy.comment.dao.IGoodsDAO;
import com.woniuxy.comment.util.MybatisUtil;

public class GoodsDAOImpl implements IGoodsDAO {
	// 获取工厂对象
	SqlSessionFactory fa = MybatisUtil.getSqlSessionFactory();

	/**
	 * 查询所有商品
	 * 
	 * @return list：查询结果的列表
	 */
	@Override
	public List<GoodsBean> findAll(int index) {
		List<GoodsBean> list = null;
		SqlSession session = null;
		try {
			session = fa.openSession();
			// 获取dao的实现类
			IGoodsDAO dao = session.getMapper(IGoodsDAO.class);
			// 执行sql
			list = dao.findAll(index);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	/**
	 * 按照商品id
	 */
	@Override
	public GoodsBean findById(int gid) {
		GoodsBean bean = null;	
		SqlSession session = null;
		try {
			session = fa.openSession();
			// 获取dao的实现类
			IGoodsDAO dao = session.getMapper(IGoodsDAO.class);
			// 执行sql
			bean = dao.findById(gid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return bean;
	}

	//向数据库的商品表插入商品信息
	@Override
	public int addGoods(GoodsBean gb) {
		SqlSession session = null;
		int result = 0;
		try {
			session = fa.openSession(true);
			// 获取dao的实现类
			IGoodsDAO dao = session.getMapper(IGoodsDAO.class);
			// 执行sql
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
			// 获取dao的实现类
			IGoodsDAO dao = session.getMapper(IGoodsDAO.class);
			// 执行sql
			result = dao.findtolPag();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

}
