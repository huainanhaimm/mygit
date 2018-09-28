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
	// 获取服务层接口
	private IGoodsService igs = new GoodsServiceImpl();
	// 获取商品名称
	private String gname;
	// 获取商品价格
	private String price;
	// 获取商品种类
	private String kind;
	// 获取到文件全路径
	private File imgName;
	// 获取到文件的名字
	private String imgNameFileName;
	// 获取到文件的类型
	private String imgNameContentType;

	private String result;

	// 对上传的文件进行格式的初步验证
	@Override
	public void validate() {
		// 判断是否为空
		if (imgNameFileName == null) {
			addFieldError("fileError", "上传图片不能为空");
		} else if (gname.length() == 0) {
			addFieldError("fileError", "商品名不能为空");
		} else if (price.length() == 0) {
			addFieldError("fileError", "价格不能为空");
		} else {
			// 调用工具方法获取图片后缀名
			String type = getType(imgNameFileName);
			// 如果不是图片，则进行报错提醒
			if (type.equals("png") != true && type.equals("jpg") != true && type.equals("jpeg") != true
					&& type.equals("bmp") != true) {
				addFieldError("fileError", "文件格式错误，本系统仅支持,'tif' ,'jpg', 'jpeg', 'bmp',图片格式");
			}
		}
		// 商品名长度10以内
		if (gname.length() > 10) {
			addFieldError("fileError", "商品名长度超过了10");
		}
	}

	// 辅助工具方法，获取图片名的后缀
	public String getType(String str) {
		String type = "";
		// 解析字符串获取后缀
		type = str.substring(str.indexOf(".") + 1);
		return type;
	}

	public String execute() {

		// 将添加结果存放到request中
		ActionContext content = ActionContext.getContext();
		content.put("result", result);
		// 将图片保存起来，图片存放在服务器，数据库存放图片的名称
		// 获取到服务器的物理路径，通过虚拟路径来获取
		ServletContext context = ServletActionContext.getServletContext();
		String path = context.getRealPath("/upload");
		// 判断文件夹是否存在，如果说不存在就创建一个
		File f = new File(path);
		if (!f.exists())
			f.mkdir();
		// 防止图片名重复变换图片名字
		String relname = changeName(imgNameFileName);
		// 将上传过来的文件保存到tomcat目录下
		try {
			FileUtils.copyFile(imgName, new File(f, relname));
			System.out.println(imgName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 封装商品数据
		GoodsBean gb = new GoodsBean();
		gb.setGname(gname);
		gb.setPrice(Integer.parseInt(price));
		gb.setKid(Integer.parseInt(kind));
		gb.setPhoto(path + relname);
		boolean boo = igs.addGoods(gb);
		if (boo == true) {
			result = "添加成功！";
		} else {
			result = "添加失败！";
		}
		return "success";
	}

	// 工具类、将上传到服务器的图片加一个前缀，防止重复（UUID能产生唯一不重复的字符）
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
