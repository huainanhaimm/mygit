package com.woniuxy.comment.serviceimpl;

import com.woniuxy.comment.bean.CommentBean;
import com.woniuxy.comment.dao.ICommentDAO;
import com.woniuxy.comment.daoimpl.CommentDAOImpl;
import com.woniuxy.comment.service.ICommentService;

public class CommentServiceImpl implements ICommentService {
	//��ȡ�־ò����
	private ICommentDAO idao = new CommentDAOImpl();
	
	/**
	 *ʵ�������ҵ���ʵ����
	 *boolean:�Ƿ����ɹ� 
	 */
	@Override
	public boolean addComment(CommentBean cb) {
	//���ó־ò�ӿ�ʵ����ʵ�� ���۵Ĳ���	
		//�洢��������Ĭ�ϲ���ʧ��
		boolean result = false;
		int row = idao.insertComment(cb);
		if(row > 0) {
			//����ɹ�
			result =true;
		}
		return result ;
	}

}
