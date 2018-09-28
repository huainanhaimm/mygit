package com.woniuxy.comment.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
	
	// ��ȡ��������
	public static SqlSessionFactory getSqlSessionFactory() {
		SqlSessionFactory fa = null;
		// mybatis�����ļ���·��(ͬĿ¼�µ�config.xml�ļ�)
		String path = "config.xml";
		try {
			// ��ȡָ��path�����ļ���������
			InputStream in = Resources.getResourceAsStream(path);
			// ��oracle��mybatis��ܵ�����ͨ�����������ļ����������ļ��У�ͬʱ����session����
			fa = new SqlSessionFactoryBuilder().build(in,"oracle");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fa;
	}
	
	//��ȡsession����
	public static SqlSession getSqlSession(){
		//��ȡsession����Ĭ�ϲ��Զ��ύ
		SqlSession session = getSqlSessionFactory().openSession();
		return session;
	}
	
	/**
	 * 
	 * @param true �Զ��ύ����
	 * @return
	 */
	public static SqlSession getSqlSession(boolean boo){
		//��ȡsession����ͬʱ���������Զ��ύ
		SqlSession session = getSqlSessionFactory().openSession(boo);
		return session;
	}

}
