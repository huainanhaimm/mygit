package com.woniuxy.comment.util;

import com.woniuxy.comment.bean.GoodsBean;

public class CheckUtil {
	// 检查商品上传时数据是否合法
	public static String checkAddGoods(GoodsBean gb) {
		String result = "";
		//商品名长度10以内
		if(gb.getGname().length() > 11 ) {
			result = "商品名不合法";
		}

			
		
		return result;
	}

}
