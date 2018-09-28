package com.bookmanage.bean;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.catalina.User;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "t_book")
public class BookBean {
	@Id
	// 增长策略
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bid")
	private int bid;

	@Column(name = "bname")
	private String bname;

	@Column(name = "img")
	private String img;

	@Column(name = "author")
	private String author;

	@Column(name = "publicer")
	private String publicer;

	@Column(name = "time")
	private Date time;

	@Column(name = "price")
	private double price;

	@Column(name = "num")
	private int num;

	@Column(name = "descreption")
	private String descreption;

	// 抓取策略
//	@Fetch(FetchMode.JOIN)
//	public Set<UserBean> subset = new HashSet<UserBean>();
//	private UserBean ub;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublicer() {
		return publicer;
	}

	public void setPublicer(String publicer) {
		this.publicer = publicer;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getDescreption() {
		return descreption;
	}

	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}

//	public Set<UserBean> getSubset() {
//		return subset;
//	}
//
//	public void setSubset(Set<UserBean> subset) {
//		this.subset = subset;
//	}
	
	

}
