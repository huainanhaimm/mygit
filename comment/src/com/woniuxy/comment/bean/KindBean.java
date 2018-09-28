package com.woniuxy.comment.bean;

import java.util.List;

public class KindBean {
	
	private int kid;
	private String kname;
	
	//一个种类(kind)对相应多种商品(goods)
	private List<GoodsBean> gblist;

	@Override
	public String toString() {
		return "KindBean [kid=" + kid + ", kname=" + kname + ", gblist=" + gblist + "]";
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public String getKname() {
		return kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
	}

	public List<GoodsBean> getGblist() {
		return gblist;
	}

	public void setGblist(List<GoodsBean> gblist) {
		this.gblist = gblist;
	}

	
}
