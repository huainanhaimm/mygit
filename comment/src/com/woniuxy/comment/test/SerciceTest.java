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

//对业务处理层进行测试（sevice）
public class SerciceTest {

	// 测试登录功能
	@Test
	public void login() {
		ILoginService ils = new LoginServiceImpl();
		LoginBean lb = new LoginBean();
		lb.setUname("小九");
		lb.setPass("999");
		LoginBean result = ils.findPassByName(lb);
		System.out.println(result);

	}

	// 测试注册功能
	@Test
	public void register() {
		ILoginService ils = new LoginServiceImpl();
		LoginBean lb = new LoginBean();
		lb.setUname("小五");
		lb.setPass("4443333333333333333333");
		String result = ils.register(lb);
		System.out.println(result);

	}

	// 测试查询总页数的业务
	@Test
	public void findTolPage() {
		IGoodsService igs = new GoodsServiceImpl();
		int result = igs.tolPage();

		System.out.println(result);

	}

	// 测试当前页数查询到的要展示的商品信息的业务
	@Test
	public void findAll() {
		IGoodsService igs = new GoodsServiceImpl();
		List<GoodsBean> result = new ArrayList<GoodsBean>();
		result = igs.findAll(2);

		System.out.println(result);

	}
	// 测试查询商品详细信息
		@Test
		public void datails() {
			IGoodsService igs = new GoodsServiceImpl();
			GoodsBean result = new GoodsBean();
			result = igs.findGoodsById(31);

			System.out.println(result);

		}
		

}
