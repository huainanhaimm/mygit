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
 * 主测试 类作测试持久层测试
 * 检测数据库操作是否正确
 * @author Administrator
 *
 */
public class TestMain {

	@Test
	public void findByNameAndPass() {
		ILoginDAO idao = new LoginDAOImpl();
		LoginBean lb = new LoginBean();
		lb.setUname("小九");
		lb.setPass("999");
		LoginBean bean = new LoginBean();
		bean = idao.findByNameAndPass(lb);
		System.out.println(bean.getUid());
	}

	@Test
	public void findByName() {
		ILoginDAO idao = new LoginDAOImpl();
		LoginBean bean = new LoginBean();
		bean = idao.findByName("一");
		System.out.println(bean);
	}

	// 插入评论测试
	@Test
	public void insertComment() {
		ICommentDAO idao = new CommentDAOImpl();
		CommentBean cb = new CommentBean();
		cb.setContent("你是真的烦");

		cb.setGid(6);

		cb.setUid(4);

		int row = idao.insertComment(cb);
		System.out.println(row);
	}

	// 查询商品类表（包括 评论条数和 商品种类）
	@Test
	public void findAll() {
		IGoodsDAO idao = new GoodsDAOImpl();

		List<GoodsBean> list = null;

		list = idao.findAll(0);
		System.out.println(list.size());
		System.out.println(list.get(0).getKb());
	}
	
	
	// 查询商品信息的条数
		@Test
		public void findPage() {
			IGoodsDAO idao = new GoodsDAOImpl();		
			 int tol = idao.findtolPag();
			System.out.println(tol);
			
		}

	/* 通过id查商品详细资料 */
	@Test
	public void findById() {
		IGoodsDAO idao = new GoodsDAOImpl();

		GoodsBean bean = null;

		bean = idao.findById(2);

	}

	/* 向商品表中插入商品信息 */
//	@Test
//	public void addGods() {
//		IGoodsDAO idao = new GoodsDAOImpl();
//
//		GoodsBean bean = new GoodsBean();
//		bean.setGname("《时间简史》");
//		bean.setPrice(100000);
//		bean.setKid(1);
//		
//
//		int row = idao.addGoods(bean);
//		System.out.println(row);
//
//	}

	/* 向数据库插入注册信息 */
	@Test
	public void addAll() {
		ILoginDAO idao = new LoginDAOImpl();

		LoginBean bean = new LoginBean();
		bean.setUname("菲兹 ");
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
