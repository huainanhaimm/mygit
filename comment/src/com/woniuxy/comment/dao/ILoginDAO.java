package com.woniuxy.comment.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.woniuxy.comment.bean.LoginBean;

/**
 * �־ò�ҵ��Ϊҵ������
 * @author Administrator
 *
 */
public interface ILoginDAO {
	
	/**
	 * �����¼ҵ�񣨣�
	 * @param lb
	 * @return
	 */
	public LoginBean findByNameAndPass(LoginBean lb);
	
	
	/**
	 * ͨ��������������
	 * @param uname
	 * @return
	 */
	public  LoginBean findByName(String uname);
	/**
	 * ͨ��id������
	 * @param uid
	 * @return
	 */
	@Select("select uname from t_login where uid=#{uid}")
//	@Results({
//		@Result(property="uname",column="uname")
//	})
	public String findNameById(int uid);

	/**
	 * �����ݿ����ע����Ϣ 
	 * @param lb���û��ϴ���ע����Ϣ
	 * @return
	 */
	public int insertAll(LoginBean lb);
	
	
	
	
	
	
	

}
