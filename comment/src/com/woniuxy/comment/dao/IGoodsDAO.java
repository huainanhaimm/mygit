package com.woniuxy.comment.dao;

import java.util.List;

import com.woniuxy.comment.bean.GoodsBean;

public interface IGoodsDAO {
	/**
	 * ���յ�ǰҳ����ѯ��6������Ʒ����
	 * @return
	 */
	public List<GoodsBean> findAll(int index);
	
	/**
	 * ʹ�þۺϺ��� ����id��ѯ����������Ʒ��Ϣ��Ϊҵ����ṩ������ҳ�������ݣ�
	 * @return
	 */
	public int findtolPag();
	
	public GoodsBean findById(int gid);

	public int addGoods(GoodsBean gb);


	
	
	

}
