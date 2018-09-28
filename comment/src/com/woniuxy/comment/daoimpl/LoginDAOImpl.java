package com.woniuxy.comment.daoimpl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.woniuxy.comment.bean.LoginBean;
import com.woniuxy.comment.dao.ILoginDAO;
import com.woniuxy.comment.util.MybatisUtil;

public class LoginDAOImpl implements ILoginDAO {
	
	//���þ�̬���߷�������mybatis�����ļ���ͬʱ ��ȡ��������
	private SqlSessionFactory fa = MybatisUtil.getSqlSessionFactory();

	/**
	 * ͨ���û������������ݲ�ѯ���ݿ����Ƿ���ڶ�Ӧ����
	 */
	@Override
	public LoginBean findByNameAndPass(LoginBean lb) {
		// ��ȡsession����
		SqlSession session = fa.openSession();
		// �洢���ض���(��ѯ���)
		LoginBean bean = null;
		try {
			// ͨ��ӳ������ȡILoginDAo��ʵ����
			ILoginDAO dao = session.getMapper(ILoginDAO.class);
			// ʹ��ʵ����Ķ������mapper.xml�ж�Ӧ��sql���ͬʱִ��sql���
			bean = dao.findByNameAndPass(lb);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return bean;
	}

	/**
	 * ͨ��������������
	 */
	@Override
	public LoginBean findByName(String uname) {
		LoginBean bean = null;
		SqlSession session = null;
		try {

			// ��ȡsession
			session = fa.openSession();
			// ��ȡ�ӿ�ʵ����
			ILoginDAO dao = session.getMapper(ILoginDAO.class);
			// ִ��sql
			bean = dao.findByName(uname);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
			session.close();
		}
		return bean;
	}

	// �����ݿ����ע����Ϣ
	@Override
	public int insertAll(LoginBean lb) {
		// �������ݿ�󷵻صģ�Ӱ����������Ϣ
		int result = 0;
		// �洢session
		SqlSession session = null;
		try {
			// ���ù������ȡsession��ͬʱ����������Զ��ύ����
			session = MybatisUtil.getSqlSession(true);
			//ͨ��mapper��ȡ�ӿڵ�ʵ�������
			ILoginDAO dao = session.getMapper(ILoginDAO.class);
			//����ʵ����ִ�в������ݿ����
			result = dao.insertAll(lb);			
		}catch(Exception e ) {
			e.printStackTrace();
		}finally {
			//�ر���Դ
			session.close();
		}
	
		
		
		//�ر�session
		return result;
	}

	@Override
	public String findNameById(int uid) {
		String result = null;
		SqlSession session = null;
		try {

			// ��ȡsession
			session = fa.openSession();
			// ��ȡ�ӿ�ʵ����
			ILoginDAO dao = session.getMapper(ILoginDAO.class);
			
			// ִ��sql
			result = dao.findNameById(uid);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
			session.close();
		}
		return result;
	}

}
