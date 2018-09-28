package com.woniuxy.comment.service;

import com.woniuxy.comment.bean.LoginBean;

public interface ILoginService {
	/**
	 * 
	 * @param lb:����һ��������
	 * @return ���ز�ѯ��� ��ʾ�Ƿ��ѯ�ɹ�����¼ �ɹ���
	 */
	public LoginBean findPassByName(LoginBean lb ); 
	
	/**
	 * ���� ע��ҵ��
	 * @return
	 */
	public String register(LoginBean lb);
	
	/**
	 * ͨ��uid�õ��û���
	 * @param uid
	 * @return
	 */
	public String getName(int uid);
	
		/**
		 *����û����Ƿ����
		 * @return 
		 */
	public	String checkLoginName(String uname);

	/**
	 *��������Ƿ����
	 * @return 
	 */
	public boolean checkLoginPass(String pass);

}
