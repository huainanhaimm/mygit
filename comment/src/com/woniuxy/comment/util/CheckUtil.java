package com.woniuxy.comment.util;

import com.woniuxy.comment.bean.GoodsBean;

public class CheckUtil {
	// �����Ʒ�ϴ�ʱ�����Ƿ�Ϸ�
	public static String checkAddGoods(GoodsBean gb) {
		String result = "";
		//��Ʒ������10����
		if(gb.getGname().length() > 11 ) {
			result = "��Ʒ�����Ϸ�";
		}

			
		
		return result;
	}

}
