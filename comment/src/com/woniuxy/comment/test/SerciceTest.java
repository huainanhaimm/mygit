package com.woniuxy.comment.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.woniuxy.comment.bean.GoodsBean;
import com.woniuxy.comment.bean.LoginBean;
import com.woniuxy.comment.service.IGoodsService;
import com.woniuxy.comment.service.ILoginService;
import com.woniuxy.comment.serviceimpl.GoodsServiceImpl;
import com.woniuxy.comment.serviceimpl.LoginServiceImpl;

//��ҵ�������в��ԣ�sevice��
public class SerciceTest {

	// ���Ե�¼����
	@Test
	public void login() {
		ILoginService ils = new LoginServiceImpl();
		LoginBean lb = new LoginBean();
		lb.setUname("С��");
		lb.setPass("999");
		LoginBean result = ils.findPassByName(lb);
		System.out.println(result);

	}

	// ����ע�Ṧ��
	@Test
	public void register() {
		ILoginService ils = new LoginServiceImpl();
		LoginBean lb = new LoginBean();
		lb.setUname("С��");
		lb.setPass("4443333333333333333333");
		String result = ils.register(lb);
		System.out.println(result);

	}

	// ���Բ�ѯ��ҳ����ҵ��
	@Test
	public void findTolPage() {
		IGoodsService igs = new GoodsServiceImpl();
		int result = igs.tolPage();

		System.out.println(result);

	}

	// ���Ե�ǰҳ����ѯ����Ҫչʾ����Ʒ��Ϣ��ҵ��
	@Test
	public void findAll() {
		IGoodsService igs = new GoodsServiceImpl();
		List<GoodsBean> result = new ArrayList<GoodsBean>();
		result = igs.findAll(2);

		System.out.println(result);

	}
	// ���Բ�ѯ��Ʒ��ϸ��Ϣ
		@Test
		public void datails() {
			IGoodsService igs = new GoodsServiceImpl();
			GoodsBean result = new GoodsBean();
			result = igs.findGoodsById(31);

			System.out.println(result);

		}
		

}
