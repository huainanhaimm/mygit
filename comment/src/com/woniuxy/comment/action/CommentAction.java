package com.woniuxy.comment.action;

import com.opensymphony.xwork2.ActionContext;
import com.woniuxy.comment.bean.CommentBean;
import com.woniuxy.comment.bean.LoginBean;
import com.woniuxy.comment.service.ICommentService;
import com.woniuxy.comment.serviceimpl.CommentServiceImpl;

/**
 * ���������Ϣ
 * 
 * @author Administrator
 *
 */
public class CommentAction {
	// ��ȡҳ�洫��
	private int gid;
	private String content;
	// �����Ƿ�ɹ�
	private String result;
	// �洢��¼״̬
	private String relogin;

	public String execute() {
		// ��ȡrequest
		ActionContext context = ActionContext.getContext();
		// ȡ���û���id
		LoginBean lb = (LoginBean) ActionContext.getContext().getSession().get("acount");
		if (lb != null) {
			int uid = lb.getUid();
			// �������۱��ʵ�����
			CommentBean cb = new CommentBean();
			// ��gid �������ݡ�uid��װ�����۶���
			cb.setUid(uid);
			cb.setContent(content);
			cb.setGid(gid);
			// ���÷���㷽��ִ������ҵ��
			ICommentService ics = new CommentServiceImpl();
			boolean rebool = ics.addComment(cb);
			if (rebool == true) {
				result = "���۳ɹ�";
			} else {
				result = "����ʧ��";
			}

		} else {
			result = "��¼��ʱ�����µ�¼";

		}
		// �洢Ҫ��Ӧ����Ϣ
		context.put("result", result);
		return "success";
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
