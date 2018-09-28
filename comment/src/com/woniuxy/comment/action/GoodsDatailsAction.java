package com.woniuxy.comment.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.woniuxy.comment.bean.CommentBean;
import com.woniuxy.comment.bean.GoodsBean;
import com.woniuxy.comment.service.IGoodsService;
import com.woniuxy.comment.service.ILoginService;
import com.woniuxy.comment.serviceimpl.GoodsServiceImpl;
import com.woniuxy.comment.serviceimpl.LoginServiceImpl;

public class GoodsDatailsAction {
	// ��ǰ�˻�ȡ��Ʒgid
	private int gid;
	//��ȡ��ǰҳ��
	private int current;

	

	public String execute() {
		// ��ȡֵջ����
		ActionContext context = ActionContext.getContext();
		// �Ӻ�˻�ȡ��ѯ����Ʒ������
		IGoodsService igs = new GoodsServiceImpl();
		ILoginService ils = new LoginServiceImpl();

		// ���ղ�ѯ���
		GoodsBean gb = igs.findGoodsById(gid);
//		System.err.println(gb.getPhoto() + "ͼƬ");
		Map<String, Object> map = new HashMap<String, Object>();
		// �����������Ϣʱ����ȡ������
		if (gb.getCblist() != null) {
			List<String> list = new ArrayList<String>();
			for (CommentBean cb : gb.getCblist()) {
				String uname = ils.getName(cb.getUid());
				list.add(uname);
			}
			map.put("uname", list);
		}
		map.put("gb", gb);
	
		// ����ѯ���Ľ��ȫ���浽ֵջ��
		context.put("result", map);
		return "success";
	}

	// ��ȡ����������
	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

}
