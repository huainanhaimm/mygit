package com.woniuxy.comment.serviceimpl;

import com.woniuxy.comment.bean.LoginBean;
import com.woniuxy.comment.dao.ILoginDAO;
import com.woniuxy.comment.daoimpl.LoginDAOImpl;
import com.woniuxy.comment.service.ILoginService;

public class LoginServiceImpl implements ILoginService {
	private ILoginDAO dao = new LoginDAOImpl();

	/**
	 * �����¼ҵ��
	 */
	@Override
	public LoginBean findPassByName(LoginBean lb) {
		// �洢��ѯ���
		boolean result = false;
		LoginBean bean = dao.findByNameAndPass(lb);
		return bean;
	}

	/**
	 * ע���˻�ҵ��
	 */
	@Override
	public String register(LoginBean lb) {
		// �洢ע�������ɹ���ʧ�ܣ�
		String result = "ע��ʧ��";
		// ��ҳ�洫�����������ݼ����ȷ��������ݿ������ݣ�ͬʱ����sql��������Ӱ������row
		// ��ȡ�û���������
		String unameResult = checkLoginName(lb.getUname());
		// ��ȡ���������
		boolean passIsOK = checkLoginPass(lb.getPass());
		// �û�����ͨ��֤ͨ��
		if (unameResult.equals("��ע��")) {
			// ��ʼ��֤�����Ƿ�Ϸ�
			if (passIsOK == false) {
				// ���Ϸ�
				result = "�û����벻�Ϸ���";
			} else {
				result = "��ע��";
			}
		} else {
			// �û�����֤��ͨ��ͨ��
			result = unameResult;
		}

		// �û��������붼�Ϸ�����ʼִ�в������ݿ�Ĳ���
		if (result.equals("��ע��")) {
			// ���ز������ݿ� ���Ӱ������
			int row = dao.insertAll(lb);
			// ���������������0�����ɹ�������ʧ��
			if (row > 0) {
				result = "ע��ɹ�";
			} else {
				result = "ע��ʧ�ܣ�";
			}

		}
		return result;

	}

	/**
	 * ����û�������Ϣ����ȷ��
	 */
	@Override
	public String checkLoginName(String uname) {
		// �洢���û��������Ƿ�Ϸ��Ľ��
		String result = "";	
		// ����û����Ƿ�Ϸ��������Ƿ���10���ڣ��Ƿ�Ϊ�ַ�����
		// ���Ϸ�
		if (uname.length() > 10) {
			result = "�û������Ϸ�";
			// �Ϸ�,�����ж����ݿ����Ƿ��Ѿ������˺�
		} else {
			// ��ѯ���ΪΪnull����ʾ��ע�ᣩ
			if (dao.findByName(uname) == null) {

				result = "��ע��";
			} else {
				// ��ѯ�����Ϊ�գ��û����Ѿ����ڣ�
				result = "�û����Ѿ�����";
			}
		}
		return result;
	}

	@Override
	public boolean checkLoginPass(String pass) {
		boolean result = false;
		// �ж������Ƿ�Ϸ��������׼��������6�����ڰ���6���ַ�����
		// �Ϸ�
		if (pass.length() <= 6) {
			result = true;
		}
		return result;
	}

	//ͨ��uid��ѯunam
	@Override
	public String getName(int uid) {
		String result = dao.findNameById(uid); 
		return result;
	}

}
