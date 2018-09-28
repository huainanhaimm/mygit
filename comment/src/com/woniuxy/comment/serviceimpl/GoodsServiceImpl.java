package com.woniuxy.comment.serviceimpl;

import java.util.List;

import com.woniuxy.comment.bean.GoodsBean;
import com.woniuxy.comment.dao.IGoodsDAO;
import com.woniuxy.comment.daoimpl.GoodsDAOImpl;
import com.woniuxy.comment.service.IGoodsService;

public class GoodsServiceImpl implements IGoodsService {

	/**
	 * (i*6)-6 ��ǰҳ����ʾ��Ʒ��������
	 */
	IGoodsDAO dao = new GoodsDAOImpl();

	@Override
	public List<GoodsBean> findAll(int currentPage) {
		// Ĭ�ϵ�ǰҳΪ1
		int page = 1;
		page = currentPage;
		// ���ϴ������ĵ�ǰҳ�룬ת����ÿҳ��Ʒ��ʼ���±�
		// ��һҳ�±��0��ʼ�� 0~5����6~11����12~17��
		int index = (page - 1) * 6;
		List<GoodsBean> list = dao.findAll(index);
		return list;
	}

	@Override
	public int tolPage() {
		// Ĭ����ҳ��Ϊ1ҳ
		int tolPage = 1;
		// ��ѯ�����ж���������
		int result = dao.findtolPag();
		// ����һ�����Էֶ���ҳ
		if (result % 6 == 0) {
			tolPage = result / 6;
		} else {
			tolPage = (result / 6) + 1;
		}

		return tolPage;
	}

	/**
	 * ��ѯ��Ʒ����ϸ��Ϣ
	 */
	@Override
	public GoodsBean findGoodsById(int gid) {
		GoodsBean bean = null;
		bean = dao.findById(gid);
		return bean;
	}

	/**
	 * �����Ʒ
	 */
	@Override
	public boolean addGoods(GoodsBean gb) {
		// �洢�����Ʒ�Ľ��
		boolean result = false;
		// �����ݿ������Ʒͬʱ��ȡ��ӽ����һ�����������
		int row = dao.addGoods(gb);
		if (row > 0) {
			result = true;
		}
		return result;
	}

}
