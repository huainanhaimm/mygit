package com.woniuxy.comment.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.ActionContext;
import com.woniuxy.comment.bean.GoodsBean;
import com.woniuxy.comment.service.IGoodsService;
import com.woniuxy.comment.serviceimpl.GoodsServiceImpl;

/**
 * չʾ��Ʒ �б�
 * 
 * @author Administrator
 *
 */
public class ShowGoodsAction {
	// ��ȡ�����ӿ�
	private IGoodsService igs = new GoodsServiceImpl();

	// ��ȡҳ�洫�Σ��ϴ��ĵ�ǰҳ����
	private String current;

	// ������Ӧ�ؿͻ��˵���Ϣ
//	private String result;

	public String execute() {
		// ��ҳ�洫��ת��Ϊint
		int current = 1;
		try {
			current = Integer.parseInt(this.current);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ��ȡ��̨��Ӧ������ֵ
		// 6����Ʒ����
		List<GoodsBean> list = igs.findAll(current);
		// ���ݿ�����ҳ��
		int tolPage = igs.tolPage();
		// ��ȡֵջ����
		ActionContext content = ActionContext.getContext();

		// ����ȡ����ע���Ƿ�ɹ�����Ϣ����ֵջ��request��������
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("tolPage", tolPage);
		content.put("result", map);

		// // ����̨��ǰ̨��Ӧ����ת����json
		// ObjectMapper obj = new ObjectMapper();
		// try {
		// result = obj.writeValueAsString(list);
		// } catch (IOException e) {
		//
		// e.printStackTrace();
		// }
		return "success";
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

//	public String getResult() {
//		return result;
//	}
//
//	public void setResult(String result) {
//		this.result = result;
//	}

}
