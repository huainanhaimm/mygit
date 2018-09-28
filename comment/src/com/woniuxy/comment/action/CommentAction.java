package com.woniuxy.comment.action;

import com.opensymphony.xwork2.ActionContext;
import com.woniuxy.comment.bean.CommentBean;
import com.woniuxy.comment.bean.LoginBean;
import com.woniuxy.comment.service.ICommentService;
import com.woniuxy.comment.serviceimpl.CommentServiceImpl;

/**
 * 添加评论信息
 * 
 * @author Administrator
 *
 */
public class CommentAction {
	// 获取页面传参
	private int gid;
	private String content;
	// 评论是否成功
	private String result;
	// 存储登录状态
	private String relogin;

	public String execute() {
		// 获取request
		ActionContext context = ActionContext.getContext();
		// 取出用户名id
		LoginBean lb = (LoginBean) ActionContext.getContext().getSession().get("acount");
		if (lb != null) {
			int uid = lb.getUid();
			// 创建评论表的实体对象
			CommentBean cb = new CommentBean();
			// 将gid 评论内容、uid封装到评论对象
			cb.setUid(uid);
			cb.setContent(content);
			cb.setGid(gid);
			// 调用服务层方法执行评论业务
			ICommentService ics = new CommentServiceImpl();
			boolean rebool = ics.addComment(cb);
			if (rebool == true) {
				result = "评论成功";
			} else {
				result = "评论失败";
			}

		} else {
			result = "登录超时请重新登录";

		}
		// 存储要响应的信息
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
