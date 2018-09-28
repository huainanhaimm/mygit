package com.woniuxy.comment.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
	
	// 获取工厂对象
	public static SqlSessionFactory getSqlSessionFactory() {
		SqlSessionFactory fa = null;
		// mybatis配置文件的路径(同目录下的config.xml文件)
		String path = "config.xml";
		try {
			// 获取指向path配置文件的输入流
			InputStream in = Resources.getResourceAsStream(path);
			// 将oracle的mybatis框架的内容通过输入流将文件读入配置文件中，同时穿件session工厂
			fa = new SqlSessionFactoryBuilder().build(in,"oracle");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fa;
	}
	
	//获取session对象
	public static SqlSession getSqlSession(){
		//获取session对象，默认不自动提交
		SqlSession session = getSqlSessionFactory().openSession();
		return session;
	}
	
	/**
	 * 
	 * @param true 自动提交事务
	 * @return
	 */
	public static SqlSession getSqlSession(boolean boo){
		//获取session对象同时开启事务自动提交
		SqlSession session = getSqlSessionFactory().openSession(boo);
		return session;
	}

}
