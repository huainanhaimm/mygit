package com.woniuxy.comment.test;

import java.util.List;

import org.junit.Test;

import com.woniuxy.comment.bean.CommentBean;
import com.woniuxy.comment.bean.GoodsBean;
import com.woniuxy.comment.bean.LoginBean;
import com.woniuxy.comment.dao.ICommentDAO;
import com.woniuxy.comment.dao.IGoodsDAO;
import com.woniuxy.comment.dao.ILoginDAO;
import com.woniuxy.comment.daoimpl.CommentDAOImpl;
import com.woniuxy.comment.daoimpl.GoodsDAOImpl;
import com.woniuxy.comment.daoimpl.LoginDAOImpl;


/**
 * ������ �������Գ־ò����
 * ������ݿ�����Ƿ���ȷ
 * @author Administrator
 *
 */
public class TestMain {

	@Test
	public void findByNameAndPass() {
		ILoginDAO idao = new LoginDAOImpl();
		LoginBean lb = new LoginBean();
		lb.setUname("С��");
		lb.setPass("999");
		LoginBean bean = new LoginBean();
		bean = idao.findByNameAndPass(lb);
		System.out.println(bean.getUid());
	}

	@Test
	public void findByName() {
		ILoginDAO idao = new LoginDAOImpl();
		LoginBean bean = new LoginBean();
		bean = idao.findByName("һ");
		System.out.println(bean);
	}

	// �������۲���
	@Test
	public void insertComment() {
		ICommentDAO idao = new CommentDAOImpl();
		CommentBean cb = new CommentBean();
		cb.setContent("������ķ�");

		cb.setGid(6);

		cb.setUid(4);

		int row = idao.insertComment(cb);
		System.out.println(row);
	}

	// ��ѯ��Ʒ������� ���������� ��Ʒ���ࣩ
	@Test
	public void findAll() {
		IGoodsDAO idao = new GoodsDAOImpl();

		List<GoodsBean> list = null;

		list = idao.findAll(0);
		System.out.println(list.size());
		System.out.println(list.get(0).getKb());
	}
	
	
	// ��ѯ��Ʒ��Ϣ������
		@Test
		public void findPage() {
			IGoodsDAO idao = new GoodsDAOImpl();		
			 int tol = idao.findtolPag();
			System.out.println(tol);
			
		}

	/* ͨ��id����Ʒ��ϸ���� */
	@Test
	public void findById() {
		IGoodsDAO idao = new GoodsDAOImpl();

		GoodsBean bean = null;

		bean = idao.findById(2);

	}

	/* ����Ʒ���в�����Ʒ��Ϣ */
//	@Test
//	public void addGods() {
//		IGoodsDAO idao = new GoodsDAOImpl();
//
//		GoodsBean bean = new GoodsBean();
//		bean.setGname("��ʱ���ʷ��");
//		bean.setPrice(100000);
//		bean.setKid(1);
//		
//
//		int row = idao.addGoods(bean);
//		System.out.println(row);
//
//	}

	/* �����ݿ����ע����Ϣ */
	@Test
	public void addAll() {
		ILoginDAO idao = new LoginDAOImpl();

		LoginBean bean = new LoginBean();
		bean.setUname("���� ");
		bean.setPass("fff");

		int row = idao.insertAll(bean);
		System.out.println(row);

	}
	
	@Test
	public void getUname(){
		ILoginDAO idao = new LoginDAOImpl();
		String name = idao.findNameById(1);
		System.out.println(name);
	}

}
