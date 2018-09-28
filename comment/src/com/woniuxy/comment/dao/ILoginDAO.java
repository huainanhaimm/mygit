package com.woniuxy.comment.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.woniuxy.comment.bean.LoginBean;

/**
 * 持久层业务为业务层服务
 * @author Administrator
 *
 */
public interface ILoginDAO {
	
	/**
	 * 处理登录业务（）
	 * @param lb
	 * @return
	 */
	public LoginBean findByNameAndPass(LoginBean lb);
	
	
	/**
	 * 通过姓名查找密码
	 * @param uname
	 * @return
	 */
	public  LoginBean findByName(String uname);
	/**
	 * 通过id查姓名
	 * @param uid
	 * @return
	 */
	@Select("select uname from t_login where uid=#{uid}")
//	@Results({
//		@Result(property="uname",column="uname")
//	})
	public String findNameById(int uid);

	/**
	 * 向数据库插入注册信息 
	 * @param lb：用户上传的注册信息
	 * @return
	 */
	public int insertAll(LoginBean lb);
	
	
	
	
	
	
	

}
