package com.woniuxy.comment.bean;

import java.util.List;

public class GoodsBean {
	

	@Override
	public String toString() {
		return "GoodsBean [gid=" + gid + ", gname=" + gname + ", price=" + price + ", kid=" + kid + ", photo=" + photo
				+ ", num=" + num + ", tol=" + tol + ", kb=" + kb + ", cblist=" + cblist + "]";
	}



	private int gid;
	private String gname;
	private int price;
	//外键列
	private int kid;
	


	//图片的地址
	private String photo;
	//评论条数
	private int num;
	//goods表共有的数据条数
	private int tol;
	
	public int getTol() {
		return tol;
	}


	public void setTol(int tol) {
		this.tol = tol;
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}


	
	// 商品种类对象
	private KindBean kb;
	// 一种商品(goods)对相应多条评论(comment)
	private List<CommentBean> cblist;

	public List<CommentBean> getCblist() {
		return cblist;
	}

	public void setCblist(List<CommentBean> cblist) {
		this.cblist = cblist;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public KindBean getKb() {
		return kb;
	}

	public void setKb(KindBean kb) {
		this.kb = kb;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
