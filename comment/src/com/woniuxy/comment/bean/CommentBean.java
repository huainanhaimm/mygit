package com.woniuxy.comment.bean;

public class CommentBean {

	private int com_id;
	private String com_time;
	private String content;
	private int gid;
	private int uid;
	
	public int getGid() {
		return gid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	private GoodsBean gb;	
	private LoginBean lb;
	
	public int getCom_id() {
		return com_id;
	}

	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}


	public String getCom_time() {
		return com_time;
	}

	public GoodsBean getGb() {
		return gb;
	}

	public void setGb(GoodsBean gb) {
		this.gb = gb;
	}

	public void setCom_time(String com_time) {
		this.com_time = com_time;
	}

	@Override
	public String toString() {
		return "CommentBean [com_id=" + com_id + ", com_time=" + com_time + ", content=" + content + ", gid=" + gid
				+ ", uid=" + uid + ", gb=" + gb + ", lb=" + lb + "]";
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LoginBean getLb() {
		return lb;
	}

	public void setLb(LoginBean lb) {
		this.lb = lb;
	}
	
}
