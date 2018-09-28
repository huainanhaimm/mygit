package com.woniuxy.comment.service;

import java.util.List;

import com.woniuxy.comment.bean.GoodsBean;

public interface IGoodsService {
	
	/**
	 * ���յ�ǰҳ��������Ʒ��Ϣ��ҵ��ӿڣ�һ�β�ѯ�������ݣ�
	 * @return ����һ��list�б�
	 */
	public List<GoodsBean> findAll(int currentPage);
	
	/**
	 * ������Ʒһ�����Էֶ���ҳ��һҳ����������ĵ�����һҳ��
	 * @return ��ҳ��
	 */
	public int tolPage();
	
	
	/**
	 * ͨ����Ʒid��ѯ��Ʒ�����ҵ��ӿ�
	 * @param gid
	 * @return
	 */
	public GoodsBean findGoodsById(int gid); 
	
	
	/**
	 * �����Ʒ��ҵ��ӿ�
	 * @param gb
	 */
	public boolean addGoods(GoodsBean gb);
}
