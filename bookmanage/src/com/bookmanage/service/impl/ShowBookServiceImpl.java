package com.bookmanage.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bookmanage.bean.BookBean;
import com.bookmanage.dao.IBookDao;
import com.bookmanage.dao.impl.BookDaoImpl;
import com.bookmanage.service.IShowBookService;

public class ShowBookServiceImpl implements IShowBookService {

	@Override
	public List<BookBean> paging(int current) {
		// 实例化持久层
		IBookDao ibd = new BookDaoImpl();
		// 存储查询结果
		List<BookBean> list = null;
		//当前页转化为数据下标（0-5   6-11   12-17）
		int index = (current-1)*6;
		// 调用持久层方法获取查询结果
		list = ibd.findSixById(index);
		return list;
	}

	@Override
	public Long tolPage() {
		// 存储总页数,默认为1
		Long result = 1L;
		// 实例化持久层
		IBookDao ibd = new BookDaoImpl();
		// 调用持久层方法获取共有多少条图书信息
		Long num = ibd.findAll();
		// 数据最后一页不足六条也为一页（标为六条一页）
		if (num % 6 == 0) {
			result = num / 6;
		} else {
			result = (num / 6) + 1;
		}

		return result;
	}

}
