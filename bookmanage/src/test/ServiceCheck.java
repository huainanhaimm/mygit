package test;

import java.util.List;

import org.junit.Test;

import com.bookmanage.bean.BookBean;
import com.bookmanage.bean.UserBean;
import com.bookmanage.service.ILoginService;
import com.bookmanage.service.IShowBookService;
import com.bookmanage.service.impl.LoginServiceImpl;
import com.bookmanage.service.impl.ShowBookServiceImpl;

/**
 * 业务层单元测试
 * 
 * @author Administrator
 *
 */
public class ServiceCheck {
	// 登录结果测试
	@Test
	public void test1() {
		ILoginService ils = new LoginServiceImpl();
		UserBean ub = new UserBean();
		ub.setUname("小一.");
		ub.setPass("yyy");
		boolean result = ils.login(ub);
		System.out.println(result);
	}

	// 图书总条数（页数）测试
	@Test
	public void test2() {
		IShowBookService ibs = new ShowBookServiceImpl();
		long result = ibs.tolPage();
		System.out.println(result);
	}

	// 图书列表测试
	@Test
	public void test3() {
		IShowBookService ibs = new ShowBookServiceImpl();
		 List<BookBean> result = ibs.paging(1);
		System.out.println(result.size());
	}
}
