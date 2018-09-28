package com.woniuxy.comment.action;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.woniuxy.comment.bean.GoodsBean;
import com.woniuxy.comment.service.IGoodsService;
import com.woniuxy.comment.serviceimpl.GoodsServiceImpl;

public class AddGoodsAction extends ActionSupport {
	// ��ȡ�����ӿ�
	private IGoodsService igs = new GoodsServiceImpl();
	// ��ȡ��Ʒ����
	private String gname;
	// ��ȡ��Ʒ�۸�
	private String price;
	// ��ȡ��Ʒ����
	private String kind;
	// ��ȡ���ļ�ȫ·��
	private File imgName;
	// ��ȡ���ļ�������
	private String imgNameFileName;
	// ��ȡ���ļ�������
	private String imgNameContentType;

	private String result;

	// ���ϴ����ļ����и�ʽ�ĳ�����֤
	@Override
	public void validate() {
		// �ж��Ƿ�Ϊ��
		if (imgNameFileName == null) {
			addFieldError("fileError", "�ϴ�ͼƬ����Ϊ��");
		} else if (gname.length() == 0) {
			addFieldError("fileError", "��Ʒ������Ϊ��");
		} else if (price.length() == 0) {
			addFieldError("fileError", "�۸���Ϊ��");
		} else {
			// ���ù��߷�����ȡͼƬ��׺��
			String type = getType(imgNameFileName);
			// �������ͼƬ������б�������
			if (type.equals("png") != true && type.equals("jpg") != true && type.equals("jpeg") != true
					&& type.equals("bmp") != true) {
				addFieldError("fileError", "�ļ���ʽ���󣬱�ϵͳ��֧��,'tif' ,'jpg', 'jpeg', 'bmp',ͼƬ��ʽ");
			}
		}
		// ��Ʒ������10����
		if (gname.length() > 10) {
			addFieldError("fileError", "��Ʒ�����ȳ�����10");
		}
	}

	// �������߷�������ȡͼƬ���ĺ�׺
	public String getType(String str) {
		String type = "";
		// �����ַ�����ȡ��׺
		type = str.substring(str.indexOf(".") + 1);
		return type;
	}

	public String execute() {

		// ����ӽ����ŵ�request��
		ActionContext content = ActionContext.getContext();
		content.put("result", result);
		// ��ͼƬ����������ͼƬ����ڷ����������ݿ���ͼƬ������
		// ��ȡ��������������·����ͨ������·������ȡ
		ServletContext context = ServletActionContext.getServletContext();
		String path = context.getRealPath("/upload");
		// �ж��ļ����Ƿ���ڣ����˵�����ھʹ���һ��
		File f = new File(path);
		if (!f.exists())
			f.mkdir();
		// ��ֹͼƬ���ظ��任ͼƬ����
		String relname = changeName(imgNameFileName);
		// ���ϴ��������ļ����浽tomcatĿ¼��
		try {
			FileUtils.copyFile(imgName, new File(f, relname));
			System.out.println(imgName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ��װ��Ʒ����
		GoodsBean gb = new GoodsBean();
		gb.setGname(gname);
		gb.setPrice(Integer.parseInt(price));
		gb.setKid(Integer.parseInt(kind));
		gb.setPhoto(path + relname);
		boolean boo = igs.addGoods(gb);
		if (boo == true) {
			result = "��ӳɹ���";
		} else {
			result = "���ʧ�ܣ�";
		}
		return "success";
	}

	// �����ࡢ���ϴ�����������ͼƬ��һ��ǰ׺����ֹ�ظ���UUID�ܲ���Ψһ���ظ����ַ���
	public String changeName(String name) {

		String newName = UUID.randomUUID() + "_" + name;

		return newName;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public File getImgName() {
		return imgName;
	}

	public void setImgName(File imgName) {
		this.imgName = imgName;
	}

	public String getImgNameFileName() {
		return imgNameFileName;
	}

	public void setImgNameFileName(String imgNameFileName) {
		this.imgNameFileName = imgNameFileName;
	}

	public String getImgNameContentType() {
		return imgNameContentType;
	}

	public void setImgNameContentType(String imgNameContentType) {
		this.imgNameContentType = imgNameContentType;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
