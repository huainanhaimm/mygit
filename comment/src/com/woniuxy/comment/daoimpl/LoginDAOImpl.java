package com.woniuxy.comment.daoimpl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.woniuxy.comment.bean.LoginBean;
import com.woniuxy.comment.dao.ILoginDAO;
import com.woniuxy.comment.util.MybatisUtil;

public class LoginDAOImpl implements ILoginDAO {
	
	//调用静态工具方法加载mybatis配置文件、同时 获取工厂对象
	private SqlSessionFactory fa = MybatisUtil.getSqlSessionFactory();

	/**
	 * 通过用户传过来的数据查询数据库中是否存在对应数据
	 */
	@Override
	public LoginBean findByNameAndPass(LoginBean lb) {
		// 获取session对象
		SqlSession session = fa.openSession();
		// 存储返回对象(查询结果)
		LoginBean bean = null;
		try {
			// 通过映射器获取ILoginDAo的实现类
			ILoginDAO dao = session.getMapper(ILoginDAO.class);
			// 使用实现类的对象查找mapper.xml中对应的sql语句同时执行sql语句
			bean = dao.findByNameAndPass(lb);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return bean;
	}

	/**
	 * 通过姓名查找密码
	 */
	@Override
	public LoginBean findByName(String uname) {
		LoginBean bean = null;
		SqlSession session = null;
		try {

			// 获取session
			session = fa.openSession();
			// 获取接口实现类
			ILoginDAO dao = session.getMapper(ILoginDAO.class);
			// 执行sql
			bean = dao.findByName(uname);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			session.close();
		}
		return bean;
	}

	// 向数据库插入注册信息
	@Override
	public int insertAll(LoginBean lb) {
		// 插入数据库后返回的（影响行数）信息
		int result = 0;
		// 存储session
		SqlSession session = null;
		try {
			// 调用工具类获取session，同时开启事务的自动提交功能
			session = MybatisUtil.getSqlSession(true);
			//通过mapper获取接口的实现类对象
			ILoginDAO dao = session.getMapper(ILoginDAO.class);
			//操作实现类执行插入数据库操作
			result = dao.insertAll(lb);			
		}catch(Exception e ) {
			e.printStackTrace();
		}finally {
			//关闭资源
			session.close();
		}
	
		
		
		//关闭session
		return result;
	}

	@Override
	public String findNameById(int uid) {
		String result = null;
		SqlSession session = null;
		try {

			// 获取session
			session = fa.openSession();
			// 获取接口实现类
			ILoginDAO dao = session.getMapper(ILoginDAO.class);
			
			// 执行sql
			result = dao.findNameById(uid);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			session.close();
		}
		return result;
	}

}
