package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.bookmanage.bean.BookBean;
import com.bookmanage.bean.UserBean;
import com.bookmanage.dao.IBookDao;
import com.bookmanage.dao.impl.BookDaoImpl;
import com.bookmanage.util.HibernateUtil;

public class DaoTest {
	@Test
	public void test() {
		// 获取session
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("from UserBean");
		List<UserBean> list = query.list();

		for (UserBean Bean : list) {
			System.out.println(Bean.getUname());
		}
	}

	@Test
	public void test2() {
		// 获取session
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("select count(bid)  from BookBean");
		List<Long> list = query.list();
		Long result = list.get(0);
		System.out.println(result);
	}

	@Test
	public void test3() {
		IBookDao ibd = new BookDaoImpl();
		List<BookBean> result = ibd.findSixById(0);
		for (BookBean bookBean : result) {
			System.out.println(bookBean.getBid());
		}
		System.out.println(result.size()+"长度");
	}

}
